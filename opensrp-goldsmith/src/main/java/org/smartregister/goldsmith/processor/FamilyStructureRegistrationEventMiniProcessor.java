package org.smartregister.goldsmith.processor;

import android.content.ContentValues;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mapbox.geojson.Feature;

import org.smartregister.CoreLibrary;
import org.smartregister.commonregistry.AllCommonsRepository;
import org.smartregister.domain.Event;
import org.smartregister.domain.Geometry;
import org.smartregister.domain.Location;
import org.smartregister.domain.LocationProperty;
import org.smartregister.domain.Obs;
import org.smartregister.domain.db.EventClient;
import org.smartregister.domain.jsonmapping.ClientClassification;
import org.smartregister.goldsmith.util.Constants;
import org.smartregister.goldsmith.util.JsonFormUtils;
import org.smartregister.repository.StructureRepository;
import org.smartregister.sync.MiniClientProcessorForJava;
import org.smartregister.tasking.util.TaskingConstants;
import org.smartregister.view.activity.DrishtiApplication;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import timber.log.Timber;

/**
 * Created by Ephraim Kigamba - nek.eam@gmail.com on 08-01-2021.
 */
public class FamilyStructureRegistrationEventMiniProcessor implements MiniClientProcessorForJava {

    public HashSet<String> eventTypes = new HashSet<>();

    public FamilyStructureRegistrationEventMiniProcessor() {
        eventTypes.add(Constants.GoldsmithEventTypes.REGISTER_FAMILY_STRUCTURE_EVENT);
    }

    @NonNull
    @Override
    public HashSet<String> getEventTypes() {
        return eventTypes;
    }

    @Override
    public boolean canProcess(@NonNull String s) {
        return eventTypes.contains(s);
    }

    @Override
    public void processEventClient(@NonNull EventClient eventClient, @NonNull List<Event> unsyncEventsList, @Nullable ClientClassification clientClassification) throws Exception {
        Event structureRegistrationEvent = eventClient.getEvent();

        StructureRepository structureRepository = CoreLibrary.getInstance().context().getStructureRepository();

        Location location = new Location();
        location.setJurisdiction(false);
        Feature feature = null;

        for (Obs obs: structureRegistrationEvent.getObs()) {
            if ("geojson".equals(obs.getFormSubmissionField()) && obs.getValues() != null && obs.getValues().size() > 0) {
                Object geojson = obs.getValues().get(0);
                if (geojson instanceof String) {
                    feature = Feature.fromJson((String) geojson);
                    break;
                }
            }
        }

        if (feature != null) {
            location.setGeometry(JsonFormUtils.gson.fromJson(feature.geometry().toJson(), Geometry.class));
            JsonObject properties = feature.properties();

            LocationProperty locationProperties = new LocationProperty();
            HashMap<String, String> customProperties = new HashMap<>();
            String locationUUID = feature.getStringProperty("uuid");

            Iterator<Map.Entry<String, JsonElement>> entriesIterator = properties.entrySet().iterator();

            location.setId(feature.getStringProperty("id"));
            locationProperties.setParentId(feature.getStringProperty("parentId"));
            locationProperties.setUid(locationUUID);

            while (entriesIterator.hasNext()) {
                Map.Entry<String, JsonElement> propertyEntry = entriesIterator.next();
                customProperties.put(propertyEntry.getKey(), propertyEntry.getValue().toString());
            }

            locationProperties.setCustomProperties(customProperties);
            location.setProperties(locationProperties);
            location.setType("Feature");

            structureRepository.addOrUpdate(location);

            String familyEntityId = eventClient.getClient().getBaseEntityId();

            ContentValues contentValues = new ContentValues();
            contentValues.put("id", familyEntityId);
            contentValues.put("structure_uuid", locationUUID);
            contentValues.put("family_base_entity_id", familyEntityId);

            long insertedRecords = DrishtiApplication.getInstance().getRepository()
                    .getWritableDatabase()
                    .insert(TaskingConstants.Tables.STRUCTURE_FAMILY_RELATIONSHIP, null, contentValues);

            AllCommonsRepository allCommonsRepository = CoreLibrary.getInstance().context().
                    allCommonsRepositoryobjects(TaskingConstants.Tables.STRUCTURE_FAMILY_RELATIONSHIP);

            if (allCommonsRepository != null) {
                allCommonsRepository.updateSearch(familyEntityId);
                Timber.d("Finished updateFTSsearch table: " + TaskingConstants.Tables.STRUCTURE_FAMILY_RELATIONSHIP);
            }

            if (insertedRecords > 0) {
                Timber.i("Structure-Family relationship added");
            } else {
                Timber.i("Structure-Family relationship added");
            }
        }
    }

    @Override
    public boolean unSync(@Nullable List<Event> list) {
        return false;
    }
}

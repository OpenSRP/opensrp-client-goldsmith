package org.smartregister.opensrp.configurable.register.and.profiles.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.apache.commons.lang3.tuple.Triple;
import org.json.JSONException;
import org.json.JSONObject;
import org.smartregister.domain.db.EventClient;
import org.smartregister.domain.tag.FormTag;
import org.smartregister.opensrp.configurable.register.and.profiles.pojo.RegisterParams;
import org.smartregister.view.contract.BaseRegisterContract;

import java.util.List;

public interface ConfigurableRegisterActivityContract {

    interface View extends BaseRegisterContract.View {
        Presenter presenter();

    }

    interface Presenter extends BaseRegisterContract.Presenter {

        void saveLanguage(String language);

        void startForm(String formName, String entityId, String metadata, String currentLocationId);

        void saveForm(String jsonString, @NonNull RegisterParams registerParams);

        Interactor createInteractor();
    }

    interface Model {

        JSONObject getFormAsJson(String formName, String entityId,
                                 String currentLocationId) throws JSONException;

        void registerViewConfigurations(List<String> viewIdentifiers);

        void unregisterViewConfiguration(List<String> viewIdentifiers);

        void saveLanguage(String language);

        List<EventClient> processRegistration(String jsonString, FormTag formTag);

        String getLocationId(String locationName);

        String getInitials();
    }

    interface Interactor {

        void onDestroy(boolean isChangingConfiguration);

        void getNextUniqueId(Triple<String, String, String> triple, ConfigurableRegisterActivityContract.InteractorCallBack callBack);

        void saveRegistration(@Nullable final List<EventClient> clientList, final String jsonString, @NonNull RegisterParams registerParams, final ConfigurableRegisterActivityContract.InteractorCallBack callBack);

    }

    interface InteractorCallBack {

        void onUniqueIdFetched(Triple<String, String, String> triple, String entityId);

        void onNoUniqueId();

        void onRegistrationSaved(@NonNull RegisterParams registerParams, @Nullable List<EventClient> clientList);
    }
}

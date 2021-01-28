package org.smartregister.goldsmith.configuration.allfamilies;

import android.os.Build;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.smartregister.clientandeventmodel.Client;
import org.smartregister.family.domain.FamilyEventClient;
import org.smartregister.goldsmith.TestApplication;

/**
 * Created by Ephraim Kigamba - nek.eam@gmail.com on 08-01-2021.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class, sdk = Build.VERSION_CODES.O_MR1)
public class AllFamiliesFormProcessorTest {

    @Test
    public void testGenerateStructureRegistrationEvent() throws JSONException {
        String jsonForm = "{\"validate_on_submit\":true,\"show_errors_on_submit\":false,\"count\":\"2\",\"encounter_type\":\"Family Registration\",\"entity_id\":\"\",\"relational_id\":\"\",\"metadata\":{\"start\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"start\",\"openmrs_entity_id\":\"163137AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"},\"end\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"end\",\"openmrs_entity_id\":\"163138AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"},\"today\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"encounter\",\"openmrs_entity_id\":\"encounter_date\"},\"deviceid\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"deviceid\",\"openmrs_entity_id\":\"163149AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"},\"subscriberid\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"subscriberid\",\"openmrs_entity_id\":\"163150AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"},\"simserial\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"simserial\",\"openmrs_entity_id\":\"163151AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"},\"phonenumber\":{\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_data_type\":\"phonenumber\",\"openmrs_entity_id\":\"163152AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"},\"encounter_location\":\"\",\"look_up\":{\"entity_id\":\"\",\"value\":\"\"}},\"step1\":{\"title\":\"Family details\",\"next\":\"step2\",\"fields\":[{\"key\":\"fam_name\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"first_name\",\"type\":\"edit_text\",\"hint\":\"Family name\",\"edit_type\":\"name\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the family name\"},\"v_regex\":{\"value\":\"[A-Za-z\\\\u00C0-\\\\u017F\\\\s\\\\u00C0-\\\\u017F\\\\.\\\\-]*\",\"err\":\"Please enter a valid name\"}},{\"key\":\"unique_id\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_identifier\",\"openmrs_entity_id\":\"opensrp_id\",\"hidden\":\"true\",\"type\":\"barcode\",\"barcode_type\":\"qrcode\",\"hint\":\"ID *\",\"scanButtonText\":\"Scan QR Code\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Please enter a valid ID\"}},{\"key\":\"village_town\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_address\",\"openmrs_entity_id\":\"cityVillage\",\"type\":\"edit_text\",\"hint\":\"Village/Town\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the village or town\"}},{\"key\":\"quarter_clan\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_address\",\"openmrs_entity_id\":\"commune\",\"type\":\"edit_text\",\"hint\":\"Quarter\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the quarter\"}},{\"key\":\"street\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_address\",\"openmrs_entity_id\":\"street\",\"type\":\"edit_text\",\"hint\":\"Street\"},{\"key\":\"landmark\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_address\",\"openmrs_entity_id\":\"landmark\",\"type\":\"edit_text\",\"hint\":\"Landmark\"},{\"key\":\"gps\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"163277AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"openmrs_data_type\":\"text\",\"type\":\"gps\",\"value\":\"9.000 5.000\"},{\"key\":\"spacer\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"\",\"type\":\"spacer\",\"spacer_height\":\"15dp\"},{\"key\":\"fam_source_income\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_attribute\",\"openmrs_entity_id\":\"fam_source_income\",\"openmrs_data_type\":\"\",\"type\":\"spinner\",\"hint\":\"Family source of income\",\"values\":[\"Petty trade\",\"Agriculture, hunting and fishing\",\"Exploitation of mines and quarries\",\"Manufacturing industry\",\"Construction\",\"Electricity, gas and water\",\"Commercial, hotels and restaurants\",\"Transport, storage and communications\",\"Financial institutions\",\"Communication, social and personal services\",\"Other\"],\"openmrs_choice_ids\":{\"Petty trade\":\"1539AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Agriculture, hunting and fishing\":\"165411AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Exploitation of mines and quarries\":\"165412AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Manufacturing industry\":\"165407AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Construction\":\"165408AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Electricity, gas and water\":\"165409AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Commercial, hotels and restaurants\":\"165410AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Transport, storage and communications\":\"165413AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Financial institutions\":\"165414AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Communication, social and personal services\":\"165415AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Other\":\"5622AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"}}]},\"step2\":{\"title\":\"Family head\",\"fields\":[{\"key\":\"photo\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"\",\"type\":\"choose_image\",\"uploadButtonText\":\"Take a picture of the person\"},{\"key\":\"unique_id\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_identifier\",\"openmrs_entity_id\":\"opensrp_id\",\"type\":\"edit_text\",\"hint\":\"ID *\",\"value\":\"0\",\"read_only\":\"true\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Please enter a valid ID\"},\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the ID\"}},{\"key\":\"national_id\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"163084AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"label_info_text\":\"What is their national identity number or their voter registration number?\",\"label_info_title\":\"National ID number\",\"type\":\"edit_text\",\"hint\":\"National ID number\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Must be a number.\"}},{\"key\":\"surname\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"\",\"type\":\"edit_text\",\"hint\":\"Surname\",\"edit_type\":\"name\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the surname\"},\"v_regex\":{\"value\":\"[A-Za-z\\\\u00C0-\\\\u017F\\\\s\\\\u00C0-\\\\u017F\\\\.\\\\-]*\",\"err\":\"Please enter a valid name\"},\"relevance\":{\"rules-engine\":{\"ex-rules\":{\"rules-file\":\"family-register-relevance.yml\"}}}},{\"key\":\"same_as_fam_name\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"\",\"type\":\"check_box\",\"label\":\"\",\"options\":[{\"key\":\"same_as_fam_name\",\"text\":\"Surname same as family name\",\"text_size\":\"18px\",\"value\":\"false\"}]},{\"key\":\"surname_calculation\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"last_name\",\"type\":\"edit_text\",\"hidden\":true,\"hint\":\"Surname as Family name\",\"calculation\":{\"rules-engine\":{\"ex-rules\":{\"rules-file\":\"family-register-calculation.yml\"}}}},{\"key\":\"first_name\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"first_name\",\"type\":\"edit_text\",\"hint\":\"First name\",\"edit_type\":\"name\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the first name\"},\"v_regex\":{\"value\":\"[A-Za-z\\\\u00C0-\\\\u017F\\\\s\\\\u00C0-\\\\u017F\\\\.\\\\-]*\",\"err\":\"Please enter a valid name\"}},{\"key\":\"middle_name\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"middle_name\",\"type\":\"edit_text\",\"hint\":\"Middle name\",\"edit_type\":\"name\",\"v_regex\":{\"value\":\"[A-Za-z\\\\u00C0-\\\\u017F\\\\s\\\\u00C0-\\\\u017F\\\\.\\\\-]*\",\"err\":\"Please enter a valid name\"}},{\"key\":\"dob\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"birthdate\",\"type\":\"date_picker\",\"hint\":\"Date of birth (DOB)\",\"expanded\":false,\"duration\":{\"label\":\"Age\"},\"min_date\":\"today-120y\",\"max_date\":\"today-15y\",\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the date of birth\"},\"relevance\":{\"rules-engine\":{\"ex-rules\":{\"rules-file\":\"family-register-relevance.yml\"}}}},{\"key\":\"dob_unknown\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"birthdateApprox\",\"type\":\"check_box\",\"label\":\"\",\"options\":[{\"key\":\"dob_unknown\",\"text\":\"DOB unknown?\",\"text_size\":\"18px\",\"value\":\"false\"}]},{\"key\":\"age\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person_attribute\",\"openmrs_entity_id\":\"age_entered\",\"type\":\"edit_text\",\"hint\":\"Age\",\"v_numeric_integer\":{\"value\":\"true\",\"err\":\"Must be a rounded number\"},\"v_numeric\":{\"value\":\"true\",\"err\":\"Number must begin with 0 and must be a total of 10 digits in length\"},\"v_min\":{\"value\":\"15\",\"err\":\"Age must be equal or greater than 15\"},\"v_max\":{\"value\":\"120\",\"err\":\"Age must be equal or less than 120\"},\"relevance\":{\"rules-engine\":{\"ex-rules\":{\"rules-file\":\"family-register-relevance.yml\"}}},\"v_required\":{\"value\":true,\"err\":\"Please enter the age\"}},{\"key\":\"sex\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"person\",\"openmrs_entity_id\":\"gender\",\"type\":\"spinner\",\"hint\":\"Sex\",\"values\":[\"Male\",\"Female\"],\"v_required\":{\"value\":\"true\",\"err\":\"Please enter the sex\"}},{\"key\":\"phone_number\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"159635AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"type\":\"edit_text\",\"hint\":\"Phone number\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Must be a number.\"},\"v_required\":{\"value\":false,\"err\":\"Please specify the phone number\"}},{\"key\":\"other_phone_number\",\"openmrs_entity_parent\":\"159635AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"5622AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"type\":\"edit_text\",\"hint\":\"Other phone number\",\"v_numeric\":{\"value\":\"true\",\"err\":\"Must be a number.\"}},{\"key\":\"highest_edu_level\",\"openmrs_entity_parent\":\"\",\"openmrs_entity\":\"concept\",\"openmrs_entity_id\":\"1712AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"openmrs_data_type\":\"select one\",\"type\":\"spinner\",\"hint\":\"Highest education level\",\"values\":[\"None\",\"Literacy\",\"Primary\",\"Secondary\",\"University\"],\"openmrs_choice_ids\":{\"None\":\"1107AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Literacy\":\"\",\"Primary\":\"1713AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"Secondary\":\"1714AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\"University\":\"159785AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"}}]}}";
        Client familyClient = new Client("base-entity-id");


        AllFamiliesFormProcessor allFamiliesFormProcessor = new AllFamiliesFormProcessor();
        FamilyEventClient familyEventClient = allFamiliesFormProcessor.generateStructureRegistrationEvent(jsonForm, familyClient);

        Assert.assertEquals("base-entity-id", familyEventClient.getEvent().getBaseEntityId());
        Assert.assertEquals(5, familyEventClient.getEvent().getObs().size());


        Assert.assertNotNull(familyEventClient.getEvent().getObs().get(0).getValues().get(0));
        Assert.assertEquals(familyEventClient.getEvent().getObs().get(0).getValues().get(0)
                , familyEventClient.getEvent().getObs().get(1).getValues().get(0));
        Assert.assertEquals("9.000", familyEventClient.getEvent().getObs().get(2).getValues().get(0));
        Assert.assertEquals("5.000", familyEventClient.getEvent().getObs().get(3).getValues().get(0));
        Assert.assertNotNull(familyEventClient.getEvent().getObs().get(4).getValues().get(0));
    }
}
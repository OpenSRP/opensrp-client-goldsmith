package org.smartregister.goldsmith.util;

import org.smartregister.chw.core.utils.CoreConstants;

public class Constants extends CoreConstants {

    public interface RegisterViewConstants {

        interface ModuleOptions {
            String ANC =  "ANC";
            String PNC = "PNC";
            String ALL_FAMILIES = "All Families";
        }

        interface Provider {
            String CLIENT_COLUMN = "client_column";
            String ACTION_BUTTON_COLUMN = "action_button_column";
        }
    }

    public interface Client {
        String PHONE_NUMBER = "phone_number";
        String FIRST_NAME = "first_name";
    }

    public static class IntentKeys {
        public static String GENDER = "gender";
        public static String DOB = "dob";
    }


    public static final class DATE_FORMATS {
        public static final String HOME_VISIT_DISPLAY = "dd MMM yyyy";
    }

    public interface FORM_SUBMISSION_FIELD {
        String pncHfNextVisitDateFieldType = "pnc_hf_next_visit_date";
    }

    public static final class EventType {
        public static final String PREGNANCY_OUTCOME = "Pregnancy_Outcome";
    }
}

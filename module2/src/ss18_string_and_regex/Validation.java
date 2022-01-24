package ss18_string_and_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
        private static Pattern pattern;
        private Matcher matcher;

        private static final String EMAIL_REGEX = "[\\w]+@\\w+(\\.[\\w]+)+";
        private static final String ACCOUNT_REGEX = "[a-z0-9_]{6,}";
        private static final String CLASS_NAME_REGEX = "[CAP][0-9]{4}[GHIKLM]";
        private static final String PHONE_NUMBER_REGEX = "\\(\\d{2}\\)-\\(\\d{10}\\)";

        public Validation() {
        }

        public boolean validateEmail(String regex) {
            matcher = Pattern.compile(EMAIL_REGEX).matcher(regex);
            return matcher.matches();
        }

        public boolean validateAccount(String regex){
            matcher = Pattern.compile(ACCOUNT_REGEX).matcher(regex);
            return matcher.matches();
        }

        public boolean validateClassName(String regex){
            matcher = Pattern.compile(CLASS_NAME_REGEX).matcher(regex);
            return matcher.matches();
        }

        public boolean validatePhoneNumber(String regex){
            matcher = Pattern.compile(PHONE_NUMBER_REGEX).matcher(regex);
            return matcher.matches();
        }
}

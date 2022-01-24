package FuramaResort.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private Pattern pattern;
    private Matcher matcher;

    private static final String VILLA_ID_SERVICE_REGEX = "^SVVL-\\d{4}$";
    private static final String HOUSE_ID_SERVICE_REGEX = "^SVHO-\\d{4}$";
    private static final String ROOM_ID_SERVICE_REGEX = "^SVRO-\\d{4}$";
    private static final String SERVICE_NAME_REGEX = "^[A-Z][a-z0-9]+$";
    private static final String RENT_TYPE_REGEX = "^[A-Z][a-z0-9]+$";
    private static final String VILLA_TYPE_REGEX = "^[A-Z][a-z0-9]+$";
    private static final String HOUSE_TYPE_REGEX = "^[A-Z][a-z0-9]+$";

    public Validation() {
    }

    public boolean validateVillaIDService(String regex) {
        matcher = Pattern.compile(VILLA_ID_SERVICE_REGEX).matcher(regex);
        return matcher.matches();
    }

    public boolean validateHouseIDService(String regex) {
        matcher = Pattern.compile(HOUSE_ID_SERVICE_REGEX).matcher(regex);
        return matcher.matches();
    }

    public boolean validateRoomIDService(String regex) {
        matcher = Pattern.compile(ROOM_ID_SERVICE_REGEX).matcher(regex);
        return matcher.matches();
    }

    public boolean validateServiceName(String regex) {
        matcher = Pattern.compile(SERVICE_NAME_REGEX).matcher(regex);
        return matcher.matches();
    }
    public boolean validateRentType(String regex) {
        matcher = Pattern.compile(RENT_TYPE_REGEX).matcher(regex);
        return matcher.matches();
    }
    public boolean validateVillaType(String regex) {
        matcher = Pattern.compile(VILLA_TYPE_REGEX).matcher(regex);
        return matcher.matches();
    }
    public boolean validateHouseType(String regex) {
        matcher = Pattern.compile(HOUSE_TYPE_REGEX).matcher(regex);
        return matcher.matches();
    }
}

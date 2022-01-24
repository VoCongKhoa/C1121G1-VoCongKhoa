package FuramaResort.utils;

import com.sun.prism.shader.DrawEllipse_RadialGradient_REPEAT_AlphaTest_Loader;

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

    private static final String NAME_REGEX = "^[A-Za-z]\\w+$";
    private static final String GENDER_REGEX = "^Male|Female$";
    private static final String ID_NUMBER_REGEX = "^\\d{12}$";
    private static final String PHONE_NUMBER_REGEX = "^\\(\\+\\d{2}\\)\\s\\d{9}$";
    private static final String EMAIL_REGEX = "^[\\w]+@\\w+(\\.\\w+)+$";

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

    public boolean validateName(String regex){
        matcher = Pattern.compile(NAME_REGEX).matcher(regex);
        return matcher.matches();
    }

    public boolean validateGender(String regex){
        matcher = Pattern.compile(GENDER_REGEX).matcher(regex);
        return matcher.matches();
    }

    public boolean validateIDNumber(String regex){
        matcher = Pattern.compile(ID_NUMBER_REGEX).matcher(regex);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String regex){
        matcher = Pattern.compile(PHONE_NUMBER_REGEX).matcher(regex);
        return matcher.matches();
    }

    public boolean validateEmail(String regex){
        matcher = Pattern.compile(EMAIL_REGEX).matcher(regex);
        return matcher.matches();
    }


}

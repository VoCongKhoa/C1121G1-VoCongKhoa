package FuramaResort.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private Pattern pattern;
    private Matcher matcher;

    private static final String VILLA_ID_SERVICE_REGEX = "^SVVL-\\d{4}$";
    private static final String HOUSE_ID_SERVICE_REGEX = "^SVHO-\\d{4}$";
    private static final String ROOM_ID_SERVICE_REGEX = "^SVRO-\\d{4}$";
    private static final String SERVICE_NAME_REGEX = "^[A-Z](\\w\\s?)+$";
    private static final String RENT_TYPE_REGEX = "^[A-Z](\\w\\s?)+$";
    private static final String VILLA_TYPE_REGEX = "^[A-Z](\\w\\s?)+$";
    private static final String HOUSE_TYPE_REGEX = "^[A-Z](\\w\\s?)+$";

    private static final String NAME_REGEX = "^[A-Za-z](\\w\\s?)+$";
    private static final String GENDER_REGEX = "^Male|Female$";
    private static final String ID_NUMBER_REGEX = "^\\d{12}$";
    private static final String PHONE_NUMBER_REGEX = "^\\(\\+\\d{2}\\)(\\s?\\d){9,12}$";
    private static final String EMAIL_REGEX = "^[\\w]+@\\w+(\\.\\w+)+$";

    //Cách 1:
//    public boolean validateVillaIDService(String villaIDService){
//        matcher = Pattern.compile(VILLA_ID_SERVICE_REGEX).matcher(villaIDService);
//        return matcher.matches();
//    }

    //Cách 2:
//    public boolean validateVillaIDService(String villaIDService){
//        return villaIDService.matches(VILLA_ID_SERVICE_REGEX);
//    }

    //Cách 3:
    public boolean validateVillaIDService(String villaIDService) {
        return Pattern.matches(VILLA_ID_SERVICE_REGEX,villaIDService);
    }

    public boolean validateHouseIDService(String houseIDService) {
        return Pattern.matches(HOUSE_ID_SERVICE_REGEX,houseIDService);
    }

    public boolean validateRoomIDService(String roomIDService) {
        return Pattern.matches(ROOM_ID_SERVICE_REGEX,roomIDService);
    }

    public boolean validateServiceName(String serviceName) {
        return Pattern.matches(SERVICE_NAME_REGEX,serviceName);
    }
    public boolean validateRentType(String rentType) {
        return Pattern.matches(RENT_TYPE_REGEX,rentType);
    }

    public boolean validateVillaType(String villaType) {
        return Pattern.matches(VILLA_TYPE_REGEX,villaType);
    }

    public boolean validateHouseType(String houseType) {
        return Pattern.matches(HOUSE_TYPE_REGEX,houseType);
    }

    public boolean validateName(String name){
        return Pattern.matches(NAME_REGEX,name);
    }

    public boolean validateGender(String gender){
        return Pattern.matches(GENDER_REGEX,gender);
    }

    public boolean validateIDNumber(String IDNumber){
        return Pattern.matches(ID_NUMBER_REGEX,IDNumber);
    }

    public boolean validatePhoneNumber(String phoneNumber){
        return Pattern.matches(PHONE_NUMBER_REGEX,phoneNumber);
    }

    public boolean validateEmail(String email){
        return Pattern.matches(EMAIL_REGEX,email);
    }

}

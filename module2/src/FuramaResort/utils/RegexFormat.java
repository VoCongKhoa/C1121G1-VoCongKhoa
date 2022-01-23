package FuramaResort.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFormat {
    public static boolean regexVillaIDService(String IDService){
        final String REGEX_VILLA_ID_SERVICE = "^SVVL-\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX_VILLA_ID_SERVICE);
        Matcher matcher = pattern.matcher(IDService);
        return matcher.matches();
    }
    public static boolean regexHouseIDService(String IDService){
        final String REGEX_HOUSE_ID_SERVICE = "^SVHO-\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX_HOUSE_ID_SERVICE);
        Matcher matcher = pattern.matcher(IDService);
        return matcher.matches();
    }
    public static boolean regexRoomIDService(String IDService){
        final String REGEX_ROOM_ID_SERVICE = "^SVRO-\\d{4}$";
        Pattern pattern = Pattern.compile(REGEX_ROOM_ID_SERVICE);
        Matcher matcher = pattern.matcher(IDService);
        return matcher.matches();
    }
//    public static boolean regexServiceName(String serviceName){
//        final String REGEX_SERVICE_NAME = "^[A-Z]a-z+$";
//        Pattern pattern = Pattern.compile(REGEX_SERVICE_NAME);
//        Matcher matcher = pattern.matcher(serviceName);
//        return matcher.matches();
//    }
}

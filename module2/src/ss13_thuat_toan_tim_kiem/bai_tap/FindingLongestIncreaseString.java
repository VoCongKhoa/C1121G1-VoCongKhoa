package ss13_thuat_toan_tim_kiem.bai_tap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindingLongestIncreaseString {
    public static void main(String[] args) {
        String str = "Jqtoabcde";
        String strTemp = "";
        String strResult = "";
        Map<Integer,String> stringMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            strTemp += str.charAt(i);
            for (int j = i; j < str.length()-1; j++) {
                strTemp += str.charAt(j);
                if (str.charAt(j) <= str.charAt(j+1)) {
                    strTemp = strTemp + str.charAt(j+1);
                }
            }
            stringMap.put(strTemp.length(),strTemp);
//            if (strTemp.length() > strResult.length()) {
//                strResult = strTemp;
//            }
            strTemp = "";
        }
        System.out.println(stringMap);
    }
}

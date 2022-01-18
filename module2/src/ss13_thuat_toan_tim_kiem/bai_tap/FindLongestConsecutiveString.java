package ss13_thuat_toan_tim_kiem.bai_tap;

public class FindLongestConsecutiveString {
    public static void main(String[] args) {
        String str = "abcdabcdefghikabcdef";
        int start = 0;
        int end = 0;
        String tempStr = "";
        int maxLength = 0;
        String resultStr = "";
        while (end<str.length()-1){
            start += maxLength;
            if (start<str.length()-1){
                tempStr = str.charAt(start)+"";
                for (int j = start; j < str.length() - 1; j++) {
                    if (str.charAt(j + 1) >= str.charAt(j)) {
                        end = j + 1;
                        tempStr += str.charAt(end);
                    } else {
                        break;
                    }
                }
                if (end - start > maxLength) {
                    maxLength = end - start+1;
                    resultStr = tempStr;
                }
            } else {
                break;
            }
        }
        System.out.println(resultStr);
    }

}

package ss18_string_and_regex.bai_tap;

import ss18_string_and_regex.Validation;

public class ValidatePhoneNumber {

    public static void main(String[] args) {
        Validation validation = new Validation();

        System.out.println(validation.validatePhoneNumber("(84)-(0978489648)"));
        System.out.println(validation.validatePhoneNumber("(ab)-(0978489648)"));
        System.out.println(validation.validatePhoneNumber("(+84)-(0978489648)"));
        System.out.println(validation.validatePhoneNumber("((84))-(09784896)"));
        System.out.println(validation.validatePhoneNumber("(84)_(0978489648)"));
    }
}

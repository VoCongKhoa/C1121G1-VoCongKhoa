package ss18_string_and_regex.thuc_hanh;

import ss18_string_and_regex.Validation;

public class ValidateAccount {
    public static void main(String[] args) {
        Validation validation = new Validation();

        System.out.println(validation.validateAccount("123abc_"));
        System.out.println(validation.validateAccount("_abc123"));
        System.out.println(validation.validateAccount("______"));
        System.out.println(validation.validateAccount("123456"));
        System.out.println(validation.validateAccount("abcdefg"));
        System.out.println(validation.validateAccount(".@"));
        System.out.println(validation.validateAccount("12345"));
        System.out.println(validation.validateAccount("1234_"));
        System.out.println(validation.validateAccount("abcde"));
    }

}

package ss18_string_and_regex.thuc_hanh;

import ss18_string_and_regex.Validation;

public class ValidateEmail {
    public static void main(String[] args) {
        Validation validation = new Validation();
        System.out.println(validation.validateEmail("a@gmail.com"));
        System.out.println(validation.validateEmail("abc@hotmail.com"));
        System.out.println(validation.validateEmail("1234456@gmail.com.vn"));
        System.out.println(validation.validateEmail("@#abc@gmail.com"));
        System.out.println(validation.validateEmail("@gmail.com"));
        System.out.println(validation.validateEmail("ab@gmail."));
    }
}

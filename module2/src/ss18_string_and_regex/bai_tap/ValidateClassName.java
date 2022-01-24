package ss18_string_and_regex.bai_tap;

import ss18_string_and_regex.Validation;

public class ValidateClassName {
    public static void main(String[] args) {
        Validation validation = new Validation();
        System.out.println(validation.validateClassName("C0318G"));
        System.out.println(validation.validateClassName("M0318G"));
        System.out.println(validation.validateClassName("P0323A"));
    }
}

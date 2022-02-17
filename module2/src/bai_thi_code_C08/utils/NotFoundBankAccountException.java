package bai_thi_code_C08.utils;

public class NotFoundBankAccountException extends Exception{
    public NotFoundBankAccountException() {
    }
    public NotFoundBankAccountException(String message) {
        super(message);
    }
}

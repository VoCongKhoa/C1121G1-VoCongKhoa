package bai_thi_thuc_hanh.utils;

public class NotFoundMedicalRecordException extends Exception{
    public NotFoundMedicalRecordException() {
    }
    public NotFoundMedicalRecordException(String message) {
        super(message);
    }
}

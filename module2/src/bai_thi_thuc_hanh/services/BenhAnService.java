package bai_thi_thuc_hanh.services;

import bai_thi_thuc_hanh.utils.NotFoundMedicalRecordException;

public interface BenhAnService {
    void themMoi(int caseNumber);
    void xoa() throws NotFoundMedicalRecordException;
    void hienThi();
}

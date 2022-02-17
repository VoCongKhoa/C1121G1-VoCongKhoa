package bai_thi_code_C09.services;

import bai_thi_code_C09.utils.NotFoundProductException;

public interface DienThoaiService {
    void themMoi(int caseNumber);
    void xoa() throws NotFoundProductException;
    void hienThi();
    void timKiem();
}

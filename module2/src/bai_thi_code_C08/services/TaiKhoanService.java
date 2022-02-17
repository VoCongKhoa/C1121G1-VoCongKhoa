package bai_thi_code_C08.services;

import bai_thi_code_C08.utils.NotFoundBankAccountException;

public interface TaiKhoanService {
    void themMoi(int caseNumber);
    void xoa() throws NotFoundBankAccountException;
    void hienThi();
    void timKiem();
}

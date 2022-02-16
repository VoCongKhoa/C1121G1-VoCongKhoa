package bai_thi_code_C10.services;

import bai_thi_code_C10.utils.NotFoundProductException;

public interface SanPhamService{
    void themMoi(int caseNumber);
    void xoa() throws NotFoundProductException;
    void hienThi();
    void timKiem();
}

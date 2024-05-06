package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachDangVien;

import java.util.List;

public interface DanhSachDangVienService {
    void saveDangVien(DanhSachDangVien danhSachDangVien);
    DanhSachDangVien findByFullName(String fullname);
    void deleteDanhSachDangVienById(Long id);
    List<DanhSachDangVien> getListDanhSach();
    void deleteDangVienByIds(List<Long> ids);

}

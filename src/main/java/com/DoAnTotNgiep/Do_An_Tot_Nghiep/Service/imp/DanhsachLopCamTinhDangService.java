package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;

public interface DanhsachLopCamTinhDangService {
    List<DanhSachLopCamTinhDang> addListOfSinhVien(List<DanhSachLopCamTinhDang> sinhVienList);
    List<DoanVienUuTu> addListOfDoanVienUuTu(List<DoanVienUuTu> doanVienUuTuList);

    List<DanhSachLopCamTinhDang> getListDanhSach();

    List<DanhSachLopCamTinhDang> getListDanhSachByDot(String name);

    DanhSachLopCamTinhDang findByMssv(String mssv);

    DanhSachLopCamTinhDang save(DanhSachLopCamTinhDang danhSachLopCamTinhDang);

    List<DanhSachLopCamTinhDang> getListDanhSachPhatTrienDang(String name);

}

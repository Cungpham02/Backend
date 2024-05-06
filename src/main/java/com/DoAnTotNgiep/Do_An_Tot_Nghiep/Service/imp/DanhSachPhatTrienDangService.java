package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;

import java.util.List;

public interface DanhSachPhatTrienDangService {
    List<DanhSachPhatTrienDang> addListOfSinhVien(List<DanhSachPhatTrienDang> sinhVienList);
    List<DanhSachPhatTrienDang> getListDanhSachByDot(String name);

}

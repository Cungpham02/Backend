package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;

import java.util.List;

public interface DanhSachKetNapService {
    List<DanhSachKetNapDang> addListOfSinhVien(List<DanhSachKetNapDang> Danhsachlist);
    List<DanhSachKetNapDang> getListDanhSachKetNapDang(String dot);
    DanhSachKetNapDang getDangVienByMSSV(String mssv);
    void save(DanhSachKetNapDang danhSachKetNapDang);

}

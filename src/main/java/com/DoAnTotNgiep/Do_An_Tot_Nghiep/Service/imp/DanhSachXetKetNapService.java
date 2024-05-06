package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;


import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachXetKetNapDang;

import java.util.List;

public interface DanhSachXetKetNapService {
    List<DanhSachXetKetNapDang> addListOfSinhVien(List<DanhSachXetKetNapDang> Danhsachlist);
    List<DanhSachXetKetNapDang> getListDanhSachByDot(String name);
}

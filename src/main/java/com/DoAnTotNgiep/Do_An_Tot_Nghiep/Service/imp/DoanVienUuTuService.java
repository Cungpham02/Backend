package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;

import java.util.List;

public interface DoanVienUuTuService {
    List<DoanVienUuTu> getListDanhSachByDot(String name);
}

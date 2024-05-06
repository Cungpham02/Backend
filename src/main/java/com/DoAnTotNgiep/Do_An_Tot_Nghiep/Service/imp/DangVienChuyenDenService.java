package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienDangVienChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDen;

public interface DangVienChuyenDenService {
    List<DangVienDangVienChuyenDen> getListDvChuyenDen();
    void save(DvChuyenDen dvChuyenDen);
}

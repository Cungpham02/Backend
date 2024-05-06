package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDi;

public interface DangVienChuyenDiService {
    List<DvChuyenDi> getListDvChuyenDi();
    DvChuyenDi searchDVById(Long id);

    void saveyecauChuyenDi(DvChuyenDi dvChuyenDi);
    DvChuyenDi findByUsername(String username);

    void updateDangVienChuyenDIById(Long id,String trangthai);
}

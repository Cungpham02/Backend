package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.KetQuaLopCamTinh;

import java.util.List;

public interface KetQuaLopCamTinhService {
    KetQuaLopCamTinh findByMssv(String mssv);
    KetQuaLopCamTinh saveKetQua(KetQuaLopCamTinh ketqua);
    List<KetQuaLopCamTinh> getListDanhSachByDot(String name);
}

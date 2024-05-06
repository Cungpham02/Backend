package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;

import java.util.List;

public interface ThongBaoLichHopService {
    void addThongBaoLichHop(Long lichHopId, List<Long> dangVienIds);
    List<DangVien> findDangVienChuaNhanThongBao(Long id);
    List<LichHop> getListLichHopById(Long id);
}

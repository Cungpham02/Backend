package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;

import java.util.List;

public interface LichHopService {
    void saveLichHop(LichHop lichHop);
    List<LichHop> getList();
    LichHop findById(Long id);
}

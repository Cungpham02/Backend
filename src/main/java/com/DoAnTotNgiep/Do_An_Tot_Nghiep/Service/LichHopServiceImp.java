package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.LichHopRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.LichHopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichHopServiceImp implements LichHopService {
    @Autowired
    private LichHopRepository lichHopRepository;
    @Override
    public void saveLichHop(LichHop lichHop) {
        lichHopRepository.save(lichHop);

    }

    @Override
    public List<LichHop> getList() {
        return lichHopRepository.findAll();
    }

    @Override
    public LichHop findById(Long id) {
        return lichHopRepository.findByidLichHop(id);
    }
}

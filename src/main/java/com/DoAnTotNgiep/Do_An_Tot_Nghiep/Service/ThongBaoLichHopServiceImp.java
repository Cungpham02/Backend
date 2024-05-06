package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ThongBaoLichHop;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienReposiroty;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.LichHopRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.ThongBaoLichHopRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.ThongBaoLichHopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThongBaoLichHopServiceImp implements ThongBaoLichHopService {
    @Autowired
    private LichHopRepository lichHopRepository;
    @Autowired
    private DangVienReposiroty dangVienReposiroty;
    @Autowired
    private ThongBaoLichHopRepository thongBaoLichHopRepository;
    @Override
    public void addThongBaoLichHop(Long lichHopId, List<Long> dangVienIds) {
        Optional<LichHop> optionalLichHop = lichHopRepository.findById(lichHopId);
        if (optionalLichHop.isPresent()) {
            LichHop lichHop = optionalLichHop.get();
            for (Long dangVienId : dangVienIds) {
                Optional<DangVien> optionalDangVien = dangVienReposiroty.findById(dangVienId);
                if (optionalDangVien.isPresent()) {
                    DangVien dangVien = optionalDangVien.get();
                    ThongBaoLichHop thongBaoLichHop = new ThongBaoLichHop();
                    thongBaoLichHop.setLichHop(lichHop);
                    thongBaoLichHop.setDangVien(dangVien);
                    thongBaoLichHop.setDaNhanThongBao(true);
                    thongBaoLichHopRepository.save(thongBaoLichHop);
                }
            }
        }

    }

    @Override
    public List<DangVien> findDangVienChuaNhanThongBao(Long id) {
        return thongBaoLichHopRepository.getListDangvien(id);
    }

    @Override
    public List<LichHop> getListLichHopById(Long id) {
        return thongBaoLichHopRepository.getListLichHopByIdDangVien(id);
    }
}

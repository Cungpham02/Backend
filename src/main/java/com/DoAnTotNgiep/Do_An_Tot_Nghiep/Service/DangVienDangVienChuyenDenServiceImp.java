package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienDangVienChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienDangVienChuyenDenRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DangVienDangVienChuyenDenService;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienDangVienChuyenDenDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DangVienDangVienChuyenDenServiceImp implements DangVienDangVienChuyenDenService {
    @Autowired
    private DangVienDangVienChuyenDenRepository dangVienDangVienChuyenDenRepository;
    @Override
    public void save(DangVienDangVienChuyenDen dangVienDangVienChuyenDen) {
         dangVienDangVienChuyenDenRepository.save(dangVienDangVienChuyenDen);
    }
    @Transactional
    public void updateTrangThai(List<DangVienDangVienChuyenDenDTO> dtoList) {
        for (DangVienDangVienChuyenDenDTO dto : dtoList) {
            Optional<DangVienDangVienChuyenDen> optionalRecord = dangVienDangVienChuyenDenRepository.findById(dto.getId());
            optionalRecord.ifPresent(record -> {
                record.setTrangthai(dto.getTrangthai());
                dangVienDangVienChuyenDenRepository.save(record);
            });
        }
    }
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienDangVienChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGiaDangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.PhieuDanhGiaDangVienRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienDangVienChuyenDenDTO;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.PhieuDanhGiaDangVienDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuDanhGiaDangVienServiceImp {
    @Autowired
    private PhieuDanhGiaDangVienRepository phieuDanhGiaDangVienRepository;

    public void save(PhieuDanhGiaDangVien danhGiaDangVien) {
        phieuDanhGiaDangVienRepository.save(danhGiaDangVien);
    }

    public PhieuDanhGiaDangVien getPhieuDanhGia(Long id, String dot) {
        return phieuDanhGiaDangVienRepository.findByPhieuDanhGia(id, dot);
    }

    public List<PhieuDanhGiaDangVien> getAll() {
        return phieuDanhGiaDangVienRepository.findAll();
    }

    public void updateDangVienPhieuDanhGiaById(Long id, Boolean trangthai) {

        phieuDanhGiaDangVienRepository.updateTrangThaiById(id, trangthai);
    }

    public List<PhieuDanhGiaDangVien> getListDangVienByDot(String chonDot) {
        return phieuDanhGiaDangVienRepository.getPhieuDanhGiaDangVienByDot(chonDot);
    }

    @Transactional
    public void updateTrangThai(List<PhieuDanhGiaDangVien> dtoList) {
        for (PhieuDanhGiaDangVien dto : dtoList) {
            Optional<PhieuDanhGiaDangVien> optionalRecord = phieuDanhGiaDangVienRepository.findById(dto.getId());
            optionalRecord.ifPresent(record -> {
                record.setTrangthai(dto.getTrangthai());
                phieuDanhGiaDangVienRepository.save(record);
            });
        }
    }
    public List<PhieuDanhGiaDangVienDTO> getListDangVienByDotPhieuDanhGia(String chonDot) {
        return phieuDanhGiaDangVienRepository.getListDanhSachByDotByDangVienPhieuDanhGia(chonDot);
    }
}

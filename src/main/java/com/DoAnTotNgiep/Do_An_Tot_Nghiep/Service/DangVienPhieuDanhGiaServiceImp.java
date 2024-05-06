package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienPhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienPhieuDanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangVienPhieuDanhGiaServiceImp {
    @Autowired
    private DangVienPhieuDanhGiaRepository dangVienPhieuDanhGiaRepository;

    public void addDangVienPhieuDanhGia(PhieuDanhGia phieuDanhGia, List<DangVien> dangViens) {
        // Lặp qua danh sách DangVien và tạo mỗi đối tượng DangVienPhieuDanhGia
        for (DangVien dangVien : dangViens) {
            DangVienPhieuDanhGia dangVienPhieuDanhGia = new DangVienPhieuDanhGia();
            dangVienPhieuDanhGia.setDangVien(dangVien);
            dangVienPhieuDanhGia.setActive(false);
            dangVienPhieuDanhGia.setPhieuDanhGia(phieuDanhGia);
            // Lưu đối tượng DangVienPhieuDanhGia vào cơ sở dữ liệu
            dangVienPhieuDanhGiaRepository.save(dangVienPhieuDanhGia);
        }
    }

    public DangVienPhieuDanhGia findByID(Long id, Long id_dv) {
        // Lặp qua danh sách DangVien và tạo mỗi đối tượng DangVienPhieuDanhGia
        return dangVienPhieuDanhGiaRepository.findByIdLong(id, id_dv);
    }

    public Long getCountDangVienChuaDanhGiaByDot(String chonDot) {
        Long countListDangVien = dangVienPhieuDanhGiaRepository.getListDanhsachDangVienChuaDanhGiaByDot(chonDot);

        if (countListDangVien > 0) {
            return countListDangVien;
        } else {
            return Long.parseLong("0");
        }
    }
}

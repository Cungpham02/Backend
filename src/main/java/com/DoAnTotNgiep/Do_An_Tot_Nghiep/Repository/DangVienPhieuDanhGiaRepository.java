package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienPhieuDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DangVienPhieuDanhGiaRepository extends JpaRepository<DangVienPhieuDanhGia, Long> {
    @Query("SELECT dv FROM DangVienPhieuDanhGia dv WHERE dv.phieuDanhGia.id = :id and dv.dangVien.id=:id_dv")
    DangVienPhieuDanhGia findByIdLong(Long id, Long id_dv);

    @Query("SELECT count(dv.id) FROM DangVienPhieuDanhGia dv WHERE dv.dangVien.id NOT IN (SELECT pdgdv.id_dangvien FROM PhieuDanhGiaDangVien pdgdv WHERE pdgdv.chonDot = :chonDot)")
    Long getListDanhsachDangVienChuaDanhGiaByDot(String chonDot);
}

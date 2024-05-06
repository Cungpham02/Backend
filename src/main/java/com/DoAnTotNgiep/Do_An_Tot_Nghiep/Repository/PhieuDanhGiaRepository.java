package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuDanhGiaRepository extends JpaRepository<PhieuDanhGia,Long> {
    List<PhieuDanhGia> findByOrderByCreatedAtDesc();
    @Query("select pdg from PhieuDanhGia pdg where id in (SELECT dvpdg.phieuDanhGia.id FROM DangVienPhieuDanhGia dvpdg where dvpdg.dangVien.id=:dangVienId) and chonDot=:chonDot")
    PhieuDanhGia findByChonDotAndDangVienPhieuDanhGiaDangVienId(String chonDot, Long dangVienId);
    @Query("select pdg from PhieuDanhGia pdg where pdg.chonDot=:chonDot")
    PhieuDanhGia findPhieuDanhGiaByDot(String chonDot);
}

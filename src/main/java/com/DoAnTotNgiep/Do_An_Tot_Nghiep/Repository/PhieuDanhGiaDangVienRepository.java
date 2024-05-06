package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGiaDangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.PhieuDanhGiaDangVienDTO;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuDanhGiaDangVienRepository extends JpaRepository<PhieuDanhGiaDangVien, Long> {
    @Query("select dv from PhieuDanhGiaDangVien dv where dv.id_dangvien=:id_dangvien  and dv.chonDot=:chonDot")
    PhieuDanhGiaDangVien findByPhieuDanhGia(Long id_dangvien, String chonDot);

    @Transactional
    @Modifying
    @Query("UPDATE PhieuDanhGiaDangVien dv SET dv.trangthai = :trangthai where dv.id = :id")
    void updateTrangThaiById(@Param("id") Long id, @Param("trangthai") Boolean trangthai);

    @Query("select dv from PhieuDanhGiaDangVien dv where dv.chonDot = :chonDot")
    List<PhieuDanhGiaDangVien> getPhieuDanhGiaDangVienByDot(String chonDot);

    @Query("SELECT new com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.PhieuDanhGiaDangVienDTO(p.tongDiem,p.xeploai,p.trangthai,d.fullname,d.mdd) FROM PhieuDanhGiaDangVien p JOIN DangVien d ON p.id_dangvien = d.id where p.chonDot=:chonDot")
    List<PhieuDanhGiaDangVienDTO> getListDanhSachByDotByDangVienPhieuDanhGia(String chonDot);

}

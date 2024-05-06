package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;

public interface DanhsachLopCamTinhDangRepository extends JpaRepository<DanhSachLopCamTinhDang, Long> {

    @Query("SELECT dv FROM DanhSachLopCamTinhDang dv WHERE dv.dottrongnam = :dot")
    List<DanhSachLopCamTinhDang> getListDanhsachByDot(@Param("dot") String name);

    @Query("SELECT dv FROM DanhSachLopCamTinhDang dv WHERE dv.dottrongnam = :dot ")
    List<DanhSachLopCamTinhDang> getListDanhsachPhatTrienDangByDot(@Param("dot") String name);

    DanhSachLopCamTinhDang findByMssv(String mssv);
}

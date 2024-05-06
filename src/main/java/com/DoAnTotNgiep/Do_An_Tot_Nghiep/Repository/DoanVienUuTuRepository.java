package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoanVienUuTuRepository extends JpaRepository<DoanVienUuTu,Long> {
    @Query("SELECT dv FROM DoanVienUuTu dv WHERE dv.dotdoanvienuutu = :dotdoanvienuutu")
    List<DoanVienUuTu> getListDanhsachByDot(@Param("dotdoanvienuutu") String name);
}

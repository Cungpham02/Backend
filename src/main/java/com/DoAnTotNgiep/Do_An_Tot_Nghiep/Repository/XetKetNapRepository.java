package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachXetKetNapDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XetKetNapRepository extends JpaRepository<DanhSachXetKetNapDang,Long> {
    @Query("SELECT dv FROM DanhSachXetKetNapDang dv WHERE dv.chonDot = :dot ")
    List<DanhSachXetKetNapDang> getListDanhsachXetKetNapDangByDot(@Param("dot") String name);
}

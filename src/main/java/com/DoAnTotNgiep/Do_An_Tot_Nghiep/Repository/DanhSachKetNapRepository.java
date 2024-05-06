package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhSachKetNapRepository extends JpaRepository<DanhSachKetNapDang,Long> {
    @Query("SELECT dv FROM DanhSachKetNapDang dv WHERE dv.chonDot = :dot ")
    List<DanhSachKetNapDang> getListDanhsachKetNapDangByDot(@Param("dot") String name);
    @Query("SELECT dv FROM DanhSachKetNapDang dv WHERE dv.mssv = :mssv ")
    DanhSachKetNapDang findByMSSV(@Param("mssv") String mssv);
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;


import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhSachPhatTrienDangRepository extends JpaRepository<DanhSachPhatTrienDang,Long> {
    @Query("SELECT dv FROM DanhSachPhatTrienDang dv WHERE dv.chonDot = :dot ")
    List<DanhSachPhatTrienDang> getListDanhsachPhatTrienDangByDot(@Param("dot") String name);
}

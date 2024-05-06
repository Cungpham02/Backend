package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachDangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhSachDangVienRepository extends JpaRepository<DanhSachDangVien,Long> {
    @Query("SELECT dv FROM DanhSachDangVien dv WHERE dv.fullname = :fullname")
    DanhSachDangVien findByFullName(@Param("fullname") String fullname);
}

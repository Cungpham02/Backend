package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.KetQuaLopCamTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KetQuaLopCamTinhRepository extends JpaRepository<KetQuaLopCamTinh,Long> {
    @Query("SELECT dv FROM KetQuaLopCamTinh dv WHERE dv.chonDot = :dot and dv.ketqua IS NOT NULL")
    List<KetQuaLopCamTinh> getListKetQuaLopCamTinh(@Param("dot") String name);
    KetQuaLopCamTinh findByMssv(String mssv);
}

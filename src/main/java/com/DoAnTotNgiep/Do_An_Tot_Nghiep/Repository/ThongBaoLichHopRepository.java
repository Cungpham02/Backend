package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ThongBaoLichHop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThongBaoLichHopRepository extends JpaRepository<ThongBaoLichHop,Long> {
    @Query("SELECT d FROM DangVien d WHERE d.id NOT IN (SELECT tb.dangVien.id FROM ThongBaoLichHop tb where tb.LichHop.id =:id and daNhanThongBao=true)")
    List<DangVien> getListDangvien(@Param("id") Long id);
    @Query("SELECT l FROM LichHop l WHERE l.id IN (SELECT tb.LichHop.id FROM ThongBaoLichHop tb WHERE tb.dangVien.id = :dangVienId AND tb.daNhanThongBao = true)")
    List<LichHop> getListLichHopByIdDangVien(@Param("dangVienId")Long dangVienId);
}

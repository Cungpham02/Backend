package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LichHopRepository extends JpaRepository<LichHop,Long> {

    @Query("SELECT dv FROM LichHop dv WHERE dv.id = :id")
    LichHop findByidLichHop(@Param("id") Long id);
}

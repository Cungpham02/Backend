package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDi;

@Repository
public interface DangVienChuyenDiRepository extends JpaRepository<DvChuyenDi, Long> {
    @Query("SELECT dvcdi FROM DvChuyenDi dvcdi WHERE dvcdi.id = :id")
    Optional<DvChuyenDi> findById(@Param("id") Long id);
    @Query("SELECT dvcdi FROM DvChuyenDi dvcdi WHERE dvcdi.id = :id")
    DvChuyenDi findDvById(@Param("id") Long id);
    @Query("SELECT dvcdi FROM DvChuyenDi dvcdi WHERE dvcdi.username = :username")
    DvChuyenDi findDvByUsername(@Param("username") String username);
}

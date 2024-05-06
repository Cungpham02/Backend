package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDen;

@Repository
public interface DangVienChuyenDenRepository extends JpaRepository<DvChuyenDen, Long> {

}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienDangVienChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienChuyenDenDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DangVienDangVienChuyenDenRepository extends JpaRepository<DangVienDangVienChuyenDen,Long> {

    @Query("SELECT new com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienChuyenDenDTO(dv.fullname,dvc.fullname,dv.gmail,dvc.mdd,dvc.phonenumber,dvc.ngaychuyenden,dvcd.trangthai,dvcd.id) " +
            "FROM DangVienDangVienChuyenDen dvcd " +
            "JOIN dvcd.dangVien dv " +
            "JOIN dvcd.dvChuyenDen dvc")
    List<DangVienChuyenDenDTO> getListDS();
    @Query("SELECT new com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienChuyenDenDTO(dv.fullname,dvc.fullname,dv.gmail,dvc.mdd,dvc.phonenumber,dvc.ngaychuyenden,dvcd.trangthai,dvcd.id) " +
            "FROM DangVienDangVienChuyenDen dvcd " +
            "JOIN dvcd.dangVien dv " +
            "JOIN dvcd.dvChuyenDen dvc where dv.fullname=:fullname")
    List<DangVienChuyenDenDTO> getListDangVienCdenByNameHD(String fullname);
}

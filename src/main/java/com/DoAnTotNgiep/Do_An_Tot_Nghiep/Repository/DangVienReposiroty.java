package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;

@Repository
public interface DangVienReposiroty extends JpaRepository<DangVien, Long> {
    @Query("SELECT dv FROM DangVien dv WHERE dv.fullname = :fullname")
    DangVien findByFullname(@Param("fullname") String name);

    DangVien findByUser(User user);

    @Query("SELECT dv FROM DangVien dv WHERE dv.id = :id")
    DangVien findById2(@Param("id") Long id);

    @Query("SELECT dv FROM DangVien dv WHERE dv.id IN :ids")
    List<DangVien> findDangVienByIds(List<Long> ids);

    @Query("SELECT dv FROM DangVien dv WHERE dv.fullname = :fullname")
    List<DangVien> findByListFullname(String fullname);

    @Query("SELECT dv FROM DangVien dv WHERE dv.mdd = :mdd")
    DangVien findByMdd(String mdd);

    @Query("SELECT COUNT(*) \n" +
            "FROM DangVien dv \n" +
            "WHERE dv.sodienthoai = :sodienthoai")
    Long countSdd(String sodienthoai);

    @Query("SELECT dv FROM  DangVien dv WHERE dv.id not in(select u.dangVien.id from User u)")
    List<DangVien> getListDanhSachNotTaiKhoan();
    @Query("SELECT dv FROM  DangVien dv WHERE dv.ngaychinhthuc is not null")
    List<DangVien> getListDangVienChinhThuc();
}

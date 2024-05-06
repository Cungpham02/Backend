package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.UserDangVienDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.dangVien = :dangVien")
    User findByDangVien(DangVien dangVien);
    @Query("SELECT new com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.UserDangVienDTO(us.id,us.username, dv.fullname, dv.mdd,us.trangthai) FROM DangVien dv JOIN dv.user us")
    List<UserDangVienDTO> getListTK();
}

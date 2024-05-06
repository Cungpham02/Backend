package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.UserDangVienDTO;

public interface UserService {
    User findByUsername(String username);

    //Hàm checkLogin để kiểm tra
    Boolean checkLogin(String username, String password);

    boolean matches(String rawPassword, String encodedPassword);

    User saveUser(User user);

    List<UserDangVienDTO> getListUsers();

    User findByDangVien(DangVien dangVien);
}

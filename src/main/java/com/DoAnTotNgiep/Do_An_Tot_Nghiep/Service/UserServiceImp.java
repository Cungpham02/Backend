package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.UserRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.UserService;

import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienDTO;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.UserDangVienDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    //Service để đăng nhập check username,pasword
    @Override
    public Boolean checkLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getTrangthai().equals("1")) {
            return passwordEncoder.matches(password, user.getPassword());
        } else {
            return false;
        }
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public List<UserDangVienDTO> getListUsers() {
        return userRepository.getListTK();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByDangVien(DangVien dangVien) {
        return userRepository.findByDangVien(dangVien);
    }
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User_Role;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.Role;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.RoleServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.UserRoleServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.UserServiceImp;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private DangVienServiceImp dangVienServiceImp;
    private UserDTO userDTO;
    @Autowired
    private AuthenticationGetNameRole authenticationGetNameRole;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleServiceImp roleServiceImp;

    @Autowired
    private UserRoleServiceImp userRoleServiceImp;

    //Hàm lấy ra danh sách tài khoản người dùng trong hệ thống
    @GetMapping("/users/listTaiKhoan")
    @PreAuthorize("hasRole('ROLE_BT')")
    public ResponseEntity<?> getListTaiKhoan() {
        ResponeData responeData = new ResponeData();
        List<UserDangVienDTO> users = userServiceImp.getListUsers();
        responeData.setData(users);
        responeData.setMessage("Lấy dữ liệu thành công");
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    //Lấy ra thông tin người dùng trong hệ thống qua username
    @GetMapping("/user/{user_name}")
    public ResponseEntity<?> getUserByName(@PathVariable("user_name") String username) {
        ResponeData responeData = new ResponeData();
        username = authenticationGetNameRole.getNameUser();
        User user = userServiceImp.findByUsername(username);
        DangVien dv = dangVienServiceImp.getDangVienByUsername(username);
        if (user != null) {
            DangVienDTO dangVienDTO = new DangVienDTO(dv.getFullname(), dv.getGioitinh(), dv.getNoisinh(),
                    dv.getThuongtru(), dv.getTrinhdo(),
                    dv.getDantoc(), dv.getNgaysinh(), dv.getCccd(), dv.getKhenthuong(), dv.getNghenghiep(),
                    dv.getQuatrinhhd(), dv.getTongiao(),
                    dv.getKyluat(), dv.getNgaychinhthuc(), dv.getNgayvaodang(), dv.getNgayvaodoan(), dv.getQuequan(),dv.getTamtru(),dv.getGmail(),dv.getSodienthoai());
            responeData.setData(dangVienDTO);
            responeData.setIsSuccess(true);
            responeData.setMessage("Lấy thông tin người dùng thành công");
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        } else {
            responeData.setData("");
            responeData.setMessage("Lấy thông tin thất bại");
            responeData.setIsSuccess(false);
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        }
    }
    //Hàm cập nhật thông tin của đảng viên
    @PutMapping("/user/update/{user_name}")
    public ResponseEntity<?> updateInforByUsername(@PathVariable("user_name") String username,@RequestBody UpdateDangVienDTO updateDangVienDTO) {
        ResponeData responeData = new ResponeData();
        username = authenticationGetNameRole.getNameUser();
        DangVien dv = dangVienServiceImp.getDangVienByUsername(username);
        dv.setGmail(updateDangVienDTO.getGmail());
        dv.setSodienthoai(updateDangVienDTO.getSodienthoai());
        dv.setTamtru(updateDangVienDTO.getTamtru());
        dangVienServiceImp.saveDangVien(dv);
        responeData.setData("");
        responeData.setMessage("Cập nhật thông tin đảng viên thành công");
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    //Hàm thay đổi mật khẩu
    @PostMapping("/user/ChangeThePassword")
    public ResponseEntity<?> checkPassword(@RequestBody PasswordChangeDTO passwordChangeDTO) {
        ResponeData responeData = new ResponeData();
        String username = authenticationGetNameRole.getNameUser();
        User user = userServiceImp.findByUsername(username);
        boolean isCheckPassWord = userServiceImp.matches(passwordChangeDTO.getPassword(),
                user.getPassword());
        System.out.println(isCheckPassWord);
        if (!isCheckPassWord) {
            responeData.setMessage("Password cũ nhập sai");
            responeData.setIsSuccess(false);
            return new ResponseEntity<>(responeData, HttpStatus.OK);

        }
        if(passwordChangeDTO.getPassword().equals(passwordChangeDTO.getPassword_moi())){
            responeData.setMessage("Password mới không được trùng mật khẩu cũ");
            responeData.setIsSuccess(false);
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        }
        if (!passwordChangeDTO.getPassword_moi().equals(passwordChangeDTO.getPassword_moi_check())) {
            responeData.setMessage("Password mới nhập lại sai");
            responeData.setIsSuccess(false);
            return new ResponseEntity<>(responeData, HttpStatus.OK);

        }

        user.setPassword(bCryptPasswordEncoder.encode(passwordChangeDTO.getPassword_moi()));
        userServiceImp.saveUser(user);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thành công thay đổi mật khẩu");
        return new ResponseEntity<>(responeData, HttpStatus.OK);

    }

    //Bảng tạo tài khoản người dùng để đăng nhập
    @PostMapping("/user/create/{id}")
    public ResponseEntity<?> createAccount(@RequestBody User user, @PathVariable("id") String id) {
        System.out.println(id);
        ResponeData responeData = new ResponeData();
        System.out.println(id + "-" + user.getUsername() + "-" + user.getPassword());
        User user1 = userServiceImp.findByUsername(user.getUsername());
        if (user1 != null) {
            responeData.setData("");
            responeData.setMessage("Tên người dùng đã tồn tại");
            responeData.setIsSuccess(false);
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        } else {
            String password = new BCryptPasswordEncoder().encode(user.getPassword());
            User user2 = new User();
            user2.setUsername(user.getUsername());
            user2.setPassword(password);
            user2.setDangVien(dangVienServiceImp.findById2(Long.parseLong(id)));
            user2.setTrangthai("1");
            userServiceImp.saveUser(user2);
            User_Role user_Role = new User_Role();
            Optional<Role> role = roleServiceImp.findById(Long.parseLong("1"));
            if (role.isPresent()) {
                Role roleDV = role.get();
                user_Role.setRole(roleDV);
                user_Role.setUser(user2);
                userRoleServiceImp.saveUserRole(user_Role);
            }
            responeData.setIsSuccess(true);
            responeData.setMessage("Thêm mới tài khoản thành công");
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        }

    }
    @GetMapping("/user")
    public ResponseEntity<ResponeData> getDangVienByUsername(@RequestParam("username") String username) {
        ResponeData responeData = new ResponeData();
        username = authenticationGetNameRole.getNameUser();
        DangVien dv = dangVienServiceImp.getDangVienByUsername(username);
        responeData.setData(dv.getId());
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData,HttpStatus.OK);
    }
}

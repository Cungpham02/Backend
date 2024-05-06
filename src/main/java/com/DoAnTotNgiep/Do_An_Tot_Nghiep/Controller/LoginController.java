package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.UserServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Ultils.JWTUtilHelper;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    JWTUtilHelper jwtUtilHelper;

    @GetMapping("")
    public String gethome() {
        return "login";
    }

    //Hàm dùng để xử lý đăng nhập
    @PostMapping("/store")
    public ResponseEntity<?> login(@RequestBody UserDTO loginRequest) {
        ResponeData responeData = new ResponeData();
        System.out.println(loginRequest.getUsername());

        //Kiểm tra username đã tồn tại trong hệ tống hay chưa
        Boolean isCheckLogin = userServiceImp.checkLogin(loginRequest.getUsername(), loginRequest.getPassword());
        System.out.println(isCheckLogin);
//        //Nếu chưa tồn tại thì taọ token để đăng nhập với vai trò là bí thư hoặc đảng viên
        if (isCheckLogin) {
            //Authentication
            String token = jwtUtilHelper.generateToken(loginRequest.getUsername());
            responeData.setMessage("Login thành công");
            responeData.setStatus(200);
            responeData.setData(token);
            responeData.setUsername(loginRequest.getUsername());
            responeData.setIsSuccess(true);
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        } else {
            //Nếu tồn tại username hoặc mật khẩu sai thì hiển thị thông báo
            responeData.setMessage("Thông tin tài khoản hoặc mật khẩu không chính xác");
            responeData.setStatus(404);
            responeData.setData("");
            responeData.setIsSuccess(false);
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        }
    }

}

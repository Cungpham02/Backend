package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.AuthenticationGetNameRole;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HomeController {
    @Autowired
    private AuthenticationGetNameRole authenticationGetNameRole;

    @GetMapping("/home")
    public ResponseEntity<?> getHomePage() {
        ResponeData responeData = new ResponeData();
        Set<String> roles = authenticationGetNameRole.getRole_User();
        String username = authenticationGetNameRole.getNameUser();
        responeData.setMessage("Bạn đang đăng nhập");
        responeData.setStatus(200);
        responeData.setIsSuccess(true);
        responeData.setData(roles);
        responeData.setUsername(username);
        return ResponseEntity.ok(responeData);
    }

    // @GetMapping("/404")
    // public ResponseEntity<?> getError() {
    // ResponeData responeData = new ResponeData();
    // responeData.setMessage("Bạn không có quyền vào trang này");
    // responeData.setStatus(404);
    // responeData.setIsSuccess(false);
    // responeData.setData("");
    // responeData.setUsername("");
    // return ResponseEntity.ok(responeData);
    // }
}

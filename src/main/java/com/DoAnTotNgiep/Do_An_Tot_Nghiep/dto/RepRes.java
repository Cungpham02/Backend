package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
@JsonInclude
public class RepRes {
    private String mess;
    private String error;
    private String token;
    private String refreshToken;
    private String username;
    private String password;
    private String role;
    private List<User> ourUsers;
}

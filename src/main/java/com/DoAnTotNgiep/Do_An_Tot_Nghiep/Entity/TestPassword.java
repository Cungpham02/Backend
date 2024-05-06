package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {
    public static void main(String[] args) {
        String password=new BCryptPasswordEncoder().encode("1");
        System.out.println(password);
    }
}

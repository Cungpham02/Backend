package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name = "dangvienchuyendi")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DvChuyenDi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaychuyendi;// ngày chuyển đi
    private String noichuyenden;// nơi chuyển đến
    private String trangthai ;
    private String ghichu;
}

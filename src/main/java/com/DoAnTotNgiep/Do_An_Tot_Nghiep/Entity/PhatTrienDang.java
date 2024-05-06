package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "phattriendang")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhatTrienDang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mssv;
    private String diemTrungBinh;
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;// ngày sinh
    private String quequan;// quê quán
    private String dottrongnam;
    private Boolean trangthai;
    private String ketqua;
}

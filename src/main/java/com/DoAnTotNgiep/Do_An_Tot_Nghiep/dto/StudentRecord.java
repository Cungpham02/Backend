package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRecord {
    private Long id;
    private String mssv;
    private String fullname;
    private String ngaysinh;
    private String quequan;
    private Double diemTrungBinh;
    private String ketqua;


}

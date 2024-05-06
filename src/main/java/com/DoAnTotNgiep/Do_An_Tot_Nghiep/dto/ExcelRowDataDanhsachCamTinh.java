package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExcelRowDataDanhsachCamTinh {
    private double id;
    private double mssv;
    private String fullname;
    private Double diemTrungBinh;
    private Date ngaysinh;
    private String quequan;
    private String ketqua;
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExcelRowData {
    private double id;
    private String fullname;
    private Date ngaysinh;
    private String diemTrungBinh;
    private double mssv;
    private String quequan;
}

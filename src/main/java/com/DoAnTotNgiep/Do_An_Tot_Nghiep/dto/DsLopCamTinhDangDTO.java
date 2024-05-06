package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DsLopCamTinhDangDTO {
    private String mssv;
    private String fullname;
    private java.util.Date ngaysinh;
    private String quequan;
    private Long id;
}

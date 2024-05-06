package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuDanhGiaDTO {
    private String chonDot;
    private List<CauHoiDTO> danhSachCauHoi;
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DangVienChuyenDenDTO {
    private String fullname_huongdan;
    private String dvchuyenden_fullname;
    private String gmail;
    private String mdd;
    private String phonenumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaychuyenden;
    private String trangthai;
    private Long id;
}

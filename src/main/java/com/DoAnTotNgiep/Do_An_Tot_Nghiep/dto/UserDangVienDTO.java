package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDangVienDTO {
    private Long id;
    private String username;
    private String fullname;
    private String mdd;
    private String trangthai;
}

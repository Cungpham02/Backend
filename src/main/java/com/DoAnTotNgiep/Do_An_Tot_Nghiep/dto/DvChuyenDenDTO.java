package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DvChuyenDenDTO {
    private String mdd;
    private String fullname;
    private String id;
    private String phonenumber;
    private Boolean trangthai;
    private String partyMemberInfo;
    // Getters and setters
}
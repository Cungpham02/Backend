package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DangVienDTO {
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;// ngày sinh
    private String gioitinh;// giới tính
    private String noisinh;// nơi sinh
    private String thuongtru;// tạm trú
    private String dantoc;// dân tộc
    private String tongiao;// tôn giáo
    private String quequan;// quê quán
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngayvaodang;// ngày vào đảng
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaychinhthuc;// ngày chính thức
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngayvaodoan;// ngày vào đoàn
    private String cccd;
    private String khenthuong;
    private String kyluat;
    private String quatrinhhd;
    private String trinhdo;
    private String nghenghiep;
    private String tamtru;
    private String gmail;
    private String sodienthoai;
    public DangVienDTO(String fullname, String gioitinh, String noisinh, String thuongtru, String trinhdo, String dantoc, java.sql.Date ngaysinh, String cccd, String khenthuong, String nghenghiep, String quatrinhhd, String tongiao, String kyluat, java.sql.Date ngaychinhthuc, java.sql.Date ngayvaodang, java.sql.Date ngayvaodoan, String quequan,String tamtru,String gmail,String sodienthoai) {
        this.fullname=fullname;
        this.cccd=cccd;
        this.gioitinh=gioitinh;
        this.noisinh=noisinh;
        this.thuongtru=thuongtru;
        this.trinhdo=trinhdo;
        this.dantoc=dantoc;
        this.ngaysinh=ngaysinh;
        this.khenthuong=khenthuong;
        this.kyluat=kyluat;
        this.nghenghiep=nghenghiep;
        this.quatrinhhd=quatrinhhd;
        this.tongiao=tongiao;
        this.ngaychinhthuc=ngaychinhthuc;
        this.ngayvaodang=ngayvaodang;
        this.quequan=quequan;
        this.tamtru=tamtru;
        this.gmail=gmail;
        this.sodienthoai=sodienthoai;
    }
}

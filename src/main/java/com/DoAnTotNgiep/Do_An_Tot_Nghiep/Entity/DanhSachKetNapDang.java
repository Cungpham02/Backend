package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "danhsachketnapdang")
public class DanhSachKetNapDang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// mã đinh danh
    private String mssv;
    private String diemTrungBinh;
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;// ngày sinh
    private String quequan;// quê quán
    private String chonDot;
    private String ketqua;
    private String donxinvaodang,giaygioithieu,bantukiemdiem,bienbanhopchidoan,nghiquyetchidoan,nghiquyetdoantruong,tonghopykien,bienbanhopchibo,nghiquyetchibo;

}

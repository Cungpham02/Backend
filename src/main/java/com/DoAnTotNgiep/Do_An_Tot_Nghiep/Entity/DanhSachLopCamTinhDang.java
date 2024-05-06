package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Mã định danh, họ và tên, giới tính, ngày sinh, nơi sinh, quê quán, nơi thường trú, nơi tạm trú, dân tộc, tôn giáo, nghề nghiệp, ngày vào đảng, ngày vào đoàn, số CCCD, Tóm tắt quá trình hoạt động và công tác, khen thưởng, kỷ luật
@Component
@Entity
@Table(name = "danhsachlopcamtinhdang")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DanhSachLopCamTinhDang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// mã đinh danh
    private String mssv;
    private String diemTrungBinh;
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;// ngày sinh
    private String quequan;// quê quán
    private String dottrongnam;

}
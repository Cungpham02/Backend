package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name = "dangviens")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// mã đinh danh
    private String mdd;
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;// ngày sinh
    private String gioitinh;// giới tính
    private String noisinh;// nơi sinh
    private String thuongtru;// tạm trú
    private String tamtru;
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
    private String lopquanly;
    private String khoaquanly;
    private String gmail;
    private String sodienthoai;
    private Boolean trangthai;
    @JsonIgnore
    @OneToOne(mappedBy = "dangVien", cascade = CascadeType.ALL)
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "dangVien", cascade = CascadeType.ALL)
    private Set<DangVienDangVienChuyenDen> dangVienDangVienChuyenDens = new HashSet<>();
}
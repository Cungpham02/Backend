package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
@Component
@Entity
@Table(name = "danhsachdangviens")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DanhSachDangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// mã đinh danh
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;// ngày sinh
    private String lopquanly;
    private String khoaquanly;
    private String sodienthoai;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngayvaodang;// ngày vào đảng
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaychinhthuc;// ngày chính thức
    private Boolean trangthai;
    @OneToOne
    @JoinColumn(name = "dangvien_id", referencedColumnName = "id")
    private DangVien dangVien;
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "dangvien_phieudanhgia")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DangVienPhieuDanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "dangvien_id",referencedColumnName = "id")
    private DangVien dangVien;
    @ManyToOne
    @JoinColumn(name = "phieudanhgia_id",referencedColumnName = "id")
    private PhieuDanhGia phieuDanhGia;
    private Boolean active;
}

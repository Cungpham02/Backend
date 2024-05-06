package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "dangviendangvienchuyendens")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DangVienDangVienChuyenDen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "dangvien_id")
    private DangVien dangVien;
    @ManyToOne
    @JoinColumn(name = "dangvienchuyenden_id")
    private DvChuyenDen dvChuyenDen;
    private String trangthai;
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "thongbaolichhop")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ThongBaoLichHop {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "lich_hop_id")
        private LichHop LichHop;
        @ManyToOne
        @JoinColumn(name = "dangvien_id")
        private DangVien dangVien;
        private Boolean daNhanThongBao;
}

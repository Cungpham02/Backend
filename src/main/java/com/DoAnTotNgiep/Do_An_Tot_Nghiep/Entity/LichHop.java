package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Table(name = "lichhops")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LichHop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// mã đinh danh
    private String tieude; // họ và tên
    private String diadiem;
    private String noidung;
    private String ngayhop;
    @JsonBackReference
    @OneToMany(mappedBy = "LichHop", cascade = CascadeType.ALL)
    private Set<ThongBaoLichHop> thongBaoLichHops = new HashSet<>();
}

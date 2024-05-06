package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name = "dangvienchuyenden")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DvChuyenDen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long STT;
    private String mdd;
    private String fullname; // họ và tên
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaychuyenden;// ngày chuyển đến
    private String phonenumber;// sdt
    @JsonBackReference
    @OneToMany(mappedBy = "dvChuyenDen", cascade = CascadeType.ALL)
    private Set<DangVienDangVienChuyenDen> dangVienDangVienChuyenDens = new HashSet<>();
}
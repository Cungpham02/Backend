package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "phieudanhgia")
public class PhieuDanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB")
    private byte[] data;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "name")
    private String name;
    public PhieuDanhGia(String fileName, byte[] bytes, String chonDot) {
        this.data=bytes;
        this.name=fileName;
        this.chonDot=chonDot;

    }
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    private String chonDot;
}




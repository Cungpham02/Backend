package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import java.util.List;
import java.util.Optional;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;

public interface DangVienService {
    DangVien saveDangVien(DangVien dangVien);

    void deleteDangVien(Long id);

    void updateDangVienById(Long id, DangVien dangVien);

    Optional<DangVien> findById(Long id);

    DangVien findById2(Long id);

    List<DangVien> findDangVienByIds(List<Long> ids);

    List<DangVien> findByFullname(String name);
//     DangVien findByFullName2(String name);
    List<DangVien> getListDangVien();

    DangVien getDangVienByUsername(String username);
}

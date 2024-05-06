package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienDangVienChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienDangVienChuyenDenRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienChuyenDenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienChuyenDenRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DangVienChuyenDenService;

@Service
public class DangVienChuyenDenImp implements DangVienChuyenDenService {
    @Autowired
    private DangVienChuyenDenRepository dangVienChuyenDenRepository;
    @Autowired
    DangVienDangVienChuyenDenRepository dangVienDangVienChuyenDenRepository;

    @Override
    public List<DangVienDangVienChuyenDen> getListDvChuyenDen() {
        List<DangVienDangVienChuyenDen> list_dv_cd = dangVienDangVienChuyenDenRepository.findAll();
        return list_dv_cd;
    }
    public List<DangVienChuyenDenDTO> getListDS() {
        List<DangVienChuyenDenDTO> dv = dangVienDangVienChuyenDenRepository.getListDS();
        return dv;
    }
    public List<DangVienChuyenDenDTO> getListDSByFullname(String fullname) {
        List<DangVienChuyenDenDTO> dv = dangVienDangVienChuyenDenRepository.getListDangVienCdenByNameHD(fullname);
        return dv;
    }

    @Override
    public void save(DvChuyenDen dvChuyenDen) {
        dangVienChuyenDenRepository.save(dvChuyenDen);
    }
}

package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDi;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienChuyenDenRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienChuyenDiRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DangVienChuyenDiService;

@Service
public class DangVienChuyenDiImp implements DangVienChuyenDiService {
    @Autowired
    private DangVienChuyenDiRepository dangVienChuyenDiRepository;

    @Override
    public List<DvChuyenDi> getListDvChuyenDi() {
        List<DvChuyenDi> list_dv_cdi = dangVienChuyenDiRepository.findAll();
        return list_dv_cdi;
    }

    @Override
    public void saveyecauChuyenDi(DvChuyenDi dvChuyenDi) {
        dangVienChuyenDiRepository.save(dvChuyenDi);
    }

    @Override
    public DvChuyenDi findByUsername(String username) {
        return dangVienChuyenDiRepository.findDvByUsername(username);
    }

    @Override
    public void updateDangVienChuyenDIById(Long id,String trangthai) {
        Optional<DvChuyenDi> optionalDangVienCDI = dangVienChuyenDiRepository.findById(id);
        System.out.println(trangthai);
        if (optionalDangVienCDI.isPresent()) {
            DvChuyenDi existingDangVien = optionalDangVienCDI.get();
            // Cập nhật thông tin của đảng viên
            existingDangVien.setTrangthai(trangthai);
            Date currentDate = new Date();
            existingDangVien.setNgaychuyendi(new java.sql.Date(currentDate.getTime()));
            // Cập nhật các trường thông tin khác tương tự
            dangVienChuyenDiRepository.save(existingDangVien);
        } else {
            // Xử lý trường hợp không tìm thấy đảng viên
            System.out.println("Không tồn tại id mà cập nhâtk");
        }
    }
    @Override
    public DvChuyenDi searchDVById(Long id){
        return dangVienChuyenDiRepository.findDvById(id);
    }

}

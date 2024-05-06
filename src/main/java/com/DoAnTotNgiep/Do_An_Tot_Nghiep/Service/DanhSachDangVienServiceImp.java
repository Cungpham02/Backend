package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachDangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienReposiroty;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DanhSachDangVienRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.UserRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DanhSachDangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhSachDangVienServiceImp implements DanhSachDangVienService {
    @Autowired
    private DanhSachDangVienRepository danhSachDangVienRepository;
    @Autowired
    private DangVienReposiroty dangVienReposiroty;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveDangVien(DanhSachDangVien danhSachDangVien) {
        danhSachDangVienRepository.save(danhSachDangVien);
    }


    @Override
    public DanhSachDangVien findByFullName(String fullname) {
        return danhSachDangVienRepository.findByFullName(fullname);
    }

    @Override
    public void deleteDanhSachDangVienById(Long id) {
        danhSachDangVienRepository.deleteById(id);
    }

    @Override
    public List<DanhSachDangVien> getListDanhSach() {
        return danhSachDangVienRepository.findAll();
    }
    @Override
    public void deleteDangVienByIds(List<Long> ids) {
        for (Long id : ids) {
            Optional<DanhSachDangVien> danhSachDangVienOptional=danhSachDangVienRepository.findById(id);
            if (danhSachDangVienOptional.isPresent()) {
                DanhSachDangVien danhSachDangVien = danhSachDangVienOptional.get();
                DangVien dangVien=dangVienReposiroty.findById2(danhSachDangVien.getDangVien().getId());
                dangVien.setTrangthai(false);
                User user=userRepository.findByDangVien(dangVien);
                user.setTrangthai("0");
                dangVienReposiroty.save(dangVien);
                danhSachDangVienRepository.deleteById(id);
            } else {
                System.out.println("Không tìm thấy đảng viên có id "+id+" trong danh sách hồ sơ đảng viên");
            }
        }
    }
}

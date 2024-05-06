package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DanhSachPhatTrienDangRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DanhSachPhatTrienDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhSachPhatTrienDangServiceImp implements DanhSachPhatTrienDangService {
    @Autowired
    private DanhSachPhatTrienDangRepository danhSachPhatTrienDangRepository;
    @Override
    public List<DanhSachPhatTrienDang> addListOfSinhVien(List<DanhSachPhatTrienDang> danhSachPhatTrienDangs) {
        return danhSachPhatTrienDangRepository.saveAll(danhSachPhatTrienDangs);
    }

    @Override
    public List<DanhSachPhatTrienDang> getListDanhSachByDot(String name) {
        return danhSachPhatTrienDangRepository.getListDanhsachPhatTrienDangByDot(name);
    }
}

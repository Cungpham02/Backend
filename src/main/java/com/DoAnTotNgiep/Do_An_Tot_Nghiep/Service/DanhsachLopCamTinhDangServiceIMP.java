package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import java.util.ArrayList;
import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DoanVienUuTuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DanhsachLopCamTinhDangRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DanhsachLopCamTinhDangService;

@Service
public class DanhsachLopCamTinhDangServiceIMP implements DanhsachLopCamTinhDangService {
    @Autowired
    private DanhsachLopCamTinhDangRepository danhsachLopCamTinhDangRepository;
    @Autowired
    private DoanVienUuTuRepository doanVienUuTuRepository;

    @Override
    public List<DanhSachLopCamTinhDang> addListOfSinhVien(List<DanhSachLopCamTinhDang> danhSachLopCamTinhDangs) {

        return danhsachLopCamTinhDangRepository.saveAll(danhSachLopCamTinhDangs);
    }

    @Override
    public List<DoanVienUuTu> addListOfDoanVienUuTu(List<DoanVienUuTu> doanVienUuTuList) {
        return doanVienUuTuRepository.saveAll(doanVienUuTuList);
    }

    @Override
    public List<DanhSachLopCamTinhDang> getListDanhSach() {
        return danhsachLopCamTinhDangRepository.findAll();
    }

    @Override
    public List<DanhSachLopCamTinhDang> getListDanhSachByDot(String name) {
        return danhsachLopCamTinhDangRepository.getListDanhsachByDot(name);
    }

    @Override
    public DanhSachLopCamTinhDang findByMssv(String mssv) {
        return danhsachLopCamTinhDangRepository.findByMssv(mssv);
    }

    @Override
    public DanhSachLopCamTinhDang save(DanhSachLopCamTinhDang danhSachLopCamTinhDang) {
        return danhsachLopCamTinhDangRepository.save(danhSachLopCamTinhDang);
    }

    @Override
    public List<DanhSachLopCamTinhDang> getListDanhSachPhatTrienDang(String dot) {

        return danhsachLopCamTinhDangRepository.getListDanhsachPhatTrienDangByDot(dot);
    }



}

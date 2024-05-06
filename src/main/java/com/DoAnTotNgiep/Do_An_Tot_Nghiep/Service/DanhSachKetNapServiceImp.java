package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DanhSachKetNapRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DanhSachKetNapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhSachKetNapServiceImp implements DanhSachKetNapService {
    @Autowired
    private DanhSachKetNapRepository danhSachKetNapRepository;
    @Override
    public List<DanhSachKetNapDang> addListOfSinhVien(List<DanhSachKetNapDang> Danhsachlist) {
        return danhSachKetNapRepository.saveAll(Danhsachlist);
    }

    @Override
    public List<DanhSachKetNapDang> getListDanhSachKetNapDang(String dot) {
        return danhSachKetNapRepository.getListDanhsachKetNapDangByDot(dot);
    }

    @Override
    public DanhSachKetNapDang getDangVienByMSSV(String mssv) {
        return danhSachKetNapRepository.findByMSSV(mssv);
    }

    @Override
    public void save(DanhSachKetNapDang danhSachKetNapDang) {
         danhSachKetNapRepository.save(danhSachKetNapDang);
    }
}

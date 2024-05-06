package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachXetKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.XetKetNapRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DanhSachXetKetNapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DanhSachXetKetNapServiceImp implements DanhSachXetKetNapService {
    @Autowired
    private XetKetNapRepository xetKetNapRepository;
    @Override
    public List<DanhSachXetKetNapDang> addListOfSinhVien(List<DanhSachXetKetNapDang> Danhsachlist) {
        for(DanhSachXetKetNapDang ds:Danhsachlist){

            Date currentDate = new Date();
            ds.setNgayvaodang(new java.sql.Date(currentDate.getTime()));
            // Cập nhật các trường thông tin khác tương tự
            xetKetNapRepository.save(ds);
        }
        return xetKetNapRepository.saveAll(Danhsachlist);
    }

    @Override
    public List<DanhSachXetKetNapDang> getListDanhSachByDot(String name) {
        return xetKetNapRepository.getListDanhsachXetKetNapDangByDot(name);
    }
}

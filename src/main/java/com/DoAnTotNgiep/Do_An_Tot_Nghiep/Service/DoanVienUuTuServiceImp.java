package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DoanVienUuTuRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DoanVienUuTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoanVienUuTuServiceImp implements DoanVienUuTuService {
    @Autowired
    private DoanVienUuTuRepository doanVienUuTuRepository;
    @Override
    public List<DoanVienUuTu> getListDanhSachByDot(String name) {
         return doanVienUuTuRepository.getListDanhsachByDot(name);
    }
}

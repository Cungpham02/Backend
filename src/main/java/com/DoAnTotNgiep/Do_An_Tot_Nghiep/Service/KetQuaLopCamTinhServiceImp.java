package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.KetQuaLopCamTinh;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.KetQuaLopCamTinhRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.KetQuaLopCamTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KetQuaLopCamTinhServiceImp implements KetQuaLopCamTinhService {
    @Autowired
    private KetQuaLopCamTinhRepository ketQuaLopCamTinhRepository;
    @Override
    public KetQuaLopCamTinh findByMssv(String mssv) {
        return ketQuaLopCamTinhRepository.findByMssv(mssv);
    }
    @Override
    public KetQuaLopCamTinh saveKetQua(KetQuaLopCamTinh ketqua) {
        return ketQuaLopCamTinhRepository.save(ketqua);
    }

    @Override
    public List<KetQuaLopCamTinh> getListDanhSachByDot(String name) {
        return ketQuaLopCamTinhRepository.getListKetQuaLopCamTinh(name);
    }

}

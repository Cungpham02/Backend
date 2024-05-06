package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.KetQuaLopCamTinh;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.KetQuaLopCamTinhRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.KetQuaLopCamTinhServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class KetQuaLopCamTinhController {
    @Autowired
    private KetQuaLopCamTinhServiceImp ketQuaLopCamTinhServiceImp;
    @Autowired
    private ResponeData responeData;
    @PostMapping("/savekq_lopcamtinh")
    public ResponseEntity<ResponeData> saveKetQuaAll(@RequestBody List<KetQuaLopCamTinh> ketquaLopCamTinh) {
        for (KetQuaLopCamTinh ds : ketquaLopCamTinh) {

            ketQuaLopCamTinhServiceImp.saveKetQua(ds);
        }
        responeData.setIsSuccess(true);
        responeData.setMessage("Lưu lại kết quả thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @GetMapping("/api/ketquaLopCamTinh/ds_kqLopCamTinh")
    public ResponseEntity<ResponeData> getAllDanhSachByDot(@RequestParam("dot") String name) {
        System.out.println(name);
        List<KetQuaLopCamTinh> list = ketQuaLopCamTinhServiceImp.getListDanhSachByDot(name);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Lấy ra danh sách đoàn viên ưu tú theo đợt thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}

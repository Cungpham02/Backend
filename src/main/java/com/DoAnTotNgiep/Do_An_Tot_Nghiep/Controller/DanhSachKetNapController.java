package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DanhSachKetNapServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin("*")
public class DanhSachKetNapController {
    @Autowired
    private DanhSachKetNapServiceImp danhsachKetNapServiceImp;
    @Autowired
    private ResponeData responeData;
    @Autowired
    private FileService fileService;
    @PostMapping("/api/dangvien/save_ketnapdang")
    public ResponseEntity<ResponeData> saveAll(@RequestBody List<DanhSachKetNapDang> sinhVienList) {
        List<DanhSachKetNapDang> list = danhsachKetNapServiceImp.addListOfSinhVien(sinhVienList);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thêm vào danh sách kết nạp đảng thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @GetMapping("/api/dangvien/getListDanhSachKetNapDang")
    public ResponseEntity<?> getListDanhSachPhatTrienDang(@RequestParam("dot") String name){
        List<DanhSachKetNapDang> listDanhSach=danhsachKetNapServiceImp.getListDanhSachKetNapDang(name);
        responeData.setData(listDanhSach);
        responeData.setIsSuccess(true);
        responeData.setMessage("Lấy danh sách thành công");
        return new ResponseEntity<>(responeData,HttpStatus.OK);
    }
    @PutMapping("/api/dangvien/updateKetnapDang")
    public ResponseEntity<?> updateDangVienByMssv(@RequestParam("mssv") String mssv,
        @RequestParam("file") MultipartFile file,@RequestParam("file2") MultipartFile file2,
                @RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,
                @RequestParam("file5") MultipartFile file5,@RequestParam("file6") MultipartFile file6,
                @RequestParam("file7") MultipartFile file7,@RequestParam("file8") MultipartFile file8,@RequestParam("file9") MultipartFile file9){
            System.out.println(mssv);
            DanhSachKetNapDang danhSachKetNapDang=danhsachKetNapServiceImp.getDangVienByMSSV(mssv);
            if(danhSachKetNapDang!=null){
                fileService.saveFile(file);
                fileService.saveFile(file2);
                fileService.saveFile(file3);
                fileService.saveFile(file4);
                fileService.saveFile(file5);
                fileService.saveFile(file6);
                fileService.saveFile(file7);
                fileService.saveFile(file8);
                fileService.saveFile(file9);
                danhSachKetNapDang.setBantukiemdiem(file2.getOriginalFilename());
                danhSachKetNapDang.setBienbanhopchibo(file7.getOriginalFilename());
                danhSachKetNapDang.setBienbanhopchidoan(file3.getOriginalFilename());
                danhSachKetNapDang.setDonxinvaodang(file.getOriginalFilename());
                danhSachKetNapDang.setNghiquyetchibo(file8.getOriginalFilename());
                danhSachKetNapDang.setNghiquyetchidoan(file4.getOriginalFilename());
                danhSachKetNapDang.setNghiquyetdoantruong(file5.getOriginalFilename());
                danhSachKetNapDang.setTonghopykien(file6.getOriginalFilename());
                danhSachKetNapDang.setGiaygioithieu(file9.getOriginalFilename());
                danhsachKetNapServiceImp.save(danhSachKetNapDang);
                responeData.setMessage("Cập nhật thành công");
                responeData.setIsSuccess(true);
            }

            return new ResponseEntity<>(responeData, HttpStatus.OK);

    }
}

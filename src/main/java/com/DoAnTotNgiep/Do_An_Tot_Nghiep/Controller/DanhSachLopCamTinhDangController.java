package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DanhsachLopCamTinhDangServiceIMP;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DanhsachLopCamTinhDangService;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.ExcerGenertor;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.ExportExcelDanhSachCamTinh;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
public class DanhSachLopCamTinhDangController {
    @Autowired
    private DanhsachLopCamTinhDangServiceIMP danhsachLopCamTinhDangServiceIMP;

    @Autowired
    private ResponeData responeData;

    @PostMapping("/save_lopcamtinh")
    public ResponseEntity<ResponeData> saveAll(@RequestBody List<DanhSachLopCamTinhDang> sinhVienList) {
        List<DanhSachLopCamTinhDang> list = danhsachLopCamTinhDangServiceIMP.addListOfSinhVien(sinhVienList);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thêm vào danh sách lớp cảm tình đảng thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @PostMapping("/save_daonvienuutu")
    public ResponseEntity<ResponeData> saveAllDoanVienUuTu(@RequestBody List<DoanVienUuTu> doanVienUuTuList) {
        List<DoanVienUuTu> list = danhsachLopCamTinhDangServiceIMP.addListOfDoanVienUuTu(doanVienUuTuList);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thêm vào danh sách đoàn viên ưu tú thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    @GetMapping("/doanvien/danhsachlopcamtinh")
    public ResponseEntity<ResponeData> getAllDanhSach() {
        List<DanhSachLopCamTinhDang> list = danhsachLopCamTinhDangServiceIMP.getListDanhSach();
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thêm vào danh sách lớp cảm tình đảng thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    @GetMapping("/doanvien/danhsachlopcamtinhByDot")
    public ResponseEntity<ResponeData> getAllDanhSachByDot(@RequestParam("dot") String name) {
        List<DanhSachLopCamTinhDang> list = danhsachLopCamTinhDangServiceIMP.getListDanhSachByDot(name);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thêm vào danh sách lớp cảm tình đảng thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    @GetMapping("/doanvien/danhsachlopcamtinhByDot/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response, @RequestParam("dot") String name) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=student" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<DanhSachLopCamTinhDang> listOfStudents = danhsachLopCamTinhDangServiceIMP.getListDanhSachByDot(name);
        ExportExcelDanhSachCamTinh generator = new ExportExcelDanhSachCamTinh(listOfStudents);
        generator.generateExcelFile(response);
    }
    @GetMapping("/doanvien/getListDanhSachPhatTrienDang")
    public ResponseEntity<?> getListDanhSachPhatTrienDang(@RequestParam("dot") String name){
        List<DanhSachLopCamTinhDang> listDanhSach=danhsachLopCamTinhDangServiceIMP.getListDanhSachPhatTrienDang(name);
        responeData.setData(listDanhSach);
        responeData.setIsSuccess(true);
        responeData.setMessage("Lấy danh sách thành công");
        return new ResponseEntity<>(responeData,HttpStatus.OK);
    }

//    @PostMapping("/savekq_lopcamtinh")
//    public ResponseEntity<ResponeData> saveKetQuaAll(@RequestBody List<DanhSachLopCamTinhDang> sinhVienList) {
//        for (DanhSachLopCamTinhDang ds : sinhVienList) {
//            DanhSachLopCamTinhDang camTinhDang = new DanhSachLopCamTinhDang();
//            camTinhDang = danhsachLopCamTinhDangServiceIMP.findByMssv(ds.getMssv());
//            System.out.println(camTinhDang);
//            danhsachLopCamTinhDangServiceIMP.save(camTinhDang);
//        }
//        responeData.setIsSuccess(true);
//        responeData.setMessage("Lưu lại kết quả thành công");
//        return new ResponseEntity<>(responeData, HttpStatus.OK);
//    }

}

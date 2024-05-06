package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienPhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGiaDangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienPhieuDanhGiaServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.PhieuDanhGiaDangVienServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.PhieuDanhGiaServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienDangVienChuyenDenDTO;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.PhieuDanhGiaDangVienDTO;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.PhieuDanhGiaDangVirnDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/phieudanhgia")
public class PhieuDanhGiaDangVienController {
    @Autowired
    private PhieuDanhGiaServiceImp phieuDanhGiaServiceImp;
    @Autowired
    private DangVienPhieuDanhGiaServiceImp dangVienPhieuDanhGiaServiceImp;
    @Autowired
    private PhieuDanhGiaDangVienServiceImp phieuDanhGiaDangVienServiceImp;
    @Autowired
    private ResponeData responeData;

    @PostMapping("/addPhieuDanhGia")
    public ResponseEntity<?> save(@RequestParam("data") byte[] data,
            @RequestParam("chonDot") String chonDot,
            @RequestParam("tongDiem") int tongDiem,
            @RequestParam("trangthai") String trangthai,
            @RequestParam("id_dangvien") Long id_dangvien,
    @RequestParam("xeploai") String xeploai) {
        PhieuDanhGia phieuDanhGia = phieuDanhGiaServiceImp.getPhieuDanhGiaByIdDVAndByDot(chonDot, id_dangvien);
        DangVienPhieuDanhGia dangVienPhieuDanhGia = dangVienPhieuDanhGiaServiceImp.findByID(phieuDanhGia.getId(),
                id_dangvien);
        System.out.println(dangVienPhieuDanhGia.getId());
        dangVienPhieuDanhGia.setActive(true);
        PhieuDanhGiaDangVien phieuDanhGiaDangVien = new PhieuDanhGiaDangVien();
        phieuDanhGiaDangVien.setData(data);
        phieuDanhGiaDangVien.setChonDot(chonDot);
        phieuDanhGiaDangVien.setXeploai(xeploai);
        phieuDanhGiaDangVien.setTongDiem(tongDiem);
        phieuDanhGiaDangVien.setId_dangvien(id_dangvien);
        phieuDanhGiaDangVien.setTrangthai("không_hoàn_thành");
        phieuDanhGiaDangVienServiceImp.save(phieuDanhGiaDangVien);
        responeData.setIsSuccess(true);
        responeData.setMessage("Đánh giá đã được ghi lại");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    @GetMapping("/getPhieuDanhGiaDangVien")
    public ResponseEntity<?> getPhieuDanhGia(@RequestParam("dot") String dot,
            @RequestParam("id_dangvien") Long dangvienId) {
        PhieuDanhGiaDangVien phieuDanhGiaDangVien = phieuDanhGiaDangVienServiceImp.getPhieuDanhGia(dangvienId, dot);
        System.out.println(phieuDanhGiaDangVien.getId());
        if (phieuDanhGiaDangVien.getTrangthai().equals("không_hoàn_thành")) {
            responeData.setIsSuccess(false);
            responeData.setData("");
            responeData.setMessage("Bạn đã gửi bản đánh giá chờ kt quả từ bí thư");
            return ResponseEntity.ok().body(responeData);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String jsonData = mapper.writeValueAsString(phieuDanhGiaDangVien.getData());
                return ResponseEntity.ok().body(phieuDanhGiaDangVien.getData());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(phieuDanhGiaDangVienServiceImp.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllPhieuDanhGiaByDot")
    public ResponseEntity<?> getAllByDotPhieuDanhGia(@RequestParam("chonDot") String chonDot) {
        return new ResponseEntity<>(phieuDanhGiaDangVienServiceImp.getListDangVienByDot(chonDot), HttpStatus.OK);
    }

    @PutMapping("/updateById")
    public ResponseEntity<?> updateById(@RequestBody PhieuDanhGiaDangVirnDTO phieuDanhGiaDangVirnDTO) {
        Boolean isCheck = false;
        if (phieuDanhGiaDangVirnDTO.getTrangthai().equals("Đạt")) {
            isCheck = true;
        } else if (phieuDanhGiaDangVirnDTO.getTrangthai().equals("Không đạt")) {
            isCheck = false;

        }
        phieuDanhGiaDangVienServiceImp.updateDangVienPhieuDanhGiaById(phieuDanhGiaDangVirnDTO.getId(), isCheck);
        return new ResponseEntity<>("update thành công", HttpStatus.OK);

    }

    @GetMapping("/countDangVienByDot")
    public ResponseEntity<?> countPhieuDanhGia(@RequestParam("chonDot") String chonDot) {
        Long count = dangVienPhieuDanhGiaServiceImp.getCountDangVienChuaDanhGiaByDot(chonDot);
        responeData.setData(count);
        responeData.setIsSuccess(true);
        responeData.setMessage("Lấy ra danh sách đảng viên chưa đánh giá tại đợt " + chonDot + " thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @PostMapping("/update-trangthai")
    public ResponseEntity<?> updateStatus(@RequestBody List<PhieuDanhGiaDangVien> dtoList) {
        try {
            phieuDanhGiaDangVienServiceImp.updateTrangThai(dtoList);
            responeData.setIsSuccess(true);
            responeData.setMessage("Cập nhật thành công");
            return ResponseEntity.ok(responeData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating status");
        }
    }
    @GetMapping("/getListDangVienNyDot")
    public ResponseEntity<?> getListByDotPhieuDanhGia(@RequestParam("chonDot") String chonDot) {
        List<PhieuDanhGiaDangVienDTO> list= phieuDanhGiaDangVienServiceImp.getListDangVienByDotPhieuDanhGia(chonDot);
        responeData.setData(list);
        responeData.setIsSuccess(true);

        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}

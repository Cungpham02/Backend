package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachDangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DanhSachDangVienServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.ExcerGenertor;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DangVienService;

import jakarta.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/dv/")
public class DangVienController {
    @Autowired
    private DangVienServiceImp dangVienServiceImp;
    @Autowired
    private DangVien dangVien;
    @Autowired
    private ResponeData responeData;
    @Autowired
    private DanhSachDangVienServiceImp danhSachDangVienServiceImp;

    // Hàm thêm mới 1 đảng viên => thêm mới 1 đảng viên trong danh sách đảng viên http://localhost:8000/api/dv/addDangVien
    @PostMapping(value = "addDangVien")
    @PreAuthorize("hasRole('ROLE_BT')")
    public ResponseEntity<ResponeData> addDangVienMoi(@RequestBody DangVien DangVien) {

        Boolean isCheckMdd=dangVienServiceImp.isCheck(DangVien.getMdd());
        System.out.println(isCheckMdd);
        if(isCheckMdd){
            dangVien.setTrangthai(true);
            dangVien = dangVienServiceImp.saveDangVien(DangVien);
            DanhSachDangVien danhSachDangVien=new DanhSachDangVien();
            danhSachDangVien.setFullname(dangVien.getFullname());
            danhSachDangVien.setNgayvaodang(dangVien.getNgayvaodang());
            danhSachDangVien.setNgaychinhthuc(dangVien.getNgaychinhthuc());
            danhSachDangVien.setKhoaquanly(dangVien.getKhoaquanly());
            danhSachDangVien.setLopquanly(dangVien.getLopquanly());
            danhSachDangVien.setSodienthoai(dangVien.getSodienthoai());
            danhSachDangVien.setNgaysinh(dangVien.getNgaysinh());
            danhSachDangVien.setTrangthai(dangVien.getTrangthai());
            danhSachDangVien.setDangVien(dangVien);
            danhSachDangVienServiceImp.saveDangVien(danhSachDangVien);
            if (dangVien != null) {
                responeData.setData(dangVien);
                responeData.setIsSuccess(true);
                responeData.setMessage("Thêm mới đảng viên thành công");
            } else {
                responeData.setData("");
                responeData.setIsSuccess(false);
                responeData.setMessage("Thêm mới đảng viên thất bại");
            }
        }
        else{
            responeData.setData("");
            responeData.setIsSuccess(false);
            responeData.setMessage("Mã định danh đảng viên đã tồn tại !");
        }

        // Thêm đảng viên vào cơ sở dữ liệu
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    //Hàm cập nhât thông tin đảng viên theo id
    @PutMapping("UpdateDangVien")
    @PreAuthorize("hasRole('ROLE_BT')")
    public ResponseEntity<ResponeData> updatePartyMember(@PathParam("id") String id,
            @RequestBody DangVien newDangVien) {
        // Cập nhật thông tin đảng viên trong cơ sở dữ liệu
        Long idDangVien = Long.parseLong(id);
        dangVienServiceImp.updateDangVienById(idDangVien, newDangVien);
        responeData.setIsSuccess(true);
        responeData.setMessage("Update thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    //Hàm xóa đảng viên theo id
    @GetMapping("deleteDangVien")
    @PreAuthorize("hasRole('ROLE_BT')")
    public String deletePartyMember(@PathParam("id") String id) {
        Long idDangVien = Long.parseLong(id);
        if (idDangVien != null) {
            dangVienServiceImp.deleteDangVien(idDangVien);

        } else {
            System.out.println("Không tồn tại Đảng viên có id " + id);
        }
        // Xóa đảng viên khỏi cơ sở dữ liệu
        return "Xóa đảng viên";
    }

    //Lấy thông tin đảng viên theo id
    @GetMapping("/dangviens")
    public ResponseEntity<?> getDangVienById(@RequestParam("id") String id) {
        System.out.println(id);
        Optional<DangVien> dv = dangVienServiceImp.findById(Long.parseLong(id));
        if (dv.isPresent()) {
            return new ResponseEntity<>(dv.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy dữ liệu với ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    //Lấy ra danh sách đảng viên
    @GetMapping("getListDangVien")
    public ResponseEntity<ResponeData> getListDangVien() {
        List<DangVien> listDV = dangVienServiceImp.getListDangVien();
        ResponeData responeData = new ResponeData();
        if (listDV.size() == 0) {
            responeData.setData(listDV);
            responeData.setMessage("Không có bản ghi nào");
        } else {
            responeData.setData(listDV);
        }
        return new ResponseEntity<>(responeData, HttpStatus.OK);

    }
    @GetMapping("getListDangVienChinhThuc")
    public ResponseEntity<ResponeData> getListDangVienChinhThuc() {
        List<DangVien> listDV = dangVienServiceImp.getListDangVienChinhThuc();
        ResponeData responeData = new ResponeData();
        if (listDV.size() == 0) {
            responeData.setData(listDV);
            responeData.setMessage("Không có bản ghi nào");
        } else {
            responeData.setData(listDV);
        }
        return new ResponseEntity<>(responeData, HttpStatus.OK);

    }

    //Xuất danh sách đảng viên
    @GetMapping("export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=student" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<DangVien> listOfStudents = dangVienServiceImp.getListDangVien();
        ExcerGenertor generator = new ExcerGenertor(listOfStudents);
        generator.generateExcelFile(response);
    }

    //Tìm kiếm danh sách đảng viên theo họ và tên
    @GetMapping("/searchIds")
    @ResponseBody
    public List<DangVien> searchDoanViensByHoTen(@RequestParam("ids") List<Long> ids) {
        // Gọi phương thức của repository để tìm kiếm đảng viên bằng họ và tên
        return dangVienServiceImp.findDangVienByIds(ids);
    }
    @GetMapping("search")
    @ResponseBody
    public List<DangVien> getListByUsername(@RequestParam("search_input") String fullname) {
        // Gọi phương thức của repository để tìm kiếm đảng viên bằng họ và tên
        return dangVienServiceImp.findByFullname(fullname);
    }
    @GetMapping("listDanhSachDangVienNoTaiKhoan")
    public List<DangVien> getList(){
       return  dangVienServiceImp.getListDangVienNotTk();
    }
    @GetMapping("{filed}")
    public List<DangVien> getListSort(@PathVariable String filed){
        List<DangVien> listAll=dangVienServiceImp.getAllDangVienSort(filed);
        return listAll;

    }
    @GetMapping("/panigation/{offset}/{pagesize}")
    public Page<DangVien> getListByPanigation(@PathVariable int offset, @PathVariable int pagesize){
        Page<DangVien> listAll=dangVienServiceImp.getAllDangVienPanigation(offset,pagesize);
        return listAll;

    }
}

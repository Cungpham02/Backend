package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import java.util.List;
import java.util.Optional;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.PhieuDanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.DangVienReposiroty;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.UserRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.DangVienService;

@Service
public class DangVienServiceImp implements DangVienService {
    @Autowired
    private DangVienReposiroty dangVienReposiroty;

    @Autowired
    private PhieuDanhGiaRepository phieuDanhGiaRepository;
    @Autowired
    private UserRepository userRepository;

    // Thêm đảng viên mới
    @Override
    public DangVien saveDangVien(DangVien dangVien) {
        DangVien dv = dangVienReposiroty.save(dangVien);
        return dv;
    }

    // Xóa đảng viên theo id
    @Override
    public void deleteDangVien(Long id) {
        dangVienReposiroty.deleteById(id);
    }

    // THực hiện truy vấn trong mysql
    @Override
    public Optional<DangVien> findById(Long id) {
        Optional<DangVien> dv = dangVienReposiroty.findById(id);
        return dv;
    }

    // Tìm kiếm Đảng viên theo id
    @Override
    public DangVien findById2(Long id) {
        DangVien dv = dangVienReposiroty.findById2(id);
        return dv;
    }

    public DangVien findByFullName(String id) {
        DangVien dv = dangVienReposiroty.findByFullname(id);
        return dv;
    }

    // Cập nhật thông tin đảng vieen theo id
    @Override
    public void updateDangVienById(Long id, DangVien newDangVien) {
        Optional<DangVien> optionalDangVien = dangVienReposiroty.findById(id);
        if (optionalDangVien.isPresent()) {
            DangVien existingDangVien = optionalDangVien.get();
            // Cập nhật thông tin của đảng viên
            existingDangVien.setFullname(newDangVien.getFullname());
            existingDangVien.setCccd(newDangVien.getCccd());
            existingDangVien.setDantoc(newDangVien.getDantoc());
            existingDangVien.setGioitinh(newDangVien.getGioitinh());
            existingDangVien.setKhenthuong(newDangVien.getKhenthuong());
            existingDangVien.setKyluat(newDangVien.getKyluat());
            existingDangVien.setNgayvaodang(newDangVien.getNgayvaodang());
            existingDangVien.setNgaychinhthuc(newDangVien.getNgaychinhthuc());
            existingDangVien.setNgayvaodoan(newDangVien.getNgayvaodoan());
            existingDangVien.setNgaysinh(newDangVien.getNgaysinh());
            existingDangVien.setQuequan(newDangVien.getQuequan());
            existingDangVien.setThuongtru(newDangVien.getThuongtru());
            existingDangVien.setNoisinh(newDangVien.getNoisinh());
            existingDangVien.setQuatrinhhd(newDangVien.getQuatrinhhd());
            existingDangVien.setSodienthoai(newDangVien.getSodienthoai());
            existingDangVien.setLopquanly(newDangVien.getLopquanly());
            existingDangVien.setKhoaquanly(newDangVien.getKhoaquanly());
            existingDangVien.setGmail(newDangVien.getGmail());
            existingDangVien.setTongiao(newDangVien.getTongiao());

            existingDangVien.setTrinhdo(newDangVien.getTrinhdo());
            // Cập nhật các trường thông tin khác tương tự
            dangVienReposiroty.save(existingDangVien);
        } else {
            // Xử lý trường hợp không tìm thấy đảng viên
            System.out.println("Không tồn tại id mà cập nhât");
        }
    }

    public Boolean isCheck(String mdd) {
        if (dangVienReposiroty.findByMdd(mdd) == null) {
            return true;
        } else {
            return false;
        }
    }

    // Lấy ra danh sách đảng viên
    @Override
    public List<DangVien> getListDangVien() {
        return dangVienReposiroty.findAll();
    }

    // Tìm kiếm Đảng viên theo tên
    @Override
    public List<DangVien> findByFullname(String name) {
        return dangVienReposiroty.findByListFullname(name);
    }

    // Lấy thông tin đảng viên theo tên tài khoản
    @Override
    public DangVien getDangVienByUsername(String username) {
        // Tìm user dựa trên username
        User user = userRepository.findByUsername(username);
        if (user != null) {
            // Nếu tìm thấy user, lấy đảng viên tương ứng dựa trên user_id
            return dangVienReposiroty.findByUser(user);
        }
        return null;
    }

    // Hàm lấy thông tin đảng viên theo danh sách ids
    @Override
    public List<DangVien> findDangVienByIds(List<Long> ids) {
        return dangVienReposiroty.findDangVienByIds(ids);
    }

    public DangVien findByMDD(String mdd) {
        DangVien dangVien = dangVienReposiroty.findByMdd(mdd);
        if (dangVien == null) {
            return null;
        } else {
            return dangVien;
        }
    }

    public Boolean checkPhone(String sdt) {
        Long count = dangVienReposiroty.countSdd(sdt);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<DangVien> getAllDangVienSort(String filed) {
        return dangVienReposiroty.findAll(Sort.by(Sort.Direction.ASC, filed));
    }

    public Page<DangVien> getAllDangVienPanigation(int offset, int pagesize) {
        Page<DangVien> dangViens = dangVienReposiroty.findAll(PageRequest.of(offset, pagesize));
        return dangViens;
    }

    public List<DangVien> getListDangVienNotTk() {
        return dangVienReposiroty.getListDanhSachNotTaiKhoan();
    }
    public List<DangVien> getListDangVienChinhThuc(){

        return dangVienReposiroty.getListDangVienChinhThuc();
    }
}

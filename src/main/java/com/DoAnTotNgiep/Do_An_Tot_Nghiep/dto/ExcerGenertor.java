package com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcerGenertor {

    private List<DangVien> dangVienList;
    private List<DanhSachLopCamTinhDang> danhSachLopCamTinhDangs;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcerGenertor(List<DangVien> dangVienList) {
        this.dangVienList = dangVienList;
        workbook = new XSSFWorkbook();
    }

    // public ExcerGenertor(List<DanhSachLopCamTinhDang> danhSachLopCamTinhDangs) {

    // this.danhSachLopCamTinhDangs = danhSachLopCamTinhDangs;
    // workbook = new XSSFWorkbook();
    // }

    // public ExcerGenertor(List<DangVien> dangVienList) {
    // this.dangVienList = dangVienList;
    // workbook = new XSSFWorkbook();
    // }

    private void writeHeader() {
        sheet = workbook.createSheet("Danh sách đảng viên");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "STT", style);
        createCell(row, 1, "Mã định danh", style);
        createCell(row, 2, "Họ và tên", style);
        createCell(row, 3, "Ngày sinh", style);
        createCell(row, 4, "Giới tính", style);
        createCell(row, 5, "CCCD", style);
        createCell(row, 6, "Ngày vào đoàn", style);
        createCell(row, 7, "Quê quán", style);
        createCell(row, 8, "Thường trú", style);
        createCell(row, 9, "Tạm trú", style);
        createCell(row, 10, "Nơi sinh", style);
        createCell(row, 11, "Dân tộc", style);
        createCell(row, 12, "Tôn giáo", style);
        createCell(row, 13, "Quá trình hoạt động", style);

        // Đặt chiều rộng của cột ngày sinh
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 1000);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
            cell.setCellStyle(style);
        }
    }

    private void write() {
        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

        int rowCount = 1; // Bắt đầu từ hàng thứ 2 vì hàng đầu tiên là tiêu đề
        for (DangVien record : dangVienList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId(), null);
            createCell(row, columnCount++, record.getMdd(), null);
            createCell(row, columnCount++, record.getFullname(), null);
            createCell(row, columnCount++, record.getNgaysinh(), dateCellStyle); // Sử dụng cellStyle ở đây
            createCell(row, columnCount++, record.getGioitinh(),null);
            createCell(row, columnCount++, record.getCccd(),null);
            createCell(row, columnCount++, record.getNgayvaodoan(), dateCellStyle);

            createCell(row, columnCount++, record.getQuequan(), null);
            createCell(row, columnCount++, record.getThuongtru(), null);
            createCell(row, columnCount++, record.getTamtru(), null);
            createCell(row, columnCount++, record.getNoisinh(), null);
            createCell(row, columnCount++, record.getDantoc(), null);
            createCell(row, columnCount++, record.getTongiao(), null);
            createCell(row, columnCount++, record.getQuatrinhhd(), null);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

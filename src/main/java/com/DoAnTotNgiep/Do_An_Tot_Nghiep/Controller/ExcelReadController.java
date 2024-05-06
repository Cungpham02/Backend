package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.ExcelRowData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.ExcelRowDataDanhsachCamTinh;

import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ExcelReadController {

    @PostMapping("/readExcel")
    public List<ExcelRowData> readExcel(@RequestParam("file") MultipartFile file) throws IOException {
        List<ExcelRowData> dataList = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        // Biến đếm dùng để bỏ qua dòng đầu tiên
        int rowCount = 0;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Bỏ qua dòng đầu tiên
            if (rowCount == 0) {
                rowCount++;
                continue;
            }

            ExcelRowData rowData = new ExcelRowData();

            Iterator<Cell> cellIterator = row.cellIterator();
            int columnIndex = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        if (columnIndex == 1) {
                            rowData.setFullname(cell.getStringCellValue());
                        } else if (columnIndex == 3) {
                            rowData.setDiemTrungBinh(cell.getStringCellValue());
                        } else if (columnIndex == 5) {
                            rowData.setQuequan(cell.getStringCellValue());
                        }

                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell) && columnIndex == 2) {
                            rowData.setNgaysinh(cell.getDateCellValue());
                        }else if (columnIndex == 4) {
                            rowData.setMssv(cell.getNumericCellValue());
                        }else if (columnIndex == 0) {
                            rowData.setId(cell.getNumericCellValue());
                        }
                        break;
                    default:
                }
                columnIndex++;
            }
            dataList.add(rowData);
        }

        workbook.close();
        return dataList;
    }

    @PostMapping("/readExcelDanhSachCamTinh")
    public List<ExcelRowDataDanhsachCamTinh> readExcelCamTinh(@RequestParam("file") MultipartFile file)
            throws IOException {
        List<ExcelRowDataDanhsachCamTinh> dataList = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        // Biến đếm dùng để bỏ qua dòng đầu tiên
        int rowCount = 0;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Bỏ qua dòng đầu tiên
            if (rowCount == 0) {
                rowCount++;
                continue;
            }

            ExcelRowDataDanhsachCamTinh rowData = new ExcelRowDataDanhsachCamTinh();

            Iterator<Cell> cellIterator = row.cellIterator();
            int columnIndex = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        if (columnIndex == 6) {
                            rowData.setKetqua(cell.getStringCellValue());
                        } else if (columnIndex == 4) {
                            rowData.setQuequan(cell.getStringCellValue());
                        } else if (columnIndex == 2) {
                            rowData.setFullname(cell.getStringCellValue());
                        }
                        break;
                    case NUMERIC:
                        if (columnIndex == 0) {
                            rowData.setId(cell.getNumericCellValue());
                        } else if (DateUtil.isCellDateFormatted(cell) && columnIndex == 3) {
                            rowData.setNgaysinh(cell.getDateCellValue());
                        } else if (columnIndex == 1) {
                            rowData.setMssv(cell.getNumericCellValue());
                        }else if (columnIndex == 5) {
                            rowData.setDiemTrungBinh(cell.getNumericCellValue());
                        }
                        break;
                    default:
                }
                columnIndex++;
            }
            dataList.add(rowData);
        }

        workbook.close();
        return dataList;
    }
}

package supports;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readTestData {
    public static Map<String, testData> readTestDataFromExcel(String excelFilePath) {
        Map<String, testData> testDataMap = new HashMap<>();
        try {
            FileInputStream excelFile = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(2); // Lấy sheet thứ ba

            // Bắt đầu từ hàng 13 (index 12)
            for (int i = 12; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow != null) {
                    Cell testCaseIdCell = currentRow.getCell(1); // Cột B (index 1)
                    Cell testDataCell = currentRow.getCell(5); // Cột F (index 5)

                    // Kiểm tra nếu ô không rỗng
                    if (testCaseIdCell != null && testDataCell != null) {
                        String testCaseId = testCaseIdCell.getStringCellValue();
                        String testDataString = testDataCell.getStringCellValue();

                        String[] lines = testDataString.split("\n");

                        Map<String, String> dataMap = new HashMap<>();
                        for (String line : lines) {
                            // Loại bỏ gạch đầu dòng và khoảng trắng đầu dòng
                            line = line.replaceFirst("- ", "").trim();
                            String[] keyValue = line.split(": ", 2);
                            if (keyValue.length == 2) {
                                String key = keyValue[0].trim();
                                String value = keyValue[1].trim();
                                dataMap.put(key, value);
                            }
                        }

                        // Lấy dữ liệu sau dấu ":"
                        String url = dataMap.get("url");
                        String username = dataMap.get("username");
                        String password = dataMap.get("password");
                        String reqCode = dataMap.get("reqCode");
                        String status = dataMap.get("status");
                        String applicant = dataMap.get("applicant");
                        String dept = dataMap.get("dept");
                        String section = dataMap.get("section");
                        String depot = dataMap.get("depot");
                        String unit = dataMap.get("unit");
                        String reqDate = dataMap.get("reqDate");
                        String reportType = dataMap.get("reportType");
                        String reportDate = dataMap.get("reportDate");
                        String reportPrintDate = dataMap.get("reportPrintDate");
                        String note = dataMap.get("note");
                        String printReasonDifferentDate = dataMap.get("printReasonDifferentDate");
                        String pathOfReportForSignature = dataMap.get("pathOfReportForSignature");
                        String reportForSignature = dataMap.get("reportForSignature");
                        String referenceDocs = dataMap.get("referenceDocs");
                        String employee1 = dataMap.get("employee1");
                        String employee2 = dataMap.get("employee2");
                        String salesSupport = dataMap.get("salesSupport");
                        String manager = dataMap.get("manager");

                        testDataMap.put(testCaseId, new testData(
                                testCaseId, url, username, password, reqCode, status, applicant, dept, section, depot, unit,
                                reqDate, reportType, reportDate, reportPrintDate, note, printReasonDifferentDate,
                                pathOfReportForSignature, reportForSignature, referenceDocs, employee1, employee2,
                                salesSupport, manager
                        ));
                    }
                }
            }

            workbook.close();
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testDataMap;
    }
}

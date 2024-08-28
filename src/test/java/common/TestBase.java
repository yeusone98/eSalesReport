package common;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import supports.readTestData;
import supports.testData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import static supports.Browser.*;

public class TestBase {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    protected void setUp() {
        try {
            startRecording("TestRecording");
        } catch (Exception e) {
            e.printStackTrace();
        }
        launchBrowser("chrome");
    }

    @DataProvider(name = "excelData")
    public Object[][] dataProviderMethod() {
        Map<String, testData> testDataMap = readTestData.readTestDataFromExcel("D:/Opus Solution/testData.xlsx");
        Object[][] data = new Object[testDataMap.size()][1];
        int index = 0;
        for (Map.Entry<String, testData> entry : testDataMap.entrySet()) {
            data[index++][0] = entry.getValue();
        }
        return data;
    }

    @DataProvider(name = "filteredExcelData")
    public Object[][] filteredDataProviderMethod(Method method) {
        String testCaseID = method.getName();
        Map<String, testData> testDataMap = readTestData.readTestDataFromExcel("D:/Opus Solution/testData.xlsx");
        return testDataMap.values().stream()
                .filter(data -> data.getTestCaseId().equals(testCaseID))
                .map(data -> new Object[]{data})
                .toArray(Object[][]::new);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult result) {
        String testCaseID = result.getMethod().getMethodName();
        String status = result.isSuccess() ? "Pass" : "Fail";

        // Cập nhật kết quả vào file Excel
        TestResultInExcel(testCaseID, status);

        if (!result.isSuccess()) {
            TakeScreenShot(result.getMethod().getMethodName());
        }
        try {
            stopRecording();
        } catch (Exception e) {
            e.printStackTrace();
        }
        quit();
    }

    public void TestResultInExcel(String testCaseID, String status) {
        String excelFilePath = "D:/Opus Solution/testData.xlsx";
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
             CellStyle style = workbook.createCellStyle();
             style.setVerticalAlignment(VerticalAlignment.TOP);
             style.setBorderRight(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
            Sheet sheet = workbook.getSheetAt(2); // Giả sử dữ liệu nằm ở sheet thứ ba
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i = 12; i < rowCount; i++) { // Bắt đầu từ hàng 13 (index 12)
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell testCaseCell = row.getCell(1); // Giả sử TestCase ID nằm ở cột thứ hai (index 1)

                    if (testCaseCell != null && testCaseCell.getStringCellValue().equals(testCaseID)) {
                        Cell resultCell = row.createCell(8); // Giả sử cột Result là cột thứ 9 (index 8)
                        resultCell.setCellValue(status);
                        resultCell.setCellStyle(style);
                        break;
                    }
                }
            }

            try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


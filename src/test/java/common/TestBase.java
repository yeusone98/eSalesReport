package common;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import supports.readTestData;
import supports.testData;

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
}

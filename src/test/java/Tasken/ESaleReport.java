package Tasken;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ESaleReportPage;
import supports.testData;

import java.awt.*;

import static java.lang.Thread.sleep;

public class ESaleReport extends TestBase {
    ESaleReportPage eSaleReportPage = new ESaleReportPage();

    @Test(dataProvider = "filteredExcelData", priority = 1)
    void TC_01(testData data) {
        // 1. Vào trang web

        eSaleReportPage.open();

        // 2. Nhấn nút Login
        eSaleReportPage.clickLoginButton();

        // 3. Nhập tên đăng nhập và nhấn Tiếp theo
        eSaleReportPage.fillUsername(data.getUsername());
        // 4. Nhập mật khẩu
        eSaleReportPage.fillPassword(data.getPassword());
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();

        Assert.assertEquals(eSaleReportPage.verifyLoginSuccessfully(), "OPUS SOLUTION COMPANY");
    }


    @Test(dataProvider = "filteredExcelData", priority = 2)
    void TC_02(testData data) throws AWTException {

        // 1. Vào trang web

        eSaleReportPage.open();

        // 2. Nhấn nút Login
        eSaleReportPage.clickLoginButton();

        // 3. Nhập tên đăng nhập và nhấn Tiếp theo
        eSaleReportPage.fillUsername(data.getUsername());
        // 4. Nhập mật khẩu
        eSaleReportPage.fillPassword(data.getPassword());
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();

        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();

        eSaleReportPage.clickCreateReq();
        eSaleReportPage.fillDept(data.getDept());
        eSaleReportPage.fillSection(data.getSection());
        eSaleReportPage.fillUnit(data.getUnit());
        eSaleReportPage.importReportSubmitted(data.getPathOfReportForSignature());
        eSaleReportPage.selectEmployee2(data.getEmployee2());
        eSaleReportPage.selectSaleSupport(data.getSalesSupport());
        eSaleReportPage.selectManager(data.getManager());
        eSaleReportPage.clickSent();
        Assert.assertEquals(eSaleReportPage.verifynotiCreateSuccess(), "Tạo mới yêu cầu thành công");
        eSaleReportPage.reqCodeWasCreated();
    }

    @Test(dataProvider = "filteredExcelData", priority = 3)
    void TC_03(testData data) throws AWTException {

        // 1. Vào trang web

        eSaleReportPage.open();

        // 2. Nhấn nút Login
        eSaleReportPage.clickLoginButton();

        // 3. Nhập tên đăng nhập và nhấn Tiếp theo
        eSaleReportPage.fillUsername(data.getUsername());
        // 4. Nhập mật khẩu
        eSaleReportPage.fillPassword(data.getPassword());
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();

        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();

        eSaleReportPage.clickCreateReq();
        eSaleReportPage.fillDept(data.getDept());
        eSaleReportPage.fillSection(data.getSection());
        eSaleReportPage.fillUnit(data.getUnit());
        eSaleReportPage.importReportSubmitted(data.getPathOfReportForSignature());
        eSaleReportPage.selectEmployee2(data.getEmployee2());
        eSaleReportPage.selectSaleSupport(data.getSalesSupport());
        eSaleReportPage.selectManager(data.getManager());

        eSaleReportPage.clickSent();

        Assert.assertEquals(eSaleReportPage.verifynotiCreateSuccess(), "Tạo mới yêu cầu thành công");
    }



    @Test(priority = 3)
    void TC_020() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Đề xuất"" và chọn mục con ""Tất cả đề xuất""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        Assert.assertTrue(eSaleReportPage.verifySubMenuTatCaDeXuatIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='160-eSR-COT-2024']"), "160-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='063-eSR-HBCONS-2024']"), "063-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='159-eSR-COT-2024']"), "159-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='155-eSR-COT-2024']"), "155-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='151-eSR-COT-2024']"), "151-eSR-COT-2024");

    }

    @Test(priority = 4)
    void TC_021() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Đề xuất"" và chọn mục con ""Gửi đến tôi""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        Assert.assertTrue(eSaleReportPage.verifySubMenuGuiDenToiIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='057-eSR-HBCONS-2024']"), "057-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='055-eSR-HBCONS-2024']"), "055-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='053-eSR-HBCONS-2024']"), "053-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='138-eSR-COT-2024']"), "138-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='059-eSR-HBCONS-2024']"), "059-eSR-HBCONS-2024");
    }

    @Test(priority = 5)
    void TC_022() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Đề xuất"" và chọn mục con ""Tôi gửi đi""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        Assert.assertTrue(eSaleReportPage.verifySubMenuToiGuiDiIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='160-eSR-COT-2024']"), "160-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='148-eSR-COT-2024']"), "148-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='034-eSR-COT-2024']"), "034-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='033-eSR-COT-2024']"), "033-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='032-eSR-COT-2024']"), "032-eSR-COT-2024");
    }

    @Test(priority = 6)
    void TC_023() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Đề xuất"" và chọn mục con ""Chia sẻ đến tôi""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        Assert.assertTrue(eSaleReportPage.verifySubMenuChiaSeDenToiIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='138-eSR-COT-2024']"), "138-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='111-eSR-COT-2024']"), "111-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='007-eSR-HBCONS-2024']"), "007-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='034-eSR-COT-2024']"), "034-eSR-COT-2024");
    }

    @Test(priority = 7)
    void TC24() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Trạng thái"" và chọn mục con ""Nháp""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.clickMenuTrangThai();
        Assert.assertTrue(eSaleReportPage.verifySubMenuNhapIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='160-eSR-COT-2024']"), "160-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='030-eSR-COT-2024']"), "030-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='004-eSR-HBCONS-2024']"), "004-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='005-eSR--2024']"), "005-eSR--2024");
    }

    @Test(priority = 8)
    void TC25() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Trạng thái"" và chọn mục con ""Đang chờ duyệt""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.clickMenuTrangThai();
        Assert.assertTrue(eSaleReportPage.verifySubMenuDangChoDuyetpIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='056-eSR-HBCONS-2024']"), "056-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='161-eSR-COT-2024']"), "161-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='063-eSR-HBCONS-2024']"), "063-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='009-eSR--2024']"), "009-eSR--2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='159-eSR-COT-2024']"), "159-eSR-COT-2024");
    }

    @Test(priority = 9)
    void TC26() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Trạng thái"" và chọn mục con ""Đã từ chối""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.clickMenuTrangThai();
        Assert.assertTrue(eSaleReportPage.verifySubMenuDaTuChoiIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='145-eSR-COT-2024']"), "145-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='140-eSR-COT-2024']"), "140-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='007-eSR--2024']"), "007-eSR--2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='114-eSR-COT-2024']"), "114-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='098-eSR-COT-2024']"), "098-eSR-COT-2024");
    }

    @Test(priority = 10)
    void TC27() {
        /*
        1. Vào trang web ""https://tasken.io/""
        2. Nhấn nút ""Login"" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút ""Đăng nhập"" để chuyển đến trang chủ
        6. Chọn moudule ""eSaleReport"" để chuyển đến trang danh sách đề nghị
        7. Chọn menu ""Trạng thái"" và chọn mục con ""Đã Ký""
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.clickMenuTrangThai();
        Assert.assertTrue(eSaleReportPage.verifySubMenuDaKyIsSelected());
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='153-eSR-COT-2024']"), "153-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='151-eSR-COT-2024']"), "151-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='008-eSR--2024']"), "008-eSR--2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='148-eSR-COT-2024']"), "148-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='139-eSR-COT-2024']"), "139-eSR-COT-2024");
    }
}

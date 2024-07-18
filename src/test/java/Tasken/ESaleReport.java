package Tasken;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ESaleReportPage;
import supports.testData;

public class ESaleReport extends TestBase {
    ESaleReportPage eSaleReportPage = new ESaleReportPage();


    @Test(dataProvider = "filteredExcelData", priority = 1)
    void TC_039(testData data) {
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

        // 5. Xác nhận đăng nhập thành công bằng cách kiểm tra tên trên header
        Assert.assertEquals(eSaleReportPage.verifyLoginSuccessfully(), "OPUS SOLUTION COMPANY");
    }


    @Test(dataProvider = "filteredExcelData", priority = 2)
    void TC_018(testData data) {

        // 1. Vào trang web "https://tasken.io/"
        eSaleReportPage.open();

        // 2. Nhấn nút "Login"
        eSaleReportPage.clickLoginButton();

        // 3. Nhập tên đăng nhập không hợp lệ và nhấn nút tiếp theo
        eSaleReportPage.fillUsername(data.getUsername());

        // Hiển thị thông báo lỗi "We couldn't find an account with that username. Try another, or get a new Microsoft account."
        Assert.assertEquals(eSaleReportPage.verifyLoginFailWithInvalidUsername(),
                "We couldn't find an account with that username. Try another, or get a new Microsoft account.");
    }

    @Test(priority = 2)
    void TC_019() {

        // 1. Vào trang web "https://tasken.io/"
        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042a");
        eSaleReportPage.clickNextButton();

        // Xác nhận đăng nhập thất bại với mật khẩu không hợp lệ
        Assert.assertEquals(eSaleReportPage.verifyLoginFailWithInvalidPassword(),
                "Your account or password is incorrect. If you don't remember your password, reset it now.");
    }

    @Test(priority = 3)
    void TC_020(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='160-eSR-COT-2024']"),"160-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='063-eSR-HBCONS-2024']"),"063-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='159-eSR-COT-2024']"),"159-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='155-eSR-COT-2024']"),"155-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='151-eSR-COT-2024']"),"151-eSR-COT-2024");

    }

    @Test(priority = 4)
    void TC_021(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='057-eSR-HBCONS-2024']"),"057-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='055-eSR-HBCONS-2024']"),"055-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='053-eSR-HBCONS-2024']"),"053-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='138-eSR-COT-2024']"),"138-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='059-eSR-HBCONS-2024']"),"059-eSR-HBCONS-2024");
    }

    @Test(priority = 5)
    void TC_022(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='160-eSR-COT-2024']"),"160-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='148-eSR-COT-2024']"),"148-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='034-eSR-COT-2024']"),"034-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='033-eSR-COT-2024']"),"033-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='032-eSR-COT-2024']"),"032-eSR-COT-2024");
    }

    @Test(priority = 6)
    void TC_023(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='138-eSR-COT-2024']"),"138-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='111-eSR-COT-2024']"),"111-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='007-eSR-HBCONS-2024']"),"007-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='034-eSR-COT-2024']"),"034-eSR-COT-2024");
    }

    @Test(priority = 7)
    void TC24(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='160-eSR-COT-2024']"),"160-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='030-eSR-COT-2024']"),"030-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='004-eSR-HBCONS-2024']"),"004-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='005-eSR--2024']"),"005-eSR--2024");
    }

    @Test(priority = 8)
    void TC25(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='056-eSR-HBCONS-2024']"),"056-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='161-eSR-COT-2024']"),"161-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='063-eSR-HBCONS-2024']"),"063-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='009-eSR--2024']"),"009-eSR--2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='159-eSR-COT-2024']"),"159-eSR-COT-2024");
    }
    @Test(priority = 9)
    void TC26(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='145-eSR-COT-2024']"),"145-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='140-eSR-COT-2024']"),"140-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='007-eSR--2024']"),"007-eSR--2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='114-eSR-COT-2024']"),"114-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='098-eSR-COT-2024']"),"098-eSR-COT-2024");
    }

    @Test(priority = 10)
    void TC27(){
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
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='153-eSR-COT-2024']"),"153-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='151-eSR-COT-2024']"),"151-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='008-eSR--2024']"),"008-eSR--2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='148-eSR-COT-2024']"),"148-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='139-eSR-COT-2024']"),"139-eSR-COT-2024");
    }
    @Test(priority = 11)
    void TC28(){
        /*
        1. Vào trang web "https://tasken.io/"
        2. Nhấn nút "Login" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút "Đăng nhập" để chuyển đến trang chủ
        6. Chọn moudule "eSaleReport" để chuyển đến trang danh sách đề nghị
        7. Nhấn chuột vào nút "Lọc"
        8. Nhập các dữ liệu hợp lệ
        9. Nhấn nút "Apply"
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.fillLocWithAllValidData();
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//span[contains(.,'058-eSR-HBCONS-2024')]"),"058-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//span[contains(.,'Đang chờ duyệt')]"),"Đang chờ duyệt");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='applicantName']", "value"),"Uyen Nguyen Ngoc Bao");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='departmentId']", "value"),"Landmark 81 Project");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='sectionId']", "value"),"HoaBinh Cons");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='wareHouse']", "value"),"HẢI PHÒNG 3");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='unitId']", "value"),"Sub HoaBinh Cons");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='requestDate']", "value"),"13/06/2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='moduleCategoryId']", "value"),"Sale Reports");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='requestDate']", "value"),"13/06/2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='dateOfReport']", "value"),"13/06/2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='datePrintReport']", "value"), "13/06/2024");


    }

    @Test(priority = 12)
    void TC29(){
        /*
        1. Vào trang web "https://tasken.io/"
        2. Nhấn nút "Login" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút "Đăng nhập" để chuyển đến trang chủ
        6. Chọn moudule "eSaleReport" để chuyển đến trang danh sách đề nghị
        7. Nhấn chuột vào nút "Lọc"
        8. Nhập mã đề nghị "156-eSR-COT-2024"
        9. Nhấn nút "Apply"
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.fillLocFunctionWithMaDeNghi("058-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//a[.='058-eSR-HBCONS-2024']"), "058-eSR-HBCONS-2024");
    }

    @Test(priority = 13)
    void TC30(){
        /*
        1. Vào trang web "https://tasken.io/"
        2. Nhấn nút "Login" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút "Đăng nhập" để chuyển đến trang chủ
        6. Chọn moudule "eSaleReport" để chuyển đến trang danh sách đề nghị
        7. Nhấn chuột vào nút "Lọc"
        8. Chọn phòng ban "Landmark 81 project"
        9. Nhấn nút "Apply"
         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.fillLocFunctionWithMaDeNghi("065-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//span[contains(.,'065-eSR-HBCONS-2024')]"), "065-eSR-HBCONS-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='departmentId']", "value"),"Landmark 81 Project");

    }

    @Test(priority = 14)
    void TC31(){
        /*
        1. Vào trang web "https://tasken.io/"
        2. Nhấn nút "Login" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút "Đăng nhập" để chuyển đến trang chủ
        6. Chọn moudule "eSaleReport" để chuyển đến trang danh sách đề nghị
        7. Nhấn chuột vào nút "Lọc"
        8.1 Chọn phòng ban "Landmark 81 project"
        8.2 Chọn bộ phận "Cotectons"
        9. Nhấn nút "Apply"

         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.fillLocFunctionWithPhongBan("161-eSR-COT-2024","");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//span[contains(.,'161-eSR-COT-2024')]"), "161-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='departmentId']", "value"),"Landmark 81 Project");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='sectionId']", "value"),"CotecCons");
    }

    @Test(priority = 15)
    void TC32(){
        /*
        1. Vào trang web "https://tasken.io/"
        2. Nhấn nút "Login" ở trang chủ để chuyển đến trang đăng nhập
        3. Nhập tên đăng nhập: vuonglt@o365.vn
        4. Nhập mật khẩu: 0944155042aA
        5. Nhấn nút "Đăng nhập" để chuyển đến trang chủ
        6. Chọn moudule "eSaleReport" để chuyển đến trang danh sách đề nghị
        7. Nhấn chuột vào nút "Lọc"
        8.1 Chọn "Ngày (của) báo cáo": 2023-05-30 - 2023-05-30
        8.2 Chọn "Ngày tạo": 2023-05-30 -2023-05-30
        9. Nhấn nút "Apply"

         */

        eSaleReportPage.open();
        eSaleReportPage.clickLoginButton();
        eSaleReportPage.fillUsername("vuonglt@o365.vn");
        eSaleReportPage.fillPassword("0944155042aA");
        eSaleReportPage.clickNextButton();
        eSaleReportPage.clickYesButton();
        eSaleReportPage.clickModuleEsaleReport();
        eSaleReportPage.clickLoginButtonBackUp();
        eSaleReportPage.fillLocFunctionWithMaDeNghi("161-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayed("//span[contains(.,'161-eSR-COT-2024')]"), "161-eSR-COT-2024");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='departmentId']", "value"),"Landmark 81 Project");
        Assert.assertEquals(eSaleReportPage.isMessageDisplayedWithAttrribute("//input[@id='sectionId']", "value"),"CotecCons");
    }









}


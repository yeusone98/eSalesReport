package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

import static supports.Browser.*;

public class ESaleReportPage {

    By apllicantCreateElement = By.id("paymentForm_applicantName");
    By deptElement = By.id("paymentForm_departmentId");
    By sectionElement = By.id("paymentForm_sectionId");
    By depotElement = By.id("paymentForm_wareHouse");
    By unitElement = By.id("paymentForm_unitId");
    By reqDateElement = By.id("paymentForm_requestDate");
    By reportTypeElement = By.id("paymentForm_moduleCategoryId");
    By reportDateElement = By.id("paymentForm_dateOfReport");
    By reportPrintDateElement = By.id("paymentForm_datePrintReport");

    By noteElement = By.id("paymentForm_note");

    By pathOfReportForSignatureElement = By.xpath("//div[9]/div[1]//button[@class='ant-btn css-kghr11 ant-btn-default']");
    By reportForSignatureTextElement = By.cssSelector(".ant-upload-list-item-name");
    By referenceDocsElement = By.xpath("//div[@class='container-fluid']/div[@class='ant-row css-kghr11']/div[2]//input[1]");
    By employee_2_Element = By.xpath("//div[@class='container-fluid']/div[@class='ant-form-item css-kghr11']//div[2]//input[@class='ant-select-selection-search-input']");
    By salesSupportElement = By.xpath("//div[10]//div[3]//input[@class='ant-select-selection-search-input']");
    By managerElement = By.xpath("//div[10]//div[4]//input[@class='ant-select-selection-search-input']");

    By notiCreateSuccessTextElement = By.cssSelector((".ant-notification-notice-description"));
    By returnButton = By.xpath("//li[.='Trở về']");
    By filterButton = By.xpath("//button[.='Lọc']");
    By applyFilterButton = By.cssSelector(".ant-btn-primary");
    By reqCodeFilter = By.id("requestCode");


    public void open(){
        visit("https://tasken.io/");
    }



    public void clickChangeLanguage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'US')]")));
        click(By.xpath("//span[contains(.,'US')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/div/div/div/div")));
        click(By.xpath("//div[2]/div/div/div/div/div"));
    }


    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-if='!vm.vars.isAbout']")));
        click(By.cssSelector("[ng-if='!vm.vars.isAbout']"));
    }

    public void fillUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
        fill(By.name("loginfmt"),username);
        click(By.cssSelector(".button_primary"));
    }
    public void fillPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
        fill((By.name("passwd")), password);
    }
    public void clickNextButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button_primary")));
        click(By.cssSelector(".button_primary"));
    }
    public void clickYesButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button_primary")));
        click(By.cssSelector(".button_primary"));
    }


    public String verifyLoginSuccessfully(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-if='vm.vars.header.name']")));
        return getText(By.cssSelector("[ng-if='vm.vars.header.name']"));
    }

    public String verifyLoginFailWithInvalidUsername(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameError")));
        return getText(By.id("usernameError"));
    }

    public String verifyLoginFailWithInvalidPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordError")));
        return getText(By.id("passwordError"));
    }



    public void clickModuleEsaleReport(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='https://app.tasken.io/avn/salereports']")));
        click(By.cssSelector("[href='https://app.tasken.io/avn/salereports']"));
    }

    public void clickChangeLanguageUStoVietNamese(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='US']")));
        click(By.xpath("//span[.='US']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='VN']")));
        click(By.xpath("//span[.='VN']"));
    }

    public void clickLoginButtonBackUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn css-kghr11 ant-btn-primary']/span[.='Login']")));
        click(By.xpath("//button[@class='ant-btn css-kghr11 ant-btn-primary']/span[.='Login']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Home']")));
        click(By.xpath("//a[.='Home']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='https://app.tasken.io/avn/salereports']")));
        click(By.cssSelector("[href='https://app.tasken.io/avn/salereports']"));
    }

//    public void verifyTextsOfElements(List<String> xpaths, List<String> expectedTexts) {
//        List<String> actualTexts = getTextsFromXpaths(xpaths);
//        if (!actualTexts.equals(expectedTexts)) {
//            throw new AssertionError("The texts of the elements do not match the expected values.");
//        }
//    }

    public String isMessageDisplayed(String messageType){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messageType)));

        return getText(By.xpath(messageType));
    }
    public String isMessageDisplayedWithAttrribute(String messageType, String attribute){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messageType)));

        return getLocator(By.xpath(messageType)).getAttribute(attribute);
    }



    public String isColorDisplayed(String color){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(color)));
        return getColor(By.cssSelector(color));
    }

    public boolean verifySubMenuTatCaDeXuatIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ant-menu-item ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By.xpath("//li[@class='ant-menu-item ant-menu-item-selected ant-menu-item-only-child']"));
    }


    public boolean verifySubMenuGuiDenToiIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Gửi đến tôi']")));
        click(By.xpath("//li[.='Gửi đến tôi']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By
                .xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']"));
    }

    public boolean verifySubMenuToiGuiDiIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Tôi gửi đi']")));
        click(By.xpath("//li[.='Tôi gửi đi']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']"));
    }

    public boolean verifySubMenuChiaSeDenToiIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Chia sẻ với tôi']")));
        click(By.xpath("//li[.='Chia sẻ với tôi']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']"));
    }


    public void clickMenuTrangThai(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Trạng thái']")));
        click(By.xpath("//div[.='Trạng thái']"));
    }


    public boolean verifySubMenuDangChoDuyetpIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Đang chờ duyệt']")));
        click(By.xpath("//span[.='Đang chờ duyệt']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']"));
    }

    public boolean verifySubMenuNhapIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Nháp']")));
        click(By.xpath("//li[.='Nháp']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']"));
    }

    public boolean verifySubMenuDaTuChoiIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Đã từ chối']")));
        click(By.xpath("//li[.='Đã từ chối']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']"));
    }

    public boolean verifySubMenuDaKyIsSelected(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Đã ký']")));
        click(By.xpath("//li[.='Đã ký']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']")));
        return isSelectedForCSS(By.xpath("//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']"));
    }

    public void fillDept(String department){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deptElement));
        fill(deptElement, department);
        enter(deptElement);
    }

    public void fillSection(String section){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionElement));
        fill(sectionElement, section);
        enter(sectionElement);
    }

    public void fillUnit(String unit){
        wait.until(ExpectedConditions.visibilityOfElementLocated(unitElement));
        fill(unitElement, unit);
        enter(unitElement);
    }

    public void fillDateOfReport(String dateOfreport){
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportDateElement));
        deleteText(reportDateElement);
        fill(reportDateElement, dateOfreport);
        enter(reportDateElement);

    }

    public void fillreportPrintingDate(String reportPrintingDate){
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportPrintDateElement));
        deleteText(reportPrintDateElement);
        fill(reportPrintDateElement, reportPrintingDate);
        enter(reportPrintDateElement);
    }

    public void clickReasonForPrintReportOnDiffDate(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox' and @value='Cập nhật lại Bằng THTM&DTBH']")));
        click(By.xpath("//input[@type='checkbox' and @value='Cập nhật lại Bằng THTM&DTBH']"));
    }

    public void importReportSubmitted(String pathReportSubmitted) throws AWTException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(pathOfReportForSignatureElement));
        click(pathOfReportForSignatureElement);
        uploadFileWithRobot(pathReportSubmitted);
    }

    public void selectEmployee2(String employee2){
        wait.until(ExpectedConditions.visibilityOfElementLocated(employee_2_Element));
        fill(employee_2_Element, employee2);
        enter(employee_2_Element);
    }

    public void selectSaleSupport(String salesSupport){
        wait.until(ExpectedConditions.visibilityOfElementLocated(salesSupportElement));
        fill(salesSupportElement, salesSupport);
        enter(salesSupportElement);
    }

    public void selectManager(String manager){
        wait.until(ExpectedConditions.visibilityOfElementLocated(managerElement));
        fill(managerElement, manager);
        enter(managerElement);
    }

    public void clickSent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Gửi']")));
        click(By.xpath("//li[.='Gửi']"));
    }

    public String verifynotiCreateSuccess(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(notiCreateSuccessTextElement));
        return getText(notiCreateSuccessTextElement);
    }


    public void clickCreateReq(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Tạo mới']")));
        click(By.xpath("//button[.='Tạo mới']"));
    }

    public void reqCodeWasCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-notification-notice-close")));
        click(By.cssSelector(".ant-notification-notice-close"));
        String reqCode;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container-fluid .ant-row > div:nth-of-type(1) > span")));
        reqCode = getText(By.cssSelector(".container-fluid .ant-row > div:nth-of-type(1) > span"));
        System.out.println(reqCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(returnButton));
        click(returnButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterButton));
        click(filterButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(reqCodeFilter));
        fill(reqCodeFilter, reqCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyFilterButton));
        click(applyFilterButton);
        String dynamicXPath = String.format("//td[.='%s']", reqCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
        click(By.xpath(dynamicXPath));
        System.out.println(reqCode);
    }


}

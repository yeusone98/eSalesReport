package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static supports.Browser.*;

public class ESaleReportPage {




    public void open(){
        visit("https://tasken.io/");
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


    public void fillLocWithAllValidData(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Lọc']")));
        click(By.xpath("//span[.='Lọc']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("requestCode")));
        fill(By.id("requestCode"),"058-eSR-HBCONS-2024");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departmentId")));
        click(By.id("departmentId"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Dự án Tasken']")));
        scroll(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Marketing']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Landmark 81 Project']")));
        click(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Landmark 81 Project']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sectionId")));
        click(By.id("sectionId"));
        fill(By.id("sectionId"),"HoaBinh Cons");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unitId")));
        click(By.id("unitId"));
        fill(By.id("unitId"),"Sub HoaBinh Cons");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("createdBy")));
        fill(By.id("createdBy"),"Uyen Nguyen Ngoc Bao");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processingBy")));
        fill(By.id("processingBy"),"Vuong Luc Tan");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("createdBy")));
        fill(By.id("status"),"Đang chờ duyệt");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDateOfReport")));
        clearInput(By.id("fromDateOfReport"));
        fill(By.id("fromDateOfReport"),"2024-06-13");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDateOfReport")));
        clearInput(By.id("toDateOfReport"));
        fill(By.id("toDateOfReport"),"2024-06-13");
        click(By.xpath("//span[.='Apply']"));
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='058-eSR-HBCONS-2024']"))));
        click(By.xpath("//a[.='058-eSR-HBCONS-2024']"));
    }

    public void fillLocFunctionWithMaDeNghi(String madenghi){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Lọc']")));
        click(By.xpath("//span[.='Lọc']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("requestCode")));
        fill(By.id("requestCode"),madenghi);
        click(By.xpath("//span[.='Apply']"));
        click(By.xpath(String.format("//a[.='%s']", madenghi)));
    }

    public void fillLocFunctionWithPhongBan(String madenghi, String phongban){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Lọc']")));
        click(By.xpath("//span[.='Lọc']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departmentId")));
        click(By.id("departmentId"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Dự án Tasken']")));
        scroll(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Marketing']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Landmark 81 Project']")));
        click(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[.='Landmark 81 Project']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sectionId")));
        click(By.id("sectionId"));
        fill(By.id("sectionId"),phongban);
        click(By.xpath("//span[.='Apply']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//a[.='%s']", madenghi))));
        click(By.xpath(String.format("//a[.='%s']", madenghi)));
    }

}

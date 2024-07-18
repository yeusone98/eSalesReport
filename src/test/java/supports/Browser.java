package supports;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.monte.media.AudioFormatKeys.EncodingKey;
import static org.monte.media.AudioFormatKeys.FrameRateKey;
import static org.monte.media.AudioFormatKeys.KeyFrameIntervalKey;
import static org.monte.media.AudioFormatKeys.MIME_QUICKTIME;
import static org.monte.media.AudioFormatKeys.MediaType;
import static org.monte.media.AudioFormatKeys.MediaTypeKey;
import static org.monte.media.AudioFormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.*;

public class Browser {

    private static WebDriver driver;
    private static ScreenRecorder screenRecorder;
    public static int MAX_TIME_OUT_SECONDS = 30;
    public static WebDriverWait wait;
    public static Actions actions;


    public static void launchBrowser(String name) {
        switch (name) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized"); // Mở Chrome ở chế độ toàn màn hình
                driver = new ChromeDriver(options);
                break;
            }
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--kiosk"); // Mở Firefox ở chế độ toàn màn hình
                driver = new FirefoxDriver(options);
                break;
            }
            case "edge": {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized"); // Mở Edge ở chế độ toàn màn hình
                driver = new EdgeDriver(options);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME_OUT_SECONDS));
        actions = new Actions(driver);
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    public static void fill(By locator, CharSequence... KeytoSend) {
        driver.findElement(locator).sendKeys(KeytoSend);
    }

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }


    public static WebElement getLocator(By locator){
        return driver.findElement(locator);
    }


    public static void check(By locator) {
        if (!driver.findElement(locator).isSelected()) {
            click(locator);
        }
    }

    public static void unCheck(By locator) {
        if (driver.findElement(locator).isSelected()) {
            click(locator);
        }
    }

    public static boolean isSelectedForCSS(By locator) {
        WebElement element = driver.findElement(locator);
        String classAttribute = element.getAttribute("class");
        return classAttribute.contains("ant-menu-item-selected") && classAttribute.contains("ant-menu-item-only-child");
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public static void TakeScreenShot(String name) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String strDate = formatter.format(date);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("target/image-tasken-result/screenshot-%s-%s.png", name, strDate));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void startRecording(String testName) throws IOException, AWTException {
        File file = new File("target/video-tasken-result/");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle captureSize = new Rectangle(screenSize);

        screenRecorder = new ScreenRecorder(
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(),
                captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_QUICKTIME_JPEG,
                        CompressorNameKey, ENCODING_QUICKTIME_JPEG, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 0.5f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file);
        screenRecorder.start();
    }

    public static void stopRecording() {
        try {
            if (screenRecorder != null) {
                screenRecorder.stop();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static List<String> getTextsFromXpaths(List<String> xpaths) {
        return xpaths.stream()
                .map(xpath -> driver.findElement(By.xpath(xpath)).getText())
                .collect(Collectors.toList());
    }

    public static void selectDropdown (By locator, String name){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(name);
    }

    public static void clearInput(By locator){
        driver.findElement(locator).clear();
    }

    public static void scroll(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    public static String getColor(By locator){
        return driver.findElement(locator).getCssValue("background-color");
    }
}

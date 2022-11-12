package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;


public class Reusable_Actions_loggers {
    static int timeout = 12;
    //reusable method to define and launch web driver
    public static WebDriver setUpDriver() {
        //define the web driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        options.addArguments("start-maximized");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        //options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element: " + elementName + " for reason: " + e);}
             getScreenShot(driver, elementName, logger);

    }
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element: " + elementName + "for reason: " + e);
        }
    }//end of submit action


    public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element: " + elementName + "for reason: " + e);

        }
    }

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hovered to " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to hover to element: " + elementName + " for reason: " + e);

        }
    }

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully send a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to send keys to : " + elementName + " for reason: " + e);

        }
    }

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully get a text  on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to get text for : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }
    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText

    public static void switchToTabByIndex(WebDriver driver, int index,ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
            logger.log(LogStatus.PASS, "Successfully switched to on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch tabs : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to switch tabs : " + elementName + " for reason: " + e);
        }
    }
    public static void selectByTextAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userInput);
            logger.log(LogStatus.PASS, "Successfully selected a text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select text : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to select text : " + elementName + " for reason: " + e);
        }
    }
    public static void scrollByView (WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            JavascriptExecutor jse= (JavascriptExecutor)driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully scrolled on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to scroll to : " + elementName + " for reason: " + e);
        }

    }
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

}// end of java class


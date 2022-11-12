package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Command {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        options.addArguments("start-maximized");
        //define the web driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        // go to Ml calc page
        driver.navigate().to("https://www.mlcalc.com");
        // wait few seconds
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()= 'Show advanced options']")).click();
        Thread.sleep(2000);
        // usr select command for month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name= 'sm']"));
        Select startMonthDropDown = new Select(startMonth);
        startMonthDropDown. selectByVisibleText("11");

        //WebElement startYear = driver.findElement(By.xpath("//*[@name= 'sy']"));
        //Select startYearDropDown = new Select(startYear);
        //startYearDropDown. selectByVisibleText("2023");
        driver.findElement(By.xpath("//*[@name='sy']")).click();
        driver.findElement(By.xpath("//*[text()='2023']")).click();


    }// end of main
}// end of java class

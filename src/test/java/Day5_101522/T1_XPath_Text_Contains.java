package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XPath_Text_Contains {
    public static void main(String[] args) throws InterruptedException {
        // define the web driver manager setup for chromeDriver
        WebDriverManager.chromedriver().setup();
        //define the chromeDriver for web testing
        WebDriver driver = new ChromeDriver();
        // go to yahoo page
        driver.navigate().to("https://www.yahoo.com");
        //maximize the driver
        driver.manage().window().maximize();
        //click on sign button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();
        //sleep statement
        Thread.sleep(2000);
        // go to yahoo page
        driver.navigate().to("https://www.yahoo.com");
        //sleep statement
        Thread.sleep(2000);
        // click on the bell icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();
        // wait 2 seconds
        Thread.sleep(2000);
        //quit driver
        driver.quit();


    }// end of main
}// end of java class

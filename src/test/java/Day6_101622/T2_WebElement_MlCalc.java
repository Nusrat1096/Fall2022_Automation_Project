package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_MlCalc {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //define the web driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        // go to Ml calc page
        driver.navigate().to("https://www.mlcalc.com");
        //wait few seconds
        Thread.sleep(3000);
        // clear and enter a new value on purchase price
        WebElement purchasePrice = driver.findElement(By.xpath("//*[@name= 'ma']"));
        //clear the purchase price
        purchasePrice.clear();
        // type new value on the purchase price
        purchasePrice.sendKeys("450000");
        // clear and enter a new value on purchase price
        WebElement downPayment = driver.findElement(By.xpath("//*[@name= 'dp']"));
        //clear the purchase price
        downPayment.clear();
        // type new value on the purchase price
        downPayment.sendKeys("25");


    }// end of main
}//end of java class

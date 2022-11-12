package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_Find_Elements {
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
        // go to google page
        driver.navigate().to("https://www.yahoo.com");
        // wait few seconds
        Thread.sleep(3000);
        // using find elements I want to click on second link within the group which is news
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();


    }// end of main
}// end of java class

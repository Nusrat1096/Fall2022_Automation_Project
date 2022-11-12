package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_Chrome_Options {
    public static void main(String[] args) {
        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        options.addArguments("start-maximized","incognito");
          //options.addArguments("headless");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //define the web driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
       // go to google page
        driver.navigate().to("https://www.google.com");

    }// end of main
}// end of java class

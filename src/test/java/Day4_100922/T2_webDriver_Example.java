package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_webDriver_Example {
    public static void main(String[] args) throws InterruptedException {
        // define the webDriver manager set up for chromedriver
        WebDriverManager. chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to the google site
        driver.navigate().to("https://www.google.com");
        //wait few seconds
        Thread.sleep(4000);
        //quit the chrome session
        driver.quit();


    }// end of main
}// end of java class

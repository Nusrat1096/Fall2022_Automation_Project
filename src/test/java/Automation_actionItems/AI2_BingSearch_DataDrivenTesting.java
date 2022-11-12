package Automation_actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class AI2_BingSearch_DataDrivenTesting {
    public static void main(String[] args) throws InterruptedException {
        //arrayList for sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Soccer");
        sports.add("Football");
        sports.add("Cricket");
        sports.add("Tennis");
        // define the web driver manager setup for chromeDriver
        WebDriverManager.chromedriver().setup();
        //define the chromeDriver for web testing
        WebDriver driver = new ChromeDriver();
        for(int i=0; i< sports.size();i++) {
            //navigate to the google site
            driver.navigate().to("https://www.bing.com");

            //maximize my window
            driver.manage().window().maximize();
            //sleep statement
            Thread.sleep(3000);

            //search sports on search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));
            // submit on the bing search button
            driver.findElement(By.xpath("//*[@name= 'search']")).submit();

            //sleep statement
            Thread.sleep(3000);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("the search number is for " + sports.get(i) + " is " + splitResult[0]);

        }//end of for loop

        //quit the driver to end the session
        driver.quit();

    }// end of main
}// end of java class

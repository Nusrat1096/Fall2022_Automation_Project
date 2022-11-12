package Automation_actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI3_weightWatchers_webTesting {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        options.addArguments ("incognito","start-maximized");
        // define the web driver and pass on the options to the method
        WebDriver driver = new ChromeDriver(options);
        //create arraylist for zipcode
        ArrayList<String> zipCode;
        // defining arraylist for zipcode
        zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10010");
        zipCode.add("11375");

        // for loop
        for (int i=0; i< zipCode.size(); i++) {
            // go to weight watchers page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
            // wait few seconds
            Thread.sleep(2000);
            //click on find a workshop icon
            driver.findElement(By.xpath("//*[@icon='location']")).click();
            // click on in person icon
            driver.findElement(By.xpath("//*[contains(@class,'buttonText')]")).click();
            // wait few seconds
            Thread.sleep(2000);
            //declaring web element to search zipcode
            WebElement zipCodeSearch = driver.findElement(By.xpath("//*[@id='location-search']"));
            // clear zipcode
            zipCodeSearch.clear();
            // type new zipcode on the search field
            zipCodeSearch.sendKeys(zipCode.get(i));
            //declaring web element to search zip code
            driver.findElement(By.xpath("//*[@id= 'location-search-cta']")).click();

            // wait few seconds
            Thread.sleep(2000);
            //scrolling down to get the studio link
            //jse.executeScript("scroll(0 ,700)");
            //wait few seconds
            Thread.sleep(2000);
            // declare web element arrayList for studio link
            ArrayList<WebElement> studioLink = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'linkUnderline')]")));
            // creating if condition to find the studio links
            if (i==0){
                // jse.executeScript("scroll 0,990");
                studioLink.get(1).click();
            }
            else if (i==1) {
                //jse.executeScript("scroll 0,1300");
                studioLink.get(2).click();

            }
            else if( i==2){
                studioLink.get(3).click();
            }// end of if condition
            // wait few seconds
            Thread.sleep(2000);
            //string variable for street address
            String streetAddress = driver.findElement(By.xpath("//*[contains(@class,'infoContainer-12kv1')]")).getText();
            //print statement for street address
            System.out.println(streetAddress);
            JavascriptExecutor view= (JavascriptExecutor) driver;
            // wait few seconds
            Thread.sleep(2000);


            WebElement scrollView = driver.findElement(By.xpath("//*[@id= 'studioWorkshopSchedule']"));
            view.executeScript("arguments[0].scrollInView(true);", scrollView);
            String captureSchedule = driver.findElement(By.xpath("//*[@id= 'studioWorkshopSchedule']")).getText();
            //print statement for in-person studio workshop schedule
            System.out.println(captureSchedule);
        }// end of for loop

    }//end of main
}// end of class

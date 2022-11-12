package Automation_actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;

public class AI2_Practice_YahooSearch {
    public static void main(String[] args) throws InterruptedException {
        // arrayList for movies
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Hocus Pocus 2");
        movies.add("Kingdom of Heaven");
        movies.add("Purple hearts");
        // define the web driver manager setup for edge driver
        WebDriverManager.edgedriver().setup();
        // define the edge driver for web testing
        WebDriver driver = new EdgeDriver();
        // for loop for movies
        for (int i= 0; i< movies.size(); i++){
            // navigate to yahoo page
            driver.navigate().to("https://www.yahoo.com");
            // maximize my window
            driver.manage().window().maximize();
            // wait for 3 seconds
            Thread.sleep(3000);
            // search movies on search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name= 'p']")).sendKeys(movies.get(i));
            // submit on the yahoo submit button
            driver.findElement(By.xpath("//*[@id ='ybar-search']")).submit();
            // wait for 3 seconds
            Thread.sleep(3000);
            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@class= 'title mb-0']")).getText();
            String[] splitResult = result.split(" ");
            System.out.println("The search number for " + movies.get(i) + " is " + splitResult[1]);



        }// end of loop
        // quit driver
        driver.quit();

    }// end of main
}//end of class

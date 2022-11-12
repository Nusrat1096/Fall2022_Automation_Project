package Automation_actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class AI4_Hotels_dataDrivenTesting {
    public static void main(String[] args) throws InterruptedException {
        //setting up Chrome web driver
        WebDriverManager.chromedriver().setup();
        // setting up Chrome options
        ChromeOptions options = new ChromeOptions();
        //pass on arguments to maximize the screen
        options.addArguments("start-maximized","incognito");
        //create new chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);

        //create array list of states
        ArrayList<String> states = new ArrayList<>();
        states.add("Pennsylvania");
        states.add("Nebraska");
        states.add("New Jersey");
        //array list of adults
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);
        //array list of child age
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("1");
        childAge.add("1");
        childAge.add("2");


        for (int i = 0; i < states.size(); i++) {
            //navigate to hotels website
            driver.navigate().to("https://hotels.com");
            //wait few seconds
            Thread.sleep(2000);
            try {
                // click on destinations search box
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
                //enter states name
                driver.findElement(By.xpath("//*[@id ='destination_form_field']")).sendKeys(states.get(i));
                //selecting the states
                //driver.findElement(By.xpath("//*[@id ='destination_form_field']")).sendKeys(Keys.ENTER);
                //ArrayList
                ArrayList<WebElement> destinations = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='destination_form_field-result-item-button']")));
                destinations.get(0).click();
            } catch (Exception e) {
                System.out.println("Destination error" + e);
            }//end of try catch
            //wait one second
            Thread.sleep(1000);

            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
                Thread.sleep(2000);
                //setting adult size to 1
                ArrayList<WebElement> minusButton = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));
                minusButton.get(0).click();
                //wait few seconds
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("Traveler error" + e);
            }//end of try catch

            for (int j = 1; j < adults.get(i); j++) {
                //clicking on plus sign button
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']")).click();
                // wait few seconds
                Thread.sleep(2000);
            }// end of nested loop
            try {
                //increasing child count to 1
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
                //starting select command for child age
                WebElement age = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                // wait few seconds
                Thread.sleep(1000);
                Select dropDownChildAge = new Select(age);
                dropDownChildAge.selectByVisibleText(childAge.get(i));
                // wait few seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Children Age Error" + e);
            }// end of try catch
            try {
                // clicking on done button
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
                //clicking on search button
                driver.findElement(By.xpath("//*[@id= 'submit_button']")).click();
                // wait few seconds
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Submission error" + e);

            }// end of try catch
            // declaring web element for hotel link
            ArrayList<WebElement> hotelLink = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'uitk-card-link']")));
            //creating if condition to click on the hotels links
            if (i==0){
                hotelLink.get(1).click();
                Thread.sleep(3000);
            } else if(i==1) {
                hotelLink.get(3).click();
                Thread.sleep(3000);
            } else if (i==2) {
                hotelLink.get(2).click();
                Thread.sleep(3000);
            }// end of if condition
            // arrayList for tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(i+1));
            Thread.sleep(2000);
            //string variable for resort name
            String resortName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
            System.out.println(resortName);
            Thread.sleep(2000);
            try {
                //clicking on reserve now
                driver.findElement(By.xpath("//*[@data-stid='sticky-button']")).click();
                //capture the first price from dropdown
                String HotelPrice = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                //Print the price
                System.out.println(HotelPrice);
                //Click on Reserve Button
                Thread.sleep(2000);
                driver.findElements(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-primary']")).get(0).click();
                Thread.sleep(2000);
                //check in check out time
                String checkInOutTime= driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText();
                System.out.println(checkInOutTime);
            }catch(Exception e){
                System.out.println("Reserve Button Does not Exist! " + e);
                // close current tab
                driver.close();
            }//End of try catch
            driver.switchTo().window(tabs.get(0));
            // wait few seconds
            Thread.sleep(2000);

        }//end of main for loop
        driver.quit();

    }// end of main
}// end of class

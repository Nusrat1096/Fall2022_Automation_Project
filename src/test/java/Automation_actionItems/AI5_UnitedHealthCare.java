package Automation_actionItems;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class AI5_UnitedHealthCare {

    String zipcode = "11210";
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

   @AfterSuite
    public void quitTheSession() {
       driver.quit();
   }//end of after suite

    @Test()
    public void FindADoctor() throws InterruptedException {
        driver.navigate().to("https://www.uhc.com");
        // click on find a doctor
        Reusable_Actions.clickActionByIndex(driver,"//*[text()= 'Find a doctor']",0,"Find a Doctor");
        Thread.sleep(5000);
        //scroll down to find a dentist
        Reusable_Actions.scrollByView(driver,"//*[text()= 'Find mental health providers']","Scroll to Find Mental Health Providers");
        //click on find a dentist
        Reusable_Actions.clickAction(driver,"//*[text()='Find a dentist']","Find a Dentist Link");
        Thread.sleep(3000);
        // switch to new tab
        Reusable_Actions.switchToTabByIndex(driver,1,"Switch to Second Tab");
        Thread.sleep(2000);
        //click on employer and individual plans
        Reusable_Actions.clickActionByIndex(driver,"//*[@class='gs-option']",0,"Employer and Individual Plans");
        Thread.sleep(2000);
    }// end of test case 1

    @Test(dependsOnMethods = "FindADoctor")
    public void FindGeneralDentist() throws InterruptedException {
        // enter zip code on the search field
        Reusable_Actions.sendKeysAction(driver,"//*[@id='location']",zipcode,"Zip Code Input");
        // click on the first zip code
        Reusable_Actions.submitAction(driver,"//*[@id= 'auto_0']","Select zip code");
        Thread.sleep(2000);
        // click on continue
        Reusable_Actions.clickAction(driver,"//*[@type= 'submit']","Continue Button");
        Thread.sleep(1000);
        // click on National options PPO 30
        Reusable_Actions.clickActionByIndex(driver,"//*[@class='sc-jomqko TEkcT']",0,"PPO");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        // click on general dentist
        Reusable_Actions.clickActionByIndex(driver,"//*[@class='sc-jgPyTC gXqeMb']",0,"General Dentist Link");
        Thread.sleep(2000);
    }// end of test case 2
    @Test(dependsOnMethods = "FindGeneralDentist")
    public void GeneralDentistSelection () throws InterruptedException {
        //selecting a mile from the dropdown
        Reusable_Actions.selectByTextAction(driver,"//*[contains(@class,'radiusMiles ng-pristine')]","Within 20 miles","Miles dropdown");
        //refresh
        driver.navigate().refresh();
        //wait few seconds
        Thread.sleep(3000);
        //clicking on first doctor link
        Reusable_Actions.clickActionByIndex(driver,"//*[@data-test-id= 'provider-name-link']",0,"First dentist link");
        //clicking on save button
        Reusable_Actions.clickAction(driver,"//*[contains(@class,'cta-header-button action-btn saved')]","Save button");
        // declaring string variables for address, miles and network status
        String addressValue = Reusable_Actions.getTextAction(driver,"//*[@class ='td c-4-dt-tbl']","Doctor Address");
        String milesValue = Reusable_Actions.getTextAction(driver,"  //*[@class='block mapLink']","Miles");
        String networkValue = Reusable_Actions.getTextAction(driver,"//*[@class='networkStatus td c-4-dt-tbl']","Network Status");
        // print statement
        System.out.println("Address: " + addressValue +   " Miles: " + milesValue +  " Network: " + networkValue);
        // wait few seconds
        Thread.sleep(2000);
        // close the tab
        driver.close();
    }// end of test case 3
    @Test(dependsOnMethods = "GeneralDentistSelection")
    public void DoctorSearch() {
        //switch back to the first tab
        Reusable_Actions.switchToTabByIndex(driver,0,"Switch to tab 0");
        //typing doctors on the search box
        Reusable_Actions.sendKeysAction(driver,"//*[@id='search-desktop']","doctor","Searching doctor");
        //click enter
        Reusable_Actions.clickAction(driver,"//*[@id='search__button-desktop']","Enter doctor");
        //capturing search results
        String searchResults= Reusable_Actions.getTextAction(driver,"//*[@id='search-results-count__header']","Search results");
        String [] split = searchResults.split(" ");
        System.out.println("The search results for doctor is: " + split[0] + " " + split[1]  + split[2]);
    }// end of test case 4
}// end of class


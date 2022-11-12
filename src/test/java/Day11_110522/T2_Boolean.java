package Day11_110522;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method
    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite
    @Test(priority = 1)
    public void TC001_verifySignedInOptionIsChecked() {
        // first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com");
        //clicking on sign in button
        Reusable_Actions.clickAction(driver, "//*[@class= '_yb_1933e']","Sign in Button");
        //verify if sign in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }
    @Test(dependsOnMethods = "TC001_verifySignedInOptionIsChecked")
    public void TC002_verifySignedInOptionIsUnchecked (){
        //click on check box to uncheck it
        Reusable_Actions.clickAction(driver,"//*[@class = 'stay-signed-in checkbox-container']", "SignedInCheckBox");
        //verify if signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);

    }

}// end of class

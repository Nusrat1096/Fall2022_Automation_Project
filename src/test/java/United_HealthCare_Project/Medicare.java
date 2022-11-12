package United_HealthCare_Project;

import Reusable_Library.Reusable_Actions_loggers;
import Reusable_Library.Reusable_Annotations;
import org.testng.annotations.Test;

public class Medicare extends Reusable_Annotations {
    @Test(priority = 1)
    public void tc001_saveMedicareAdvantagePlan() throws InterruptedException {
        // navigate to the United Health Care website
        driver.navigate().to("https://www.uhc.com");
        // click on  Insurance plans
        Reusable_Actions_loggers.clickActionByIndex(driver, "//*[contains(@class,'nav-item-parent list-none')]", 0, logger, "Insurance Plans");
        // wait few seconds
        Thread.sleep(2000);
        //click on medicare
        Reusable_Actions_loggers.clickActionByIndex(driver, "//*[contains(@class, 'simple-list__link color-blueDigital')]", 0, logger, "Medicare Plans");
        // wait few seconds
        Thread.sleep(1000);
        // input zip code
        Reusable_Actions_loggers.sendKeysAction(driver, "//*[@name= 'zipcodemeded-0']", "11226", logger, "Input Zipcode");
        // click on see plan options
        Reusable_Actions_loggers.clickActionByIndex(driver, "//*[@type= 'submit']", 0, logger, "See Plan Options");
        // wait few seconds
        Thread.sleep(2000);
        // click on the Medicare Advantage plans
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class= 'tab-contents']",0,logger,"Medicare Advantage Plans");
        Thread.sleep(2000);
        // click on 2023 plans
        Reusable_Actions_loggers.clickAction(driver,"//*[@id='NextYearViewbutton']",logger,"2023 plans");
        // scroll down
        Reusable_Actions_loggers.scrollByView(driver,"//*[@id= 'planCard0ExtraHelpLink']",logger,"Scroll down");
        // save the plan
        Reusable_Actions_loggers.clickAction(driver,"//*[@id='savePlanH3307015000']",logger,"Save Button for insurance plan");
        Thread.sleep(3000);
        // click on my saved items
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='shoppingcart-widget-main-wrap']",logger,"My Saved Items");

        //Thread.sleep(2000);
    }// end of test case 1




    @Test(dependsOnMethods = "tc001_saveMedicareAdvantagePlan")
    public void tc002_estimateDrugPrice() throws InterruptedException {
        //Reusable_Actions_loggers.clickAction(driver,"//*[@class='shoppingcart-widget-main-wrap']",logger,"My Saved Items");
        // click on add a drug option
        Reusable_Actions_loggers.mouseHover(driver, "//*[@id='flyout-drug-button']",logger,"Add a drug option");
        //click on add drugs
        Reusable_Actions_loggers.clickAction(driver,"//*[@id='adddrug']",logger,"Add drugs");
        // input drug name in the search box
        Reusable_Actions_loggers.sendKeysAction(driver, "//*[@id='drugsearch']","Metformin hcl",logger, "Drug name");
        Reusable_Actions_loggers.clickAction(driver,"//*[@id='search']",logger,"Search button");
        Thread.sleep(2000);
        //select the metformin hcl from the list
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='uhc-link-button minlength p-0 mr-lg-20']",0,logger,"select medicine");
        //scroll down and click on add drug to the list
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='uhc-button uhc-button--block uhc-button--secondary']",logger,"Add drug to the list");
        Thread.sleep(2000);
        //click on review drug cost
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='uhc-button uhc-button--secondary mb-20 mb-lg-0 ng-star-inserted']",logger,"Review drug cost");
        //select 2022 plans
        Reusable_Actions_loggers.clickAction(driver,"//*[@id='View_2022_Plans']",logger,"View 2022 plans");
        Thread.sleep(2000);
        // click on view plan details
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='uhc-button uhc-button--block uhc-button--outlined uhc-button--secondary']",0,logger,"View Drug plan details");
        // save the plan
        Reusable_Actions_loggers.clickAction(driver,"//*[@id= 'pdSaveBanner']",logger,"Save Button to save drug plan");
        // click on view saved items
        Reusable_Actions_loggers.clickAction(driver,"//*[text()='View Saved Plans']",logger,"Saved items");

    }// end of test case 2
    @Test(dependsOnMethods = "tc002_estimateDrugPrice")
    public void tc003_getAPlanRecommendation() throws InterruptedException {
        //scroll down
        Reusable_Actions_loggers.scrollByView(driver,"//*[@class='uhc-button uhc-button--outlined uhc-button--secondary px-30']",logger,"Scroll Down");
        // click on get a plan recommendation
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='uhc-button uhc-button--outlined uhc-button--secondary px-30']",logger,"Plan recommendation link");
        //click on get started
        Reusable_Actions_loggers.clickAction(driver,"//*[@id='location-save-btn']",logger,"Get started button");
        //click on the third option
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='radio-label']",2,logger,"Type of coverage");
        // click on continue
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='rectangle buttonLabel button button-primary button-orange']",logger,"Continue button");
        //click on the first option
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='radio-label']",0,logger,"Cost Preferences");
        // click on continue
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='rectangle buttonLabel button button-primary button-orange']",logger,"Continue button");
        //click on the first option
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='radio-label']",0,logger,"Medicare Eligibility");
        // click on continue
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='rectangle buttonLabel button button-primary button-orange']",logger,"Continue button");
        Thread.sleep(2000);
        //click on the third option
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='radio-label']",0,logger,"Plan preferences");
        // click on continue
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='rectangle buttonLabel button button-primary button-orange']",logger,"Continue button");
        //click on the first option
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='radio-label']",1,logger,"Prescription drugs");
        // click on continue
        Reusable_Actions_loggers.clickAction(driver,"//*[@class='rectangle buttonLabel button button-primary button-orange']",logger,"Continue button");
        Thread.sleep(2000);
        //save the first plan
        Reusable_Actions_loggers.clickActionByIndex(driver,"//*[@class='rectangle buttonLabel button button-secondary ng-star-inserted']",0,logger,"save plan");



    }// end of test case 3
}// end of class

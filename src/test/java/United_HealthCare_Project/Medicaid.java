package United_HealthCare_Project;

import Reusable_Library.Reusable_Actions_loggers;
import Reusable_Library.Reusable_Annotations;
import org.testng.annotations.Test;

public class Medicaid extends Reusable_Annotations {
    @Test(priority = 1)
    public void tc001_findMedicaidPlans() throws InterruptedException {
        // navigate to the United Health Care website
        driver.navigate().to("https://www.uhc.com");
        // click on  Insurance plans
        Reusable_Actions_loggers.clickActionByIndex(driver, "//*[contains(@class,'nav-item-parent list-none')]", 0, logger, "Insurance Plans");
        // wait few seconds
        Thread.sleep(2000);
        //click on medicaid
        Reusable_Actions_loggers.clickActionByIndex(driver, "//*[contains(@class,'simple-list__link color-blueDigital')]", 1, logger, "Medicaid Plans");
        // wait few seconds
        Thread.sleep(1000);
        // click on help me find a plan
        Reusable_Actions_loggers.clickAction(driver,"//*[contains(@class,'component cta button-style__outline-blue cta--remove-icon cta--left aem-GridColumn-')]",logger,"find a plan");
        

    }// end of test case 1

}// end of class


package Day12_110622;

import Reusable_Library.Reusable_Actions_loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_GoogleSearch_Reusable_Annotations extends Reusable_Annotations{
    @Test
    public void searchForBmw(){
        driver.navigate().to("https://www.google.com");
        //search for bmw on the search field
        Reusable_Actions_loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //hit submit on Google  search button
        Reusable_Actions_loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBmw")
    public void captureSearchNumber(){
        //capture the search results text
        String results = Reusable_Actions_loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Results");
        String[] arrayResult = results.split(" ");
        //print back to html report by using log INFO
        logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResult[1]);
    }//end of test 2


}// end of class

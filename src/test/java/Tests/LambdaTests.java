package Tests;

import Base.BaseTest;
import Pages.HomePages;
import Pages.IntegrationPages;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LambdaTests extends BaseTest {

    @Test(timeOut = 20000)
    public void lambdaTestAdvance(){

        HomePages homepage = new HomePages(driver);
        IntegrationPages newPage = new IntegrationPages(driver);

        /**
         * Step: 1,2,3,4
         */

        homepage.visit();
        assertTrue(homepage.isLoaded().size() > 0);
        homepage.scrollToElement();
        String currentUrl = homepage.getCurrentUrl();
        homepage.openInNewTab();

        /**
         * Step: 5,6,7,8,9,10,11
         */

        newPage.printTabs();
        try {
            assertEquals(newPage.newUrl(), currentUrl);
        } catch (Exception e){
            throw new AssertionError();
        }

        newPage.scrollToElement();
        newPage.clickTestingWhiz();

        assertEquals(newPage.checkPageTitle(),"TestingWhiz Integration | LambdaTest");

        newPage.closeWinAndPrintCurrentNumber();

        /**
         * Step: 12,13,14
         */

        homepage.navigateTo();

        homepage.clickCommunity();

        assertEquals(homepage.currentUrl(), "https://community.lambdatest.com/");
        homepage.closeWin();
    }
}

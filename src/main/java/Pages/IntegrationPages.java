package Pages;

import Base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class IntegrationPages extends BasePages {
    ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());

    public IntegrationPages(RemoteWebDriver driver) {
        super(driver);
    }

    public void printTabs(){
        tabs = new ArrayList<>(driver.getWindowHandles());

        for (int i=0; i<tabs.size(); i++){
            System.out.println(tabs.get(i));
        }
    }

    public String newUrl(){
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.urlContains("www"));
        return driver.getCurrentUrl();
    }

    public void scrollToElement(){

        String codelessAutomationSelector = "#codeless_row > h2";
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(codelessAutomationSelector)));
    }

    public void clickTestingWhiz(){
        String testingWhiz_LearnMore = "//*[@id=\"codeless_row\"]/div/div[4]/a";
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(testingWhiz_LearnMore)));
        js.executeScript("arguments[0].click()", driver.findElement(By.xpath(testingWhiz_LearnMore)));
    }

    public String checkPageTitle(){
        return driver.getTitle();
    }

    public void closeWinAndPrintCurrentNumber(){

        driver.close();
        driver.switchTo().window(tabs.get(0));

        tabs = new ArrayList<> (driver.getWindowHandles());
        System.out.println(tabs.size());
    }
}

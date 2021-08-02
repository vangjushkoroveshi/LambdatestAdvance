package Pages;

import Base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePages extends BasePages {
    String element = "//div[@class='text-center mt-25']/a";

    public HomePages(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() {
        driver.get(baseUrl);
    }

    public List<WebElement> isLoaded(){

        String inputEmails = "//input[@name='email']";
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(inputEmails))));
    }

    public void scrollToElement(){
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(element)));
    }

    public String getCurrentUrl(){
        return driver.findElement(By.xpath(element)).getAttribute("href");
    }

    public void openInNewTab(){
        js.executeScript("window.open('"+getCurrentUrl()+"','_blank');");
    }

    public void navigateTo(){
        driver.get(blogs);
    }

    public void clickCommunity(){

        String communityPath = "menu-item-10121";
        Boolean sidedown = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("onesignal-slidedown-cancel-button")))).isDisplayed();

        if (sidedown == true){
            driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(communityPath)))).click();
    }

    public String currentUrl(){

        return driver.getCurrentUrl();

    }

    public void closeWin(){
        driver.close();
    }
}

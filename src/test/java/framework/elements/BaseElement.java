package framework.elements;

import framework.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseElement extends BaseEntity {

    By locator;
    private WebElement element;

    BaseElement() {}

    public abstract void click();

    public abstract String getText();

    public String getAttribute(String str){
        return element.getAttribute(str);
    }

    public void moveTo(){
        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
    }

    public boolean isDisplayed(){
        return element.isDisplayed();
    }

    static List<WebElement> findElements(String by) {
        return getDriver().findElements(By.xpath(by));

    }

    public WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    public static void waitExplicit(String locator){
        WebDriverWait wait = new WebDriverWait(driver, getTimeForLoadElement());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static void waitBeClickable(String locator){
        WebDriverWait myWaitVar = new WebDriverWait(driver,Long.parseLong(configFile.getConfigProperty("timeout")));
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void waitLoadingPage(){
        try {
            Thread.sleep(Long.parseLong(configFile.getConfigProperty("timeoutJs")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Long getTimeForLoadElement(){
        return Long.parseLong(configFile.getConfigProperty("timeout"));
    }
}

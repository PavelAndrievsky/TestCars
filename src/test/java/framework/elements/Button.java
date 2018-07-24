package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Button extends BaseElement {

    private WebElement button;
    private By locator;

    public Button() {
    }

    public Button(By by) {
        this.locator = by;
    }

    public Button(WebElement button) {
        this.button = button;

    }

    @Override
    public void click() {
        this.button = findElement(locator);
        Actions action = new Actions(getDriver());
        action.moveToElement(button).build().perform();
        button.click();
    }

    @Override
    public String getText() {
        return null;
    }

    public void submit(){
        this.button = findElement(locator);
        button.submit();
    }
}

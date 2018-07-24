package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ComboBox extends BaseElement {

    private By cmbDropDown;
    private WebElement cmbSelect;

    public ComboBox(By byDropDown) {
        this.cmbDropDown = byDropDown;
    }

    public ComboBox() {
        super();
    }

    @Override
    public String getText() {
        return cmbSelect.getText();
    }

    @Override
    public void click() {
        Actions action = new Actions(getDriver());
        action.moveToElement(cmbSelect).build().perform();
        cmbSelect.click();
        cmbSelect.click();
    }

    public WebElement findElement() {
        return super.findElement(cmbDropDown);
    }

}

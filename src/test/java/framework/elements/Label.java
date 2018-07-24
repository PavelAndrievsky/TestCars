package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Label extends BaseElement {

    private WebElement label;
    private By locator;

    public Label() {
    }

    public Label(By by) {
        this.locator = by;
        this.label = findElement(locator);
    }

    private Label(WebElement label) {
        this.label = label;
    }

    @Override
    public String getText() {
        return label.getText();
    }

    @Override
    public void click() {
        label.click();
    }

    public static List<Label> getConvertedElements(String by) {
        List<WebElement> webElementList = findElements(by);
        List<Label> labelList = new ArrayList<>();
        for (WebElement webEl : webElementList) {
            labelList.add(new Label(webEl));
        }
        return labelList;
    }

    public  static boolean isPresent(By by) {
        return getDriver().findElements(by).size()> 0;
    }
}

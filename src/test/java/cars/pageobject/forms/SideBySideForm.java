package cars.pageobject.forms;

import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideBySideForm extends BaseForm {

    private static final String BUTTON_LOCATOR = "//button[@class='done-button']";
    private Button btnDone = new Button(By.xpath(BUTTON_LOCATOR));

    public AddAnotherCarForm addAnotherCarForm = new AddAnotherCarForm();

    public SideBySideForm() {
        super(By.xpath("//span[@id='compare']"));
    }

    public void submitCharacteristics(){
        btnDone.click();
        WebDriverWait myWaitVar = new WebDriverWait(driver,Long.parseLong(configFile.getConfigProperty("timeout")));
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='icon-div']")));
    }
}

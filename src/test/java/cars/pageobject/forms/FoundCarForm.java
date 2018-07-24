package cars.pageobject.forms;

import cars.pageobject.menu.Menu;
import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;

public class FoundCarForm extends BaseForm {

    private static final String COMPARE = "//div[@class='mmy-hero__buttons']//a[@data-linkname='trim-compare']";

    public FoundCarForm() {
        super(By.xpath("//nav[@aria-label='Breadcrumb']//a[@data-linkname='bc-research']"));
    }

    public Menu menu = new Menu();
    private Button btnCompare = new Button(By.xpath(COMPARE));

    public void pressCompareBtn() {
        btnCompare.click();
    }
}

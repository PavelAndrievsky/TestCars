package cars.pageobject.forms;

import cars.entities.Car;
import framework.BaseForm;
import cars.functions.CommonFunctions;
import framework.elements.BaseElement;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ResearchForm extends BaseForm {

    private static final String LOCATOR = "//div[@class='hsw-%s']//select";
    private static final String SEARCH_LOCATOR = "//input[@data-linkname='Research']";
    private static final String SIDEBYSIDE = "//div[@id='ta-linkcards-container']//a[@data-linkname='compare-cars']";
    private Button btnSearch = new Button(By.xpath(SEARCH_LOCATOR));
    private Car car = new Car();

    public enum Characteristics {
        makes, models, years
    }

    public ResearchForm() {
        super(By.xpath("//section[@id='research-browseby']//h2[contains(text(),'Research Car Models')]"));
    }

    public Car clickRandomParameters() {
        for (Characteristics characteristic : Characteristics.values())
        {
            ComboBox cmbUniversal = new ComboBox(By.xpath(String.format(LOCATOR, characteristic.name())));
            Select select = new Select(cmbUniversal.findElement());
            List options = select.getOptions();
            int rand = CommonFunctions.generateRandDigit(options.size());
            select.selectByIndex(rand);
            car.setCharacteristic(select.getFirstSelectedOption().getText(), characteristic.name());
        }
        BaseElement.waitExplicit(SEARCH_LOCATOR);
        btnSearch.submit();
        return car;
    }

    public void pressSideBySide(){
        Label lblSideBySide = new Label(By.xpath(SIDEBYSIDE));
        lblSideBySide.click();
    }

}

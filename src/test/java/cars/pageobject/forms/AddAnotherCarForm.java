package cars.pageobject.forms;

import cars.entities.Car;
import framework.elements.ComboBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddAnotherCarForm {

    private static final String LOCATOR = "//select[@name='%sDropdown']";

    public enum Characteristics {
        make, model, year
    }

    AddAnotherCarForm() {}

    public void addCar(Car car) {
        for (Characteristics characteristic : Characteristics.values()) {
            ComboBox cmbCharacteristic = new ComboBox(By.xpath(String.format(LOCATOR, characteristic.name())));
            Select select = new Select(cmbCharacteristic.findElement());
            String value = car.getCharacteristic(characteristic.name());
            select.selectByVisibleText(value);
        }
    }

}

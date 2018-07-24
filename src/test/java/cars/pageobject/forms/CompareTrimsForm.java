package cars.pageobject.forms;

import cars.pageobject.menu.Menu;
import cars.entities.Car;
import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CompareTrimsForm extends BaseForm {

    private Label lblEngine = new Label(By.xpath("//div[@class='cell cell-bg grow-2']"));
    private Label lblTransmission = new Label(By.xpath("//div[@class='cell grow-2']"));
    private Button logo = new Button(By.xpath("/html/body/header/nav/a/img"));

    public Menu menu = new Menu();

    public CompareTrimsForm() {
        super(By.xpath("//a[@data-linkname='bc-find a car']"));
    }

    public Car saveCharacteristics() {
        Car car = new Car(lblEngine.getText(), lblTransmission.getText());
        return car;
    }

    public void clickToMain(){
        logo.click();
    }
}

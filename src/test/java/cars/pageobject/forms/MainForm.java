package cars.pageobject.forms;

import cars.pageobject.menu.Menu;
import framework.BaseForm;
import org.openqa.selenium.By;

public class MainForm extends BaseForm {

    public Menu menu = new Menu();

    public MainForm() {
        super(By.xpath("//img[@id='cars-com-logo']"));
    }

}

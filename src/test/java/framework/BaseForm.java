package framework;

import framework.elements.Label;
import org.openqa.selenium.By;

public class BaseForm extends BaseEntity {

    private By titleLocator;

    public BaseForm(By titleLocator) {
        this.titleLocator = titleLocator;
        assertIsOpen();
    }

    private void assertIsOpen() {
        assertTrue(Label.isPresent(titleLocator));
    }
}

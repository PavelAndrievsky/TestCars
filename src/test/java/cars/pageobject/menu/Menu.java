package cars.pageobject.menu;

import framework.elements.Label;
import org.openqa.selenium.By;

public class Menu {

    private static final String tabsLocator = "//header/nav/ul/li[a[contains(text(), '%s')]]";

    public enum MenuItem{
        SALE("Cars for Sale"),
        SELL("Sell Your Car"),
        SERVICE("Service & Repair"),
        RESEARCH("Research"),
        REVIEWS("Videos & Reviews");

        private String name;

        MenuItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Menu() {
    }

    public void navigateMenu(MenuItem concreteItem){
        new Label(By.xpath(String.format(tabsLocator,concreteItem.getName()))).click();
    }

}

package cars.steps;

import cars.pageobject.forms.*;
import cars.pageobject.menu.Menu;
import cars.entities.Car;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    public static List<Car> cars = new ArrayList<>();
    private MainForm mainForm;
    private ResearchForm researchForm;
    private FoundCarForm foundCarForm;
    private CompareCarsForm compareCarsForm;
    private CompareTrimsForm compareTrimsForm;
    private SideBySideForm sideBySideForm;
    private Car car;

    static SoftAssert softAssert = new SoftAssert();

    @Given("^Open http://www\\.cars\\.com$")
    public void openMainPage() {
        mainForm = new MainForm();
    }

    @When("^Select tab Research$")
    public void navigateMenu() {
        mainForm.menu.navigateMenu(Menu.MenuItem.RESEARCH);
    }

    @Then("^The Research page opens$")
    public void researchOpens(){
        researchForm = new ResearchForm();
    }

    @When("^Search for the car by random characteristics$")
    public void chooseRandomParameters() {
        car = researchForm.clickRandomParameters();
        cars.add(car);
    }

    @Then("^The FoundCar page opens$")
    public void foundCarOpens(){
        foundCarForm = new FoundCarForm();
    }

    @When("^Go to the tab Compare Trims$")
    public void pressCompareBtn() {
        for(int i=0; i < 3; i++) {
            try {
                foundCarForm.pressCompareBtn();
                break;
            } catch (Throwable e) {
                cars.remove(cars.size() - 1);
                foundCarForm.menu.navigateMenu(Menu.MenuItem.RESEARCH);
                chooseRandomParameters();
            }
        }
    }

    @Then("^The CompareTrims page opens$")
    public void compareTrimsOpens(){
        compareTrimsForm = new CompareTrimsForm();
    }

    @When("^Remember the characteristics of the car for the base trim$")
    public void rememberCharacteristics() {
        Car temp;
        temp = compareTrimsForm.saveCharacteristics();
        cars.get(Steps.cars.size()-1).setEngine(temp.getEngine());
        cars.get(Steps.cars.size()-1).setTransmission(temp.getTransmission());
    }

    @When("^Go to the main page$")
    public void navigateMainPage() {
        compareTrimsForm.clickToMain();
    }

    @When("^Back to the Research page$")
    public void backToResearch() {
        compareTrimsForm.menu.navigateMenu(Menu.MenuItem.RESEARCH);
    }

    @When("^Click on the Side-by-Side Comparisons section$")
    public void clickSideBySide(){
        researchForm = new ResearchForm();
        researchForm.pressSideBySide();
    }

    @Then("^The SideBySide page opens$")
    public void setSideBySideOpens(){
        sideBySideForm = new SideBySideForm();
    }

    @When("^Choose the model selected in steps 2-5$")
    public void chooseFirstModel(){
        sideBySideForm.addAnotherCarForm.addCar(cars.get(0));
        sideBySideForm.submitCharacteristics();
    }

    @Then("^The CompareCars page opens$")
    public void CompareCarsOpens(){
        compareCarsForm = new CompareCarsForm();
    }

    @When(("^Using Add another car, we add to the comparison the model obtained in step 7$"))
    public void addSecondCar(){
        compareCarsForm.clickToAddAnotherCar();
        compareCarsForm.addAnotherCarForm.addCar(cars.get(1));
        compareCarsForm.submitCharacteristics();
    }

    @Then("^Check the comparison page for 2 models$")
    public void compare() {
        for(int i = 0; i < cars.size(); i++) {
            softAssert.assertTrue(compareCarsForm.compareCars(cars.get(i), i));
        }
    }

}
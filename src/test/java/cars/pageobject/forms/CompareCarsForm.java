package cars.pageobject.forms;

import cars.entities.Car;
import framework.BaseForm;
import cars.functions.CommonFunctions;
import framework.elements.BaseElement;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompareCarsForm extends BaseForm {

    private static final String LABEL_ADD_CAR_LOCATOR = "//div[@id='icon-div']";
    private static final String BUTTON_LOCATOR = "//button[@class='modal-button']";
    private static final String Transmission = "//cars-compare-compare-info[@header='Transmission']//span[@ng-if='showItem%s']//p";
    private static final String Engine = "//cars-compare-compare-info[@header='Engine']//span[@ng-if='showItem%s']//p";
    private static final String nameCar = "//h4[@class='listing-name']";
    public AddAnotherCarForm addAnotherCarForm = new AddAnotherCarForm();
    private Label lblAddCar = new Label(By.xpath(LABEL_ADD_CAR_LOCATOR));
    private Button btnDone = new Button(By.xpath(BUTTON_LOCATOR));
    private CommonFunctions commonFunctions = new CommonFunctions();

    public CompareCarsForm() {
        super(By.xpath(LABEL_ADD_CAR_LOCATOR));
    }

    public void clickToAddAnotherCar() {
        lblAddCar.click();
        WebDriverWait myWaitVar = new WebDriverWait(driver,Long.parseLong(configFile.getConfigProperty("timeout")));
        myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath(LABEL_ADD_CAR_LOCATOR)));
    }

    public void submitCharacteristics(){
        btnDone.click();
    }

    private String getEngineOrTrans(Car car, String locatorEngineOrTrans, String EngineOrTrans){
        String engineOrTransRes = null;
        List<Label> listEngineOrTrans = Label.getConvertedElements(locatorEngineOrTrans);
        List<String> enginesOrTrans = commonFunctions.getListOfEnginesOrTrans(listEngineOrTrans);
        for (String engineOrTran : enginesOrTrans) {
            if (car.getEngineOrTrans(EngineOrTrans).equals(engineOrTran))
                engineOrTransRes = engineOrTran;
        }
        return engineOrTransRes;
    }

    private List<String> compareName(){
        List<Label> list = Label.getConvertedElements(nameCar);
        List<String> namesCars = commonFunctions.getListOfNames(list);
        return namesCars;
    }

    public boolean compareCars(Car car, int i){
        /*BaseElement.waitExplicit(LABEL_ADD_CAR_LOCATOR);
        WebDriverWait myWaitVar = new WebDriverWait(driver,Long.parseLong(configFile.getConfigProperty("timeout")));
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LABEL_ADD_CAR_LOCATOR)));*/
        BaseElement.waitLoadingPage();
        String nameOriginal = car.getYear() + " " + car.getMake() + " " + car.getModel();
        if(!compareName().get(i).equals(nameOriginal))
            return false;
        if(!getEngineOrTrans(car, String.format(Engine, i), "Engine").equals(car.getEngine()))
            return false;
        return getEngineOrTrans(car, String.format(Transmission, i), "Transmission").equals(car.getTransmission());
    }
}

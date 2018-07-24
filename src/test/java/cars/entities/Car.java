package cars.entities;

public class Car {

    private String make;
    private String model;
    private String year;
    private String engine;
    private String transmission;

    public Car() {}

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String engine, String transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setCharacteristic(String characteristic, String name)
    {
        switch (name) {
            case "makes":
                this.make = characteristic;
                break;
            case "models":
                this.model = characteristic;
                break;
            default:
                this.year = characteristic;
                break;
        }
    }

    public String getCharacteristic(String name)
    {
        String value;
        switch (name) {
            case "make":
                value = this.make;
                break;
            case "model":
                value = this.model;
                break;
            default:
                value = this.year;
                break;
        }
        return value;
    }

    public String getEngineOrTrans(String type) {
        if(type.equals("Engine"))
            return engine;
        return transmission;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

}

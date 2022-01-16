package projektpo.java;

public class Device extends LibraryOrganizationalUnit{
    private String manufacturer;
    private String model;

    public Device(String name, String manufacturer, String model){
        super(name, UnitType.DEVICE);
        this.setManufacturer(manufacturer);
        this.setModel(model);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

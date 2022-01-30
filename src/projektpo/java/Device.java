package projektpo.java;

import java.util.ArrayList;

public class Device extends LibraryOrganizationalUnit implements IOwner {
    private String manufacturer;
    private String model;
    private final ArrayList<Employee> usedBy;

    public Device(String name, String manufacturer, String model){
        super(name, UnitType.Urządzenie);
        this.usedBy = new ArrayList<>();
        this.setManufacturer(manufacturer);
        this.setModel(model);
    }

    public String arrayOfOwnedIDs(ArrayList<? extends LibraryOrganizationalUnit> arr) {
        int size = arr.size();
        if (size > 0) {
            String str = "";

            for (int i = 0; i < size - 1; i++) {
                str += String.valueOf(arr.get(i).getIndex());
                str += ", ";
            }
            str += String.valueOf(arr.get(size - 1).getIndex());
            return str;
        }else{
            return "";
        }
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

    public ArrayList<Employee> getUsedBy() {
        return usedBy;
    }
}

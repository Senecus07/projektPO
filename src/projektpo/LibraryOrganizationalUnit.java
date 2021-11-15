package projektpo;

public abstract class LibraryOrganizationalUnit {
    private static int currentFreeIndex = 0;
    @SuppressWarnings("FieldMayBeFinal")
    private int index;
    private String name;
    private UnitType unitType;

    public LibraryOrganizationalUnit(String name, UnitType unitType){
        this.setName(name);
        this.setUnitType(unitType);
        this.index = currentFreeIndex;
        currentFreeIndex++;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }
}

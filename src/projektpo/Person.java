package projektpo;

public abstract class Person extends LibraryOrganizationalUnit{
    private String lastName;

    public Person(String name, String lastName, UnitType unitType){
        super(name, unitType);
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package projektpo;

public abstract class Person extends LibraryOrganizationalUnit{
    private String lastName;

    public Person(String name, String lastName){
        super(name, UnitType.PERSON);
        this.setLastName(lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

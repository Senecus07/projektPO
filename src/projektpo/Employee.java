package projektpo;

public class Employee extends Person{
    private Position occupation;
    private int salary;

    public Employee(String name, String lastName, UnitType unitType, Position occupation, int salary){
        super(name, lastName, unitType);
        this.setOccupation(occupation);
        this.setSalary(salary);
    }

    public Position getOccupation() {
        return occupation;
    }

    public void setOccupation(Position occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

package projektpo.java;

public class Employee extends Person{
    private Position occupation;
    private int salary;

    public Employee(String name, String lastName, Position occupation, int salary){
        super(name, lastName);
        this.setOccupation(occupation);
        this.setSalary(salary);
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nImię: " + this.getName() + "\nNazwisko: " + this.getLastName() + "\nStanowisko: "
                + this.getOccupation() + "\nPensja: " + this.getSalary();

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

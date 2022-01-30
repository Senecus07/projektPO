package projektpo.java;

import projektpo.exceptions.NotBorrowedException;
import projektpo.exceptions.NotUsedException;

import java.util.ArrayList;

public class Employee extends Person{
    private SubType subType;
    private Position occupation;
    private int salary;
    private final ArrayList<Device> usedDevices;

    public Employee(String name, String lastName, Position occupation, int salary){
        super(name, lastName);
        this.usedDevices = new ArrayList<>();
        this.setSubType(SubType.Pracownik);
        this.setOccupation(occupation);
        this.setSalary(salary);
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nImię: " + this.getName() + "\nNazwisko: " + this.getLastName() + "\nStanowisko: "
                + this.getOccupation() + "\nPensja: " + this.getSalary() + "\nID używanych urządzeń: " + arrayOfOwnedIDs(getUsedDevices())
                + "\nID wypożyczonych książek: " + arrayOfOwnedIDs(getBorrowedBooks());

    }

    public void borrowBook(Resource book) throws NotBorrowedException {
        if (!book.isBorrowed()) {
            getBorrowedBooks().add(book);
            book.setBorrowed(true);
            book.setBorrowedBy(this);
        }else{
            throw new NotBorrowedException();
        }
    }

    public void addUsedDevice(Device device) throws NotUsedException {
        if (!usedDevices.contains(device)) {
            usedDevices.add(device);
            device.getUsedBy().add(this);
        }else{
            throw new NotUsedException();
        }
    }

    public void removeUsedDevice(Device device) throws NotUsedException {
        if (usedDevices.contains(device)){
            usedDevices.remove(device);
            device.getUsedBy().remove(this);
        }else{
            throw new NotUsedException();
        }
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

    public ArrayList<Device> getUsedDevices() {
        return usedDevices;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }
}

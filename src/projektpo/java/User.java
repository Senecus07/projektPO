package projektpo.java;

import projektpo.exceptions.NotBorrowedException;

import java.time.LocalDate;

public class User extends Person{
    private UserType userType;
    private final LocalDate registrationDate;
    private SubType subType;

    public User(String name, String lastName, UserType userType){
        super(name, lastName);
        this.subType = SubType.Użytkownik;
        this.setUserType(userType);
        registrationDate = LocalDate.now();
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nImię: " + this.getName() + "\nNazwisko: " + this.getLastName() + "\nTyp: "
                + this.getUserType() + "\nData rejestracji: " + this.getRegistrationDate()
                + "\nID wypożyczonych książek: " + arrayOfOwnedIDs(getBorrowedBooks());

    }

    public void borrowBook(Resource book) throws NotBorrowedException {
        if (!book.isBorrowed()){
            getBorrowedBooks().add(book);
            book.setBorrowed(true);
            book.setBorrowedBy(this);
            book.setBorrowedUntil(LocalDate.now().plusDays(90));
        }else{
            throw new NotBorrowedException();
        }
    }

    public void prolongation(Resource book) throws NotBorrowedException {
        if (getBorrowedBooks().contains(book)){
            book.setBorrowedUntil(book.getBorrowedUntil().plusDays(30));
        }else{
            throw new NotBorrowedException();
        }
    }

    public UserType getUserType() {
        return userType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }
}

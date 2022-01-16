package projektpo.java;

import java.time.LocalDate;

public class User extends Person{
    private UserType userType;
    private LocalDate registrationDate;

    public User(String name, String lastName, UserType userType){
        super(name, lastName);
        this.setUserType(userType);
        registrationDate = LocalDate.now();
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nImię: " + this.getName() + "\nNazwisko: " + this.getLastName() + "\nTyp: "
                + this.getUserType() + "\nData rejestracji: " + this.getRegistrationDate();

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
}

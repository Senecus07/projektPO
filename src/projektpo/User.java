package projektpo;

import java.time.LocalDate;

public class User extends Person{
    private UserType userType;
    private LocalDate registrationDate;

    public User(String name, String lastName, UnitType unitType, UserType userType){
        super(name, lastName, unitType);
        this.setUserType(userType);
        registrationDate = LocalDate.now();
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

package projektpo.java;

import java.time.LocalDate;

public abstract class Resource extends LibraryOrganizationalUnit{
    private int numOfPages;
    private boolean isBorrowed;
    private Person borrowedBy;
    private LocalDate borrowedUntil;

    public Resource(String name, int numOfPages){
        super(name, UnitType.Zasób);
        this.setBorrowed(false);
        this.setBorrowedBy(null);
        this.setBorrowedUntil(null);
        this.setNumOfPages(numOfPages);
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Person getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Person borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public LocalDate getBorrowedUntil() {
        return borrowedUntil;
    }

    public void setBorrowedUntil(LocalDate borrowedUntil) {
        this.borrowedUntil = borrowedUntil;
    }
}

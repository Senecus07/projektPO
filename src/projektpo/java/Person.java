package projektpo.java;

import projektpo.exceptions.NotBorrowedException;

import java.util.ArrayList;

public abstract class Person extends LibraryOrganizationalUnit implements IOwner {
    private String lastName;
    private final ArrayList<Resource> borrowedBooks;

    public Person(String name, String lastName){
        super(name, UnitType.Osoba);
        this.borrowedBooks = new ArrayList<>();
        this.setLastName(lastName);
    }

    public abstract void borrowBook(Resource book) throws NotBorrowedException;

    public void returnBook(Resource book) throws NotBorrowedException {
        if (borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.setBorrowed(false);
            book.setBorrowedBy(null);
            book.setBorrowedUntil(null);
        }else{
            throw new NotBorrowedException();
        }
    }

    public String arrayOfOwnedIDs(ArrayList<? extends LibraryOrganizationalUnit> arr) {
        int size = arr.size();
        if (size > 0) {
            String str = "";

            for (int i = 0; i < size - 1; i++) {
                str += String.valueOf(arr.get(i).getIndex());
                str += ", ";
            }
            str += String.valueOf(arr.get(size - 1).getIndex());
            return str;
        }else{
            return "";
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Resource> getBorrowedBooks() {
        return borrowedBooks;
    }
}

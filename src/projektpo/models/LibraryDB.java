package projektpo.models;

import projektpo.exceptions.NotBorrowedException;
import projektpo.exceptions.NotUsedException;
import projektpo.java.*;

import java.util.ArrayList;

public class LibraryDB {

    private final ArrayList<LibraryOrganizationalUnit> libraryDB;

    private static final LibraryDB instance = new LibraryDB();

    private LibraryDB(){
        libraryDB = new ArrayList<>();
    }

    public static LibraryDB getInstance(){
        return instance;
    }



    public LibraryOrganizationalUnit getObjectByID(int id) throws ArrayIndexOutOfBoundsException{

        LibraryOrganizationalUnit ob = null;

        for (LibraryOrganizationalUnit a : this.getLibraryDB()){
            if (a.getIndex() == id){
                ob = a;
            }
        }
        if (ob == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        return ob;
    }

    public ArrayList<LibraryOrganizationalUnit> searchByName(String str){
        ArrayList<LibraryOrganizationalUnit> findObjects = new ArrayList<>();

        for (LibraryOrganizationalUnit obj : this.getLibraryDB()){
            if (obj.getName().contains(str)){ findObjects.add(obj); }
        }

        return findObjects;
    }

    public ArrayList<LibraryOrganizationalUnit> filterByType(SubType type){
        ArrayList<LibraryOrganizationalUnit> filteredObjects = new ArrayList<>();

        switch (type){
            case Pracownik -> {
                for (LibraryOrganizationalUnit obj : this.getLibraryDB()){
                    if (obj instanceof Employee){ filteredObjects.add(obj); }
                }
            }
            case Użytkownik -> {
                for (LibraryOrganizationalUnit obj : this.getLibraryDB()){
                    if (obj instanceof User){ filteredObjects.add(obj); }
                }
            }
            case Komputer -> {
                for (LibraryOrganizationalUnit obj : this.getLibraryDB()){
                    if (obj instanceof Workstation){ filteredObjects.add(obj); }
                }
            }
            case Drukarka -> {
                for (LibraryOrganizationalUnit obj : this.getLibraryDB()){
                    if (obj instanceof Printer){ filteredObjects.add(obj); }
                }
            }
            case Książka -> {
                for (LibraryOrganizationalUnit obj : this.getLibraryDB()){
                    if (obj instanceof Book){ filteredObjects.add(obj); }
                }
            }
            case Czasopismo -> {
                for (LibraryOrganizationalUnit obj : this.getLibraryDB()){
                    if (obj instanceof Magazine){ filteredObjects.add(obj); }
                }
            }
            case Wszystkie -> { return this.getLibraryDB(); }
            }

            return filteredObjects;
        }

        public void deleteObject(int id) throws IndexOutOfBoundsException, NotBorrowedException, NotUsedException {
            LibraryOrganizationalUnit ob = getObjectByID(id);

            if (ob instanceof Employee){
                int size = ((Employee)ob).getUsedDevices().size();
                for (int i = 0; i < size; i++){
                    ((Employee)ob).removeUsedDevice(((Employee) ob).getUsedDevices().get(0));
                }
                /*for (Device a : ((Employee) ob).getUsedDevices()){
                    ((Employee) ob).removeUsedDevice(a);
                }*/
                size = ((Employee)ob).getBorrowedBooks().size();
                for (int i = 0; i < size; i++){
                    ((Employee)ob).returnBook(((Employee) ob).getBorrowedBooks().get(0));
                }
               /* for (Resource a : ((Employee) ob).getBorrowedBooks()){
                    ((Employee) ob).returnBook(a);
                }*/
            }
            if (ob instanceof User){
                int size = ((User)ob).getBorrowedBooks().size();
                for (int i = 0; i < size; i++){
                    ((User)ob).returnBook(((User) ob).getBorrowedBooks().get(0));
                }
                /*for (Resource a : ((User) ob).getBorrowedBooks()){
                    ((User) ob).returnBook(a);
                }*/
            }
            if (ob instanceof Device){
                int size = ((Device)ob).getUsedBy().size();
                for (int i = 0; i < size; i++){
                    ((Device)ob).getUsedBy().get(0).removeUsedDevice((Device)ob);
                }
                /*for (Employee a : ((Device) ob).getUsedBy()){
                    a.removeUsedDevice((Device)ob);
                }*/
            }
            if (ob instanceof Resource){
                if (((Resource)ob).isBorrowed()) {
                    ((Resource) ob).getBorrowedBy().returnBook((Resource) ob);
                }
            }

            getLibraryDB().remove(ob);
        }

    public void addEmployee(String name, String lastName, Position position, int salary){
        libraryDB.add(new Employee(name, lastName, position, salary));
        System.out.println(getLibraryDB().get(libraryDB.size() - 1).toString());
    }

    public void addUser(String name, String lastName, UserType userType){
        libraryDB.add(new User(name, lastName, userType));
        System.out.println(getLibraryDB().get(libraryDB.size() - 1).toString());
    }

    public void addWorkstation(String name, String manufacturer, String model, ProcessorBrand processorBrand, GraphicCardBrand graphicCardBrand){
        libraryDB.add(new Workstation(name, manufacturer, model, processorBrand, graphicCardBrand));
        System.out.println(getLibraryDB().get(libraryDB.size() - 1).toString());
    }

    public void addPrinter(String name, String manufacturer, String model, PrinterType printerType, boolean integratedScanner){
        libraryDB.add(new Printer(name, manufacturer, model, printerType, integratedScanner));
        System.out.println(getLibraryDB().get(libraryDB.size() - 1).toString());
    }

    public void addBook(String name, int numOfPages, String author, BookGenre bookGenre){
        libraryDB.add(new Book(name, numOfPages, author, bookGenre));
        System.out.println(getLibraryDB().get(libraryDB.size() - 1).toString());
    }

    public void addMagazine(String name, int numOfPages, PeriodOfPublication periodOfPublication, MagazineCategory magazineCategory){
        libraryDB.add(new Magazine(name, numOfPages, periodOfPublication, magazineCategory));
        System.out.println(getLibraryDB().get(libraryDB.size() - 1).toString());
    }

    public ArrayList<LibraryOrganizationalUnit> getLibraryDB(){
        return libraryDB;
    }
}

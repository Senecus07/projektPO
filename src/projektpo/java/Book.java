package projektpo.java;

public class Book extends Resource{
    private SubType subType;
    private String author;
    private BookGenre genre;

    public Book(String name, int numOfPages, String author, BookGenre genre){
        super(name, numOfPages);
        this.setSubType(SubType.Książka);
        this.setAuthor(author);
        this.setGenre(genre);
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nNazwa: " + this.getName() + "\nAutor: " + this.getAuthor() + "\nGatunek: "
                + this.getGenre() + "\nLiczba stron: " + this.getNumOfPages()
                + "\nWypożyczone przez osobę o ID: " + ((getBorrowedBy() != null) ? getBorrowedBy().getIndex() : "brak") + "\nWypożyczone do:"
                 + ((getBorrowedUntil()  != null)? getBorrowedUntil() : "brak");

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }
}

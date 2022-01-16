package projektpo.java;

public class Book extends Resource{
    private String author;
    private String genre;

    public Book(String name, int numOfPages, String author, String genre){
        super(name, numOfPages);

        this.setAuthor(author);
        this.setGenre(genre);
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nNazwa: " + this.getName() + "\nAutor: " + this.getAuthor() + "\nGatunek: "
                + this.getGenre() + "\nLiczba stron: " + this.getNumOfPages();

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

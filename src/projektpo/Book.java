package projektpo;

public class Book extends Resource{
    private String author;
    private String genre;

    public Book(String name, int numOfPages, String author, String genre){
        super(name, numOfPages);

        this.setAuthor(author);
        this.setGenre(genre);
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

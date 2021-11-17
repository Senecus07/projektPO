package projektpo;

public class Resource extends LibraryOrganizationalUnit{
    private int numOfPages;

    public Resource(String name, int numOfPages){
        super(name, UnitType.RESOURCE);

        this.setNumOfPages(numOfPages);
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
}

package projektpo.java;

public class Magazine extends Resource{
    private PeriodOfPublication periodOfPublication;
    private String category;

    public Magazine(String name, int numOfPages, PeriodOfPublication periodOfPublication, String category){
        super(name, numOfPages);

        this.setPeriodOfPublication(periodOfPublication);
        this.setCategory(category);
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nNazwa: " + this.getName() + "\nKategoria: " + this.getCategory() + "\nInterwał publikacji: "
                + this.getNumOfPages() + "\nLiczba stron: " + this.getNumOfPages();

    }

    public PeriodOfPublication getPeriodOfPublication() {
        return periodOfPublication;
    }

    public void setPeriodOfPublication(PeriodOfPublication periodOfPublication) {
        this.periodOfPublication = periodOfPublication;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

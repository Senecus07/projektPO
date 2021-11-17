package projektpo;

public class Magazine extends Resource{
    private PeriodOfPublication periodOfPublication;
    private String category;

    public Magazine(String name, int numOfPages, PeriodOfPublication periodOfPublication, String category){
        super(name, numOfPages);

        this.setPeriodOfPublication(periodOfPublication);
        this.setCategory(category);
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

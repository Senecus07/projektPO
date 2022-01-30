package projektpo.java;

public class Magazine extends Resource{
    private SubType subType;
    private PeriodOfPublication periodOfPublication;
    private MagazineCategory category;

    public Magazine(String name, int numOfPages, PeriodOfPublication periodOfPublication, MagazineCategory category){
        super(name, numOfPages);
        this.setSubType(SubType.Czasopismo);
        this.setPeriodOfPublication(periodOfPublication);
        this.setCategory(category);
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nNazwa: " + this.getName() + "\nKategoria: " + this.getCategory() + "\nInterwał publikacji: "
                + this.getPeriodOfPublication() + "\nLiczba stron: " + this.getNumOfPages()
                + "\nWypożyczone przez osobę o ID: " + ((getBorrowedBy() != null) ? getBorrowedBy().getIndex() : " brak") + "\nWypożyczone do:"
                + ((getBorrowedUntil()  != null)? getBorrowedUntil() : " brak");

    }

    public PeriodOfPublication getPeriodOfPublication() {
        return periodOfPublication;
    }

    public void setPeriodOfPublication(PeriodOfPublication periodOfPublication) {
        this.periodOfPublication = periodOfPublication;
    }

    public MagazineCategory getCategory() {
        return category;
    }

    public void setCategory(MagazineCategory category) {
        this.category = category;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }
}

package projektpo.java;

public class Printer extends Device{
    private SubType subType;
    private PrinterType printerType;
    private boolean integratedScanner;

    public Printer(String name, String manufacturer, String model, PrinterType printerType, boolean integratedScanner){
        super(name, manufacturer, model);
        this.setSubType(SubType.Drukarka);
        this.setPrinterType(printerType);
        this.setIntegratedScanner(integratedScanner);
    }

    @Override
    public String toString(){
        return "ID: " + this.getIndex() +"\nNazwa: " + this.getName() + "\nProducent: " + this.getManufacturer() + "\nModel: "
                + this.getModel() + "\nTyp: " + this.getPrinterType() + "\nZintegrowany skaner: " + (this.hasIntegratedScanner()?"tak":"nie")
                + "\nUżywane przez pracowników o ID: " + arrayOfOwnedIDs((getUsedBy()));

    }



    public PrinterType getPrinterType() {
        return printerType;
    }

    public void setPrinterType(PrinterType printerType) {
        this.printerType = printerType;
    }

    public boolean hasIntegratedScanner() {
        return integratedScanner;
    }

    public void setIntegratedScanner(boolean integratedScanner) {
        this.integratedScanner = integratedScanner;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }
}

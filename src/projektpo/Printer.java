package projektpo;

public class Printer extends Device{
    private PrinterType printerType;
    private boolean integratedScanner;

    public Printer(String name, String manufacturer, String model, PrinterType printerType, boolean integratedScanner){
        super(name, manufacturer, model);
        this.setPrinterType(printerType);
        this.setIntegratedScanner(integratedScanner);
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
}

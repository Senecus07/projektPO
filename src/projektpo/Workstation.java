package projektpo;

public class Workstation extends Device{
    private ProcessorBrand processorBrand;
    private GraphicCardBrand graphicCardBrand;

    public Workstation(String name, String manufacturer, String model, ProcessorBrand processorBrand, GraphicCardBrand graphicCardBrand){
        super(name, manufacturer, model);
        this.setProcessorBrand(processorBrand);
        this.setGraphicCardBrand(graphicCardBrand);
    }

    public ProcessorBrand getProcessorBrand() {
        return processorBrand;
    }

    public void setProcessorBrand(ProcessorBrand processorBrand) {
        this.processorBrand = processorBrand;
    }

    public GraphicCardBrand getGraphicCardBrand() {
        return graphicCardBrand;
    }

    public void setGraphicCardBrand(GraphicCardBrand graphicCardBrand) {
        this.graphicCardBrand = graphicCardBrand;
    }
}

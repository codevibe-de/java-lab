package interfaces;

public class XmlExporter implements Exporter {

    @Override
    public String exportObject(Object o) {
        return "<object>";
    }

}

package packing.size;

public class MediumEnvelope implements PackageSize {

    @Override
    public String getDescription() {
        return "medium size envelope";
    }

    @Override
    public String getSize() {
        return "30cm x 40cm";
    }
}

package packing.size;

public class SmallEnvelope implements PackageSize {

    @Override
    public String getDescription() {
        return "small envelope";
    }

    @Override
    public String getSize() {
        return "10cm x 30cm";
    }
}

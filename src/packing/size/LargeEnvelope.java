package packing.size;

public class LargeEnvelope implements PackageSize {

    @Override
    public String getDescription() {
        return "large envelope";
    }

    @Override
    public String getSize() {
        return "45cm x 60cm";
    }
}

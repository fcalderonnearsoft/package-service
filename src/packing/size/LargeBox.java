package packing.size;

public class LargeBox implements PackageSize {

    @Override
    public String getDescription() {
        return "large size box";
    }

    @Override
    public String getSize() {
        return "up to 500 linear centimeters";
    }
}

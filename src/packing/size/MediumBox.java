package packing.size;

public class MediumBox implements PackageSize {

    @Override
    public String getDescription() {
        return "medium size box";
    }

    @Override
    public String getSize() {
        return "up to 300 linear centimeters";
    }
}

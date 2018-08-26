package packing.size;

public class SmallBox implements PackageSize {

    @Override
    public String getDescription() {
        return "small size box";
    }

    @Override
    public String getSize() {
        return "up to 100 linear centimeters";
    }
}

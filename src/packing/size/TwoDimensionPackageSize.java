package packing.size;

public abstract class TwoDimensionPackageSize implements PackageSize {

    @Override
    public final String getSize() {
        return " Width: " + getWidth() +
                ", Length: " + getLength();
    }

    public abstract String getLength();

    public abstract String getWidth();
}

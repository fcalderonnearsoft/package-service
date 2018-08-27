package packing.size;

public abstract class EnvelopeSize implements PackageSize {

    @Override
    public final String getSize() {
        return " Width: " + getWidth() +
                ", Length: " + getLength();
    }

    public abstract String getLength();

    public abstract String getWidth();
}

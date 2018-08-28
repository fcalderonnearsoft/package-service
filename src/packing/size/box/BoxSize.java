package packing.size.box;

import packing.size.PackageSize;

public abstract class BoxSize implements PackageSize {

    @Override
    public final String getSize() {
        return "Length: " + getLong() +
                ", Width: " + getWide() +
                ", Height: " + getHigh();
    }

    public abstract String getLong();

    public abstract String getWide();

    public abstract String getHigh();
}

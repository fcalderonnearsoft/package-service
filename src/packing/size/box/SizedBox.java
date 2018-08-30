package packing.size.box;

import packing.SizedPackageType;

public abstract class SizedBox implements SizedPackageType {

    @Override
    public final String getMeasurements() {
        return "Length: " + getLength() + ", Width: " + getWidth() + ", Height: " + getHeight();
    }

    public abstract String getLength();

    public abstract String getWidth();

    public abstract String getHeight();
}

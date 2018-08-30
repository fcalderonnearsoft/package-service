package packing.size.envelope;

import packing.SizedPackageType;

public abstract class SizedEnvelope implements SizedPackageType {

    @Override
    public final String getMeasurements() {
        return "Length: " + getLength() + ", Width: " + getWidth();
    }

    public abstract String getLength();

    public abstract String getWidth();
}

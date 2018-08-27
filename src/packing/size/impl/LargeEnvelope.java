package packing.size.impl;

import packing.size.TwoDimensionPackageSize;

public class LargeEnvelope extends TwoDimensionPackageSize {

    @Override
    public String getDescription() {
        return "large envelope";
    }

    @Override
    public String getLength() {
        return "60cm";
    }

    @Override
    public String getWidth() {
        return "45cm";
    }
}

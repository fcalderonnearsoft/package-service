package packing.size.impl;

import packing.size.TwoDimensionPackageSize;

public class MediumEnvelope extends TwoDimensionPackageSize {

    @Override
    public String getDescription() {
        return "medium size envelope";
    }

    @Override
    public String getLength() {
        return "40cm";
    }

    @Override
    public String getWidth() {
        return "30cm";
    }
}

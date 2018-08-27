package packing.size.impl;

import packing.size.TwoDimensionPackageSize;

public class SmallEnvelope extends TwoDimensionPackageSize {

    @Override
    public String getDescription() {
        return "small envelope";
    }

    @Override
    public String getLength() {
        return "30cm";
    }

    @Override
    public String getWidth() {
        return "10cm";
    }
}

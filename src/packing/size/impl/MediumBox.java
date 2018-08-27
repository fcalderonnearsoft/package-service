package packing.size.impl;

import packing.size.ThreeDimensionPackageSize;

public class MediumBox extends ThreeDimensionPackageSize {

    @Override
    public String getDescription() {
        return "medium size box";
    }

    @Override
    public String getLong() {
        return "100cm";
    }

    @Override
    public String getWide() {
        return "100cm";
    }

    @Override
    public String getHigh() {
        return "100cm";
    }
}

package packing.size.impl;

import packing.size.BoxSize;

public class SmallBox extends BoxSize {

    @Override
    public String getDescription() {
        return "small size box";
    }

    @Override
    public String getLong() {
        return "40cm";
    }

    @Override
    public String getWide() {
        return "30cm";
    }

    @Override
    public String getHigh() {
        return "30cm";
    }
}

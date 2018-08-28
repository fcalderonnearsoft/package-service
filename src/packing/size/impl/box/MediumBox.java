package packing.size.impl.box;

import packing.size.box.BoxSize;

public class MediumBox extends BoxSize {

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

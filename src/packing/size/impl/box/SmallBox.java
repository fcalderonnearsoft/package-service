package packing.size.impl.box;

import packing.size.box.SizedBox;

public class SmallBox implements SizedBox {

    public String getSize() {
        return "Small";
    }

    @Override
    public String getLength() {
        return "40cm";
    }

    @Override
    public String getWidth() {
        return "30cm";
    }

    @Override
    public String getHeight() {
        return "30cm";
    }
}
package packing.size.impl.box;

import packing.size.PackageSizeEnum;
import packing.size.PackageSizeFactory;
import packing.size.box.BoxSize;

public class BoxSizeFactory implements PackageSizeFactory {

    private static BoxSizeFactory uniqueInstance;

    private BoxSizeFactory() {
    }

    public static BoxSizeFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new BoxSizeFactory();
        }
        return uniqueInstance;
    }

    @Override
    public BoxSize create(PackageSizeEnum size) {
        BoxSize packageSize = null;

        switch (size) {
            case SMALL:
                packageSize = new SmallBox();
                break;
            case MEDIUM:
                packageSize = new MediumBox();
                break;
            case LARGE:
                packageSize = new LargeBox();
                break;
        }

        return packageSize;
    }
}


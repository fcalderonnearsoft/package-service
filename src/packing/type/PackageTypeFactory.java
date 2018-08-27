package packing.type;

import packing.type.impl.Box;
import packing.type.impl.Envelope;

public class PackageTypeFactory {

    public static PackageType create(PackageTypeEnum packageTypeEnum) {
        PackageType packageType = null;

        switch (packageTypeEnum) {
            case BOX:
                packageType = new Box();
                break;
            case ENVELOPE:
                packageType = new Envelope();
                break;
        }

        return packageType;
    }
}

package packing.type;

import packing.size.PackageSizeEnum;
import packing.type.impl.box.Box;
import packing.type.impl.envelope.Envelope;

public class PackageTypeFactory {

    public static PackageType create(PackageTypeEnum packageTypeEnum, PackageSizeEnum packageSizeEnum) {
        PackageType packageType = null;

        switch (packageTypeEnum) {
            case BOX:
                packageType = new Box(packageSizeEnum);
                break;
            case ENVELOPE:
                packageType = new Envelope(packageSizeEnum);
                break;
        }

        return packageType;
    }
}

package packing.type.impl.box;

import packing.size.PackageSizeEnum;
import packing.size.impl.box.BoxSizeFactory;
import packing.type.PackageType;

public class Box extends PackageType {

    public Box() {
        this(PackageSizeEnum.SMALL);
    }

    public Box(PackageSizeEnum packageSizeEnum) {
        name = "box";
        description = "multi-purpose box-type package";
        packageSizeFactory = BoxSizeFactory.getInstance();
        packageSize = packageSizeFactory.create(packageSizeEnum);
    }
}

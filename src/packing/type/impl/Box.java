package packing.type.impl;

import packing.size.PackageSizeEnum;
import packing.size.impl.BoxSizeFactory;
import packing.type.PackageType;

public class Box extends PackageType {

    public Box() {
        name = "box";
        description = "multi-purpose box-type package";
        packageSizeFactory = BoxSizeFactory.getInstance();
        packageSize = packageSizeFactory.create(PackageSizeEnum.SMALL);
    }
}

package packing.type.impl;

import packing.size.PackageSizeEnum;
import packing.size.impl.EnvelopeSizeFactory;
import packing.type.PackageType;

public class Envelope extends PackageType {

    public Envelope() {
        name = "envelope";
        description = "envelope-type package used for posting documents, photos and stuff like that";
        packageSizeFactory = EnvelopeSizeFactory.getInstance();
        packageSize = packageSizeFactory.create(PackageSizeEnum.SMALL);
    }
}

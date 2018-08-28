package packing.type.impl.envelope;

import packing.size.PackageSizeEnum;
import packing.size.impl.envelope.EnvelopeSizeFactory;
import packing.type.PackageType;

public class Envelope extends PackageType {

    public Envelope() {
        this(PackageSizeEnum.SMALL);
    }

    public Envelope(PackageSizeEnum packageSizeEnum) {
        name = "envelope";
        description = "envelope-type package used for posting documents, photos and stuff like that";
        packageSizeFactory = EnvelopeSizeFactory.getInstance();
        packageSize = packageSizeFactory.create(packageSizeEnum);
    }
}

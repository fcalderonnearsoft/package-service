package packing.type.impl;

import packing.type.PackageType;

public class Box implements PackageType {

    @Override
    public String getName() {
        return "Box";
    }

    @Override
    public String getDescription() {
        return "(Multi-purpose box-type package)";
    }
}

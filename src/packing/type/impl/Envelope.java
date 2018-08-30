package packing.type.impl;

import packing.type.PackageType;

public class Envelope implements PackageType {

    @Override
    public String getName() {
        return "Envelope";
    }

    @Override
    public String getDescription() {
        return "(For posting documents, photos and stuff like that)";
    }
}

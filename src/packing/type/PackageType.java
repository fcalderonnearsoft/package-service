package packing.type;

import packing.size.PackageSize;

public abstract class PackageType {

    String name;
    String description;
    PackageSize packageSize;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PackageSize getPackageSize() {
        return packageSize;
    }

    public void setSize(PackageSize packageSize) {
        this.packageSize = packageSize;
    }
}

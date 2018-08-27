package packing.type;

import packing.size.PackageSize;
import packing.size.PackageSizeEnum;
import packing.size.PackageSizeFactory;

public abstract class PackageType {

    protected String name;
    protected String description;
    protected PackageSize packageSize;
    protected PackageSizeFactory packageSizeFactory;

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

    public void setSize(PackageSizeEnum packageSizeEnum) {
        packageSize = packageSizeFactory.create(packageSizeEnum);
    }
}

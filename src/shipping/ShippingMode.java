package shipping;

import java.util.Random;

public abstract class ShippingMode {

    protected abstract String getMode();

    public final void ship() {
        printMode();
        receivePackageAtOrigin();
        labelPackage();
        generateFolio();
        transport();
        receivePackageAtDestination();
    }

    private void printMode() {
        System.out.println("- Mode: " + getMode());
    }

    private void receivePackageAtOrigin() {
        System.out.println("- Receiving package at the origin office");
    }

    private void labelPackage() {
        System.out.println("- Labeling package for shipping");
    }

    private void generateFolio() {
        System.out.println("- Folio number: " + new Random().nextInt(1000000));
    }

    protected abstract void transport();

    private void receivePackageAtDestination() {
        System.out.println("- Receiving package at destination office");
    }
}

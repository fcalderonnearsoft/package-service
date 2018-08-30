package shipment.mode.land;

import shipment.mode.Shipping;

public abstract class LandShipping implements Shipping {

    public static void printShippingStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
        System.out.println("- Receiving package at destination office");
    }
}

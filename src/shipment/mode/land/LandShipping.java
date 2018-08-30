package shipment.mode.land;

public abstract class LandShipping {

    public abstract String getMode();

    public abstract String getDeliveryTime();

    public static void printShippingStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
        System.out.println("- Receiving package at destination office");
    }
}

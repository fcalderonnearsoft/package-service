package shipment.mode.land;

import shipment.mode.Shipping;

public interface LandShipping extends Shipping {

    @Override
    default void printStages() {
        this.printInitialShippingStages();
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
        Shipping.printFinalShippingStages();
    }
}

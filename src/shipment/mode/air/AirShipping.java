package shipment.mode.air;

import shipment.mode.Shipping;

public interface AirShipping extends Shipping {

    @Override
    default void printStages() {
        Shipping.super.printInitialShippingStages();
        System.out.println("- Putting package in a plane");
        System.out.println("- Flying to destination");
        System.out.println("- Delivering to the destination office");
        Shipping.printFinalShippingStages();
    }
}

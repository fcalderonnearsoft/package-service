package shipment.mode.land;

import shipment.mode.Shipping;

public interface LandShipping extends Shipping {

    @Override
    default void printStages() {
        this.printInitialShippingStages();
        printer.print("- Putting package in a delivery truck");
        printer.print("- Driving to destination");
        printer.print("- Arriving to the destination office");
        Shipping.printFinalShippingStages();
    }
}

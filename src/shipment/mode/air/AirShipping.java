package shipment.mode.air;

import shipment.mode.Shipping;

public interface AirShipping extends Shipping {

    @Override
    default void printStages() {
        Shipping.super.printInitialShippingStages();
        printer.print("- Putting package in a plane");
        printer.print("- Flying to destination");
        printer.print("- Delivering to the destination office");
        Shipping.printFinalShippingStages();
    }
}

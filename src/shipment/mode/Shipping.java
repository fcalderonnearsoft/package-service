package shipment.mode;

import util.SingleStringPrinter;

public interface Shipping {

    String getMode();

    String getDeliveryTime();

    void printStages();

    SingleStringPrinter printer = System.out::println;

    default void printInitialShippingStages() {
        printer.print("- Receiving package at the origin office");
        printer.print("- Labeling package for shipping");
    }

    static void printFinalShippingStages() {
        System.out.println("- Receiving package at destination office");
    }
}

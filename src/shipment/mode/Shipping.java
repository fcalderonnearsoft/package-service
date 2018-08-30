package shipment.mode;

public interface Shipping {

    String getMode();

    String getDeliveryTime();

    void printStages();

    default void printInitialShippingStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
    }

    static void printFinalShippingStages() {
        System.out.println("- Receiving package at destination office");
    }
}

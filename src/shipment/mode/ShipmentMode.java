package shipment.mode;

import shipment.time.DeliveryTime;
import shipment.time.DeliveryTimeEnum;
import shipment.time.DeliveryTimeFactory;

import java.util.Random;

public abstract class ShipmentMode {

    private DeliveryTime deliveryTime;

    protected DeliveryTimeFactory deliveryTimeFactory;

    public void setDeliveryTime(DeliveryTimeEnum deliveryTimeEnum) {
        this.deliveryTime = deliveryTimeFactory.create(deliveryTimeEnum);
    }

    protected abstract String getMode();

    public final void ship() {
        printShipmentMode();
        printDeliveryTime();
        receivePackageAtOrigin();
        labelPackage();
        generateFolio();
        transport();
        receivePackageAtDestination();
    }

    private void printShipmentMode() {
        System.out.println("- Mode: " + getMode());
    }

    private void printDeliveryTime() {
        System.out.println("- Delivery time: " + deliveryTime.getTime() + "\n");
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

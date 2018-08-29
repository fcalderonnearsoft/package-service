package shipment.mode;

import shipment.time.DeliveryTime;
import shipment.time.DeliveryTimeEnum;
import shipment.time.DeliveryTimeFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public abstract class ShipmentMode {

    private DeliveryTime deliveryTime;

    protected DeliveryTimeFactory deliveryTimeFactory;

    protected Map<String, String> shipmentInformation;

    public ShipmentMode() {
        shipmentInformation = new LinkedHashMap<>();
    }

    public void setDeliveryTime(DeliveryTimeEnum deliveryTimeEnum) {
        this.deliveryTime = deliveryTimeFactory.create(deliveryTimeEnum);
    }

    protected abstract String getMode();

    public final Map<String, String> ship() {
        printShipmentMode();
        printDeliveryTime();
        receivePackageAtOrigin();
        labelPackage();
        generateFolio();
        transport();
        receivePackageAtDestination();
        return shipmentInformation;
    }

    private void printShipmentMode() {
        shipmentInformation.put("Mode", getMode());
    }

    private void printDeliveryTime() {
        shipmentInformation.put("Delivery time", deliveryTime.getTime() + "\n");
    }

    private void receivePackageAtOrigin() {
        shipmentInformation.put("Step " + (shipmentInformation.size() - 1), "Receiving package at the origin office");
    }

    private void labelPackage() {
        shipmentInformation.put("Step " + (shipmentInformation.size() - 1), "Labeling package for shipping");
    }

    private void generateFolio() {
        shipmentInformation.put("Step " + (shipmentInformation.size() - 1), "Folio number" + String.valueOf(new Random().nextInt(1000000)));
    }

    protected abstract void transport();

    private void receivePackageAtDestination() {
        shipmentInformation.put("Step " + (shipmentInformation.size() - 1), "Receiving package at destination office");
    }
}

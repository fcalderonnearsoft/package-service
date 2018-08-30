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

    private Map<String, String> shipmentInfo;

    private int deliveryStageCount;

    protected ShipmentMode() {
        shipmentInfo = new LinkedHashMap<>();
        deliveryStageCount = 1;
    }

    protected void setDeliveryTime(DeliveryTimeEnum deliveryTimeEnum) {
        this.deliveryTime = deliveryTimeFactory.create(deliveryTimeEnum);
    }

    protected abstract String getMode();

    public final Map<String, String> getShipmentInfo() {
        printShipmentMode();
        printDeliveryTime();
        generateFolio();
        receivePackageAtOrigin();
        labelPackage();
        transport();
        receivePackageAtDestination();

        return shipmentInfo;
    }

    private void printShipmentMode() {
        addShipmentInfo("Mode", getMode());
    }

    private void printDeliveryTime() {
        addShipmentInfo("Delivery time", deliveryTime.getTime());
    }

    private void generateFolio() {
        addShipmentInfo("Folio number", String.valueOf(new Random().nextInt(1000000)) + "\n");
    }

    private void receivePackageAtOrigin() {
        addShipmentInfo(deliveryStageCount, "Receiving package at the origin office");
    }

    private void labelPackage() {
        addShipmentInfo(deliveryStageCount, "Labeling package for shipping");
    }

    protected abstract void transport();

    private void receivePackageAtDestination() {
        addShipmentInfo(deliveryStageCount, "Receiving package at destination office");
    }

    protected void addShipmentInfo(int stageNumber, String value) {
        addShipmentInfo("Step " + stageNumber, value);
        deliveryStageCount++;
    }

    protected void addShipmentInfo(String key, String value) {
        shipmentInfo.put(key, value);
    }

    protected int getDeliveryStageCount() {
        return deliveryStageCount;
    }
}

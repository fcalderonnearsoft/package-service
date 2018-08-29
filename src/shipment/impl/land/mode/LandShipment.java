package shipment.impl.land.mode;

import shipment.impl.land.time.LandDeliveryTimeFactory;
import shipment.mode.ShipmentMode;
import shipment.time.DeliveryTimeEnum;

public class LandShipment extends ShipmentMode {

    public LandShipment(DeliveryTimeEnum deliveryTimeEnum) {
        deliveryTimeFactory = new LandDeliveryTimeFactory();
        setDeliveryTime(deliveryTimeEnum);
    }

    @Override
    public String getMode() {
        return "land shipping";
    }

    @Override
    protected void transport() {
        shipmentInformation.put("Step 3", "Putting package in a delivery truck");
        shipmentInformation.put("Step 4", "Driving to destination");
        shipmentInformation.put("Step 5", "Arriving to the destination office");
    }
}

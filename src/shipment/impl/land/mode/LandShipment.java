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
        addShipmentInfo(getDeliveryStageCount(), "Putting package in a delivery truck");
        addShipmentInfo(getDeliveryStageCount(), "Driving to destination");
        addShipmentInfo(getDeliveryStageCount(), "Arriving to the destination office");
    }
}

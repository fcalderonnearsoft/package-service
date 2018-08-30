package shipment.impl.air.mode;

import shipment.impl.air.time.AirDeliveryTimeFactory;
import shipment.mode.ShipmentMode;
import shipment.time.DeliveryTimeEnum;

public class AirShipment extends ShipmentMode {

    public AirShipment(DeliveryTimeEnum deliveryTimeEnum) {
        deliveryTimeFactory = new AirDeliveryTimeFactory();
        setDeliveryTime(deliveryTimeEnum);
    }

    @Override
    public String getMode() {
        return "air shipping";
    }

    @Override
    protected void transport() {
        addShipmentInfo(getDeliveryStageCount(), "Putting package in a plane");
        addShipmentInfo(getDeliveryStageCount(), "Flying to destination");
        addShipmentInfo(getDeliveryStageCount(), "Delivering to the destination office");
    }
}

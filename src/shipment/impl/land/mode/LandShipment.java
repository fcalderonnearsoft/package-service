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
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
    }
}

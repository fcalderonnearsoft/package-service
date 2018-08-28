package shipment.impl.air.mode;

import shipment.impl.air.time.AirDeliveryTimeFactory;
import shipment.mode.ShipmentMode;
import shipment.time.DeliveryTimeEnum;

public class AirShipment extends ShipmentMode {

    public AirShipment() {
        this(DeliveryTimeEnum.REGULAR);
    }

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
        System.out.println("- Putting package in a plane");
        System.out.println("- Flying to destination");
        System.out.println("- Delivering to the destination office");
    }
}

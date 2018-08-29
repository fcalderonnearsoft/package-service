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
        shipmentInformation.put("Step " + (shipmentInformation.size() - 1), "Putting package in a plane");
        shipmentInformation.put("Step " + (shipmentInformation.size() - 1), "Flying to destination");
        shipmentInformation.put("Step " + (shipmentInformation.size() - 1), "Delivering to the destination office");
    }
}

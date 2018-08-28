package shipment.mode;

import shipment.impl.air.mode.AirShipment;
import shipment.impl.land.mode.LandShipment;
import shipment.time.DeliveryTimeEnum;

public class ShipmentModeFactory {

    public static ShipmentMode create(ShipmentModeEnum shipmentModeEnum) {
        ShipmentMode shipmentMode = null;

        switch (shipmentModeEnum) {
            case LAND:
                shipmentMode = new LandShipment();
                break;
            case AIR:
                shipmentMode = new AirShipment();
                break;
        }

        return shipmentMode;
    }

    public static ShipmentMode create(ShipmentModeEnum shipmentModeEnum, DeliveryTimeEnum deliveryTimeEnum) {
        ShipmentMode shipmentMode = null;

        switch (shipmentModeEnum) {
            case LAND:
                shipmentMode = new LandShipment(deliveryTimeEnum);
                break;
            case AIR:
                shipmentMode = new AirShipment(deliveryTimeEnum);
                break;
        }

        return shipmentMode;
    }
}

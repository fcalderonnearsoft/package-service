package shipment.impl.air;

import shipment.mode.air.AirShipping;

public class ExpressAirShipping extends AirShipping {

    @Override
    public String getMode() {
        return "Express air shipping";
    }

    @Override
    public String getDeliveryTime() {
        return "Next day";
    }
}
package shipment.impl.air.time;

import shipment.time.DeliveryTime;

class AirSlowDelivery implements DeliveryTime {

    @Override
    public String getTime() {
        return "one week delivery";
    }
}

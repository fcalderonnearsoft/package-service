package shipment.impl.land.time;

import shipment.time.DeliveryTime;

class LandSlowDelivery implements DeliveryTime {

    @Override
    public String getTime() {
        return "2 week delivery";
    }
}

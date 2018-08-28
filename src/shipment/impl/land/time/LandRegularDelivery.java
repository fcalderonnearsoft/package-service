package shipment.impl.land.time;

import shipment.time.DeliveryTime;

class LandRegularDelivery implements DeliveryTime {

    @Override
    public String getTime() {
        return "4 to 6 day delivery";
    }
}

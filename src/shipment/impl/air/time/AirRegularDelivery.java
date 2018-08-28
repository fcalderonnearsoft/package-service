package shipment.impl.air.time;

import shipment.time.DeliveryTime;

class AirRegularDelivery implements DeliveryTime {

    @Override
    public String getTime() {
        return "2 to 3 day delivery";
    }
}

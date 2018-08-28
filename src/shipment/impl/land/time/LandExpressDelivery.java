package shipment.impl.land.time;

import shipment.time.DeliveryTime;

class LandExpressDelivery implements DeliveryTime {

    @Override
    public String getTime() {
        return "2 to 3 day delivery";
    }
}

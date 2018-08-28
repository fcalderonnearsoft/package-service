package shipment.impl.air.time;

import shipment.time.DeliveryTime;

class AirExpressDelivery implements DeliveryTime {

    @Override
    public String getTime() {
        return "guaranteed next day delivery";
    }
}

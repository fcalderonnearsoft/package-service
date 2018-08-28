package shipment.impl.air.time;

import shipment.time.DeliveryTime;
import shipment.time.DeliveryTimeEnum;
import shipment.time.DeliveryTimeFactory;

public class AirDeliveryTimeFactory implements DeliveryTimeFactory {

    @Override
    public DeliveryTime create(DeliveryTimeEnum deliveryTimeEnum) {
        DeliveryTime deliveryTime = null;

        switch (deliveryTimeEnum) {
            case EXPRESS:
                deliveryTime = new AirExpressDelivery();
                break;
            case REGULAR:
                deliveryTime = new AirRegularDelivery();
                break;
            case SLOW:
                deliveryTime = new AirSlowDelivery();
                break;
        }

        return deliveryTime;
    }
}

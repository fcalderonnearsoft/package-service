package shipment.impl.land.time;

import shipment.time.DeliveryTime;
import shipment.time.DeliveryTimeEnum;
import shipment.time.DeliveryTimeFactory;

public class LandDeliveryTimeFactory implements DeliveryTimeFactory {

    @Override
    public DeliveryTime create(DeliveryTimeEnum deliveryTimeEnum) {
        DeliveryTime deliveryTime = null;

        switch (deliveryTimeEnum) {
            case EXPRESS:
                deliveryTime = new LandExpressDelivery();
                break;
            case REGULAR:
                deliveryTime = new LandRegularDelivery();
                break;
            case SLOW:
                deliveryTime = new LandSlowDelivery();
                break;
        }

        return deliveryTime;
    }
}

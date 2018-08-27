package shipping;

import shipping.impl.AirShipping;
import shipping.impl.LandShipping;

public class ShippingModeFactory {

    public static ShippingMode create(ShippingModeEnum shippingModeEnum) {
        ShippingMode shippingMode = null;

        switch (shippingModeEnum) {
            case LAND:
                shippingMode = new LandShipping();
                break;
            case AIR:
                shippingMode = new AirShipping();
                break;
        }

        return shippingMode;
    }
}

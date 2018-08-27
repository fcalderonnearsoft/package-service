package shipping.impl;

import shipping.ShippingMode;

public class AirShipping extends ShippingMode {

    @Override
    public String getMode() {
        return "air shipping";
    }

    @Override
    protected void transport() {
        System.out.println("- Putting package in a plane");
        System.out.println("- Flying to destination");
        System.out.println("- Delivering to the destination office");
    }
}

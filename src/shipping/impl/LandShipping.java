package shipping.impl;

import shipping.ShippingMode;

public class LandShipping extends ShippingMode {

    @Override
    public String getMode() {
        return "land shipping";
    }

    @Override
    protected void transport() {
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
    }
}

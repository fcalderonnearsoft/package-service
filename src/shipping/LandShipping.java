package shipping;

public class LandShipping implements ShippingType {

    @Override
    public String getDescription() {
        return "land shipping";
    }

    @Override
    public String ship() {
        return "shipping by land";
    }
}

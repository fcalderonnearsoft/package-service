package shipping;

public class AirShipping implements ShippingType {

    @Override
    public String getDescription() {
        return "air shipping";
    }

    @Override
    public String ship() {
        return "shipping by air";
    }
}

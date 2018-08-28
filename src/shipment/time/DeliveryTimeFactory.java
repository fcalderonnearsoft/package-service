package shipment.time;

public interface DeliveryTimeFactory {

    DeliveryTime create(DeliveryTimeEnum deliveryTimeEnum);
}

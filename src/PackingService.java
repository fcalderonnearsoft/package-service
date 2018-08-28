import mailing.MailInfo;
import packing.type.AbstractPackage;
import promo.impl.ExpressBoxDelivery;
import promo.impl.ExpressDocumentDelivery;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;
import packing.type.impl.Package;
import packing.type.PackageTypeEnum;
import packing.type.PackageTypeFactory;
import packing.type.PackageType;
import shipment.mode.ShipmentModeEnum;
import shipment.mode.ShipmentModeFactory;
import shipment.mode.ShipmentMode;
import shipment.time.DeliveryTimeEnum;

public class PackingService {

    public static void main(String[] args) {

        sendPackageOne();
        sendPackageTwo();
        sendExpressDocument();
        sendExpressBox();
    }

    private static void sendPackageOne() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Rafa Manrique").setSenderAddress("Chihuahua, Chih")
                          .setReceiverName("Pau Quezada").setReceiverAddress("Casas grandes, Chih");

        ShipmentMode shippingMode = ShipmentModeFactory.create(ShipmentModeEnum.LAND, DeliveryTimeEnum.SLOW);

        PackageType packageType = PackageTypeFactory.create(PackageTypeEnum.BOX);

        PackageContent packageContent = new PackageContent("glass trophy to the java dev of the year", true, false, false);

        buildPackageShipAndPrintTicket(mailInfo, shippingMode, packageType, packageContent);
    }

    private static void sendPackageTwo() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Pau Quezada").setSenderAddress("Casas grandes, Chih")
                .setReceiverName("Rafa Manrique").setReceiverAddress("Colima, Col");

        ShipmentMode shippingMode = ShipmentModeFactory.create(ShipmentModeEnum.AIR);
        shippingMode.setDeliveryTime(DeliveryTimeEnum.EXPRESS);

        PackageType packageType = PackageTypeFactory.create(PackageTypeEnum.ENVELOPE);
        packageType.setSize(PackageSizeEnum.MEDIUM);

        PackageContent packageContent = new PackageContent("anthrax", false, false, true);

        buildPackageShipAndPrintTicket(mailInfo, shippingMode, packageType, packageContent);
    }

    private static void buildPackageShipAndPrintTicket(MailInfo mailingInformation,
                                                       ShipmentMode shipmentMode,
                                                       PackageType packageType,
                                                       PackageContent packageContent) {
        AbstractPackage pack = new Package();
        pack.setMailInfo(mailingInformation);
        pack.setShippingMode(shipmentMode);
        pack.setPackageType(packageType);
        pack.setPackageContent(packageContent);

        pack.shipAndPrintTicket();
    }

    private static void sendExpressDocument() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Pau Quezada").setSenderAddress("Casas grandes, Chih")
                .setReceiverName("Rafa Manrique").setReceiverAddress("Colima, Col");

        PackageContent packageContent = new PackageContent("javaschool member card", false, false, false);

        AbstractPackage pack = new ExpressDocumentDelivery(mailInfo, packageContent);

        pack.shipAndPrintTicket();
    }

    private static void sendExpressBox() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Rafa Manrique").setSenderAddress("Colima, Col")
                .setReceiverName("Pau Quezada").setReceiverAddress("Casas grandes, Chih");

        PackageContent packageContent = new PackageContent("12-bottle of rum box", true, true, false);

        AbstractPackage pack = new ExpressBoxDelivery(mailInfo, packageContent);

        pack.shipAndPrintTicket();
    }
}

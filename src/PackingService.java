import mailing.MailInfo;
import packing.type.AbstractPackage;
import promo.Promotion;
import promo.impl.ExpressBoxDelivery;
import promo.impl.ExpressDocumentDelivery;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;
import packing.type.impl.Package;
import packing.type.PackageTypeEnum;
import shipment.mode.ShipmentModeEnum;
import shipment.time.DeliveryTimeEnum;

public class PackingService {

    public static void main(String[] args) {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSenderName("Pau Quezada").setSenderAddress("Casas grandes, Chih")
                .setReceiverName("Rafa Manrique").setReceiverAddress("Colima, Col");

        sendPackageOne(mailInfo);
        sendPackageTwo(mailInfo);
        sendExpressDocument(mailInfo);
        sendExpressBox(mailInfo);
    }

    private static void sendPackageOne(MailInfo mailInfo) {
        PackageContent packageContent = new PackageContent("glass trophy to the java dev of the year", true, false, false);

        Package pack = new Package();
        pack.setMailInfo(mailInfo);
        pack.setPackageContent(packageContent);
        pack.setShippingMode(ShipmentModeEnum.LAND, DeliveryTimeEnum.SLOW);
        pack.setPackageType(PackageTypeEnum.BOX, PackageSizeEnum.SMALL);
        ship(pack);
    }

    private static void sendPackageTwo(MailInfo mailInfo) {
        PackageContent packageContent = new PackageContent("anthrax", false, false, true);

        Package pack = new Package();
        pack.setMailInfo(mailInfo);
        pack.setPackageContent(packageContent);
        pack.setShippingMode(ShipmentModeEnum.AIR, DeliveryTimeEnum.EXPRESS);
        pack.setPackageType(PackageTypeEnum.ENVELOPE, PackageSizeEnum.MEDIUM);
        ship(pack);
    }

    private static void sendExpressDocument(MailInfo mailInfo) {
        PackageContent packageContent = new PackageContent("javaschool member card", false, false, false);
        Promotion pack = new ExpressDocumentDelivery(mailInfo, packageContent);
        ship(pack);
    }

    private static void sendExpressBox(MailInfo mailInfo) {
        PackageContent packageContent = new PackageContent("12-bottle of rum box", true, true, false);
        Promotion pack = new ExpressBoxDelivery(mailInfo, packageContent);
        ship(pack);
    }

    private static void ship(AbstractPackage abstractPackage) {
        abstractPackage.shipAndPrintTicket();
    }
}

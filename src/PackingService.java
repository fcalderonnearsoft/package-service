import mailing.MailingInformation;
import packing.Package;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;
import packing.type.PackageTypeEnum;
import packing.type.PackageTypeFactory;
import packing.type.PackageType;
import shipping.ShippingModeEnum;
import shipping.ShippingModeFactory;
import shipping.ShippingMode;

public class PackingService {

    public static void main(String[] args) {

        sendPackageOne();
        sendPackageTwo();
    }

    private static void sendPackageOne() {
        MailingInformation mailingInformation = new MailingInformation();
        mailingInformation.setSenderName("Rafa Manrique").setSenderAddress("Chihuahua, Chih")
                          .setReceiverName("Pau Quezada").setReceiverAddress("Casas grandes, Chih");

        ShippingMode shippingType = ShippingModeFactory.create(ShippingModeEnum.LAND);

        PackageType packageType = PackageTypeFactory.create(PackageTypeEnum.BOX);

        PackageContent packageContent = new PackageContent("glass trophy to the java dev of the year", true, false, false);

        buildPackageShipAndPrintTicket(mailingInformation, shippingType, packageType, packageContent);
    }

    private static void sendPackageTwo() {
        MailingInformation mailingInformation = new MailingInformation();
        mailingInformation.setSenderName("Pau Quezada").setSenderAddress("Casas grandes, Chih")
                .setReceiverName("Rafa Manrique").setReceiverAddress("Colima, Col");

        ShippingMode shippingType = ShippingModeFactory.create(ShippingModeEnum.AIR);

        PackageType packageType = PackageTypeFactory.create(PackageTypeEnum.ENVELOPE);
        packageType.setSize(PackageSizeEnum.MEDIUM);

        PackageContent packageContent = new PackageContent("anthrax", false, false, true);

        buildPackageShipAndPrintTicket(mailingInformation, shippingType, packageType, packageContent);
    }

    private static void buildPackageShipAndPrintTicket(MailingInformation mailingInformation,
                                                       ShippingMode shippingType,
                                                       PackageType packageType,
                                                       PackageContent packageContent) {
        Package pack = new Package();
        pack.setMailingInformation(mailingInformation);
        pack.setShippingType(shippingType);
        pack.setPackageType(packageType);
        pack.setPackageContent(packageContent);

        pack.shipAndPrintTicket();
    }


}

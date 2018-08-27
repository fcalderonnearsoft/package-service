import mailing.MailingInformation;
import packing.Package;
import packing.content.PackageContent;
import packing.size.impl.MediumEnvelope;
import packing.size.impl.SmallBox;
import packing.type.impl.Box;
import packing.type.impl.Envelope;
import packing.type.PackageType;
import shipping.impl.AirShipping;
import shipping.impl.LandShipping;
import shipping.ShippingMode;

public class PackingService {

    public static void main(String[] args) {

        sendPackageOne();
        sendPackageTwo();
    }

    private static void sendPackageOne() {
        MailingInformation mailingInformation = new MailingInformation();
        mailingInformation.setSenderName("Rafa Manrique").setSenderAddress("Colima, Col.")
                          .setReceiverName("Pau Quezada").setReceiverAddress("Casas grandes, Chih");

        ShippingMode shippingType = new LandShipping();

        PackageType packageType = new Box();
        packageType.setSize(new SmallBox());

        PackageContent packageContent = new PackageContent("glass trophy to the java dev of the year", true, false, false);

        Package pack = new Package();
        pack.setMailingInformation(mailingInformation);
        pack.setShippingType(shippingType);
        pack.setPackageType(packageType);
        pack.setPackageContent(packageContent);

        pack.shipAndPrintTicket();
    }

    private static void sendPackageTwo() {
        MailingInformation mailingInformation = new MailingInformation();
        mailingInformation.setSenderName("Pau Quezada").setSenderAddress("Casas grandes, Chih.")
                .setReceiverName("Rafa Manrique").setReceiverAddress("Colima, Col");

        ShippingMode shippingType = new AirShipping();

        PackageType packageType = new Envelope();
        packageType.setSize(new MediumEnvelope());

        PackageContent packageContent = new PackageContent("anthrax", false, false, true);

        Package pack = new Package();
        pack.setMailingInformation(mailingInformation);
        pack.setShippingType(shippingType);
        pack.setPackageType(packageType);
        pack.setPackageContent(packageContent);

        pack.shipAndPrintTicket();
    }
}

import mailing.MailingInformation;
import packing.Package;
import packing.content.PackageContent;
import packing.size.LargeEnvelope;
import packing.size.MediumEnvelope;
import packing.size.SmallBox;
import packing.type.Box;
import packing.type.Envelope;
import packing.type.PackageType;
import shipping.AirShipping;
import shipping.LandShipping;
import shipping.ShippingType;

public class PackingService {

    public static void main(String[] args) {

        sendPackageOne();
        sendPackageTwo();
    }

    private static void sendPackageOne() {
        MailingInformation mailingInformation = new MailingInformation();
        mailingInformation.setSenderName("Rafa Manrique").setSenderAddress("Chihuahua, Chih.")
                          .setReceiverName("Doris Gonzalez").setReceiverAddress("Casas grandes, Chih");

        ShippingType shippingType = new LandShipping();

        PackageType packageType = new Box();
        packageType.setSize(new SmallBox());

        PackageContent packageContent = new PackageContent("glass trophy to the java dev of the year", true, false, false);

        Package pack = new Package();
        pack.setMailingInformation(mailingInformation);
        pack.setShippingType(shippingType);
        pack.setPackageType(packageType);
        pack.setPackageContent(packageContent);

        pack.ship();
    }

    private static void sendPackageTwo() {
        MailingInformation mailingInformation = new MailingInformation();
        mailingInformation.setSenderName("Pau Quezada").setSenderAddress("Casas grandes, Chih.")
                .setReceiverName("Rafa Manrique").setReceiverAddress("Chihuahua, Chih");

        ShippingType shippingType = new AirShipping();

        PackageType packageType = new Envelope();
        packageType.setSize(new MediumEnvelope());

        PackageContent packageContent = new PackageContent("anthrax", false, false, true);

        packing.Package pack = new packing.Package();
        pack.setMailingInformation(mailingInformation);
        pack.setShippingType(shippingType);
        pack.setPackageType(packageType);
        pack.setPackageContent(packageContent);

        pack.ship();
    }
}

package packing.type;

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.type.PackageType;
import shipment.mode.ShipmentMode;

public abstract class AbstractPackage {

    private MailInfo mailInfo;
    private ShipmentMode shippingMode;
    private PackageType packageType;
    private PackageContent packageContent;

    public void setMailInfo(MailInfo mailInfo) {
        this.mailInfo = mailInfo;
    }

    public void setShippingMode(ShipmentMode shippingMode) {
        this.shippingMode = shippingMode;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public void setPackageContent(PackageContent packageContent) {
        this.packageContent = packageContent;
    }

    public void shipAndPrintTicket() {
        System.out.println("SHIPPING");
        System.out.println("--------------");
        shippingMode.ship();
        printTicket();
    }

    private void printTicket() {
        printPackageDescription();
        printMailInfo();
    }

    private void printPackageDescription() {
        System.out.println("\n");
        System.out.println("PACKAGE INFORMATION");
        System.out.println("--------------");
        System.out.println("- Type: " + packageType.getName() + " (" + packageType.getDescription() + ")");
        System.out.println("- Size: " + packageType.getPackageSize().getDescription() +
                " (" + packageType.getPackageSize().getSize() + ")");

        System.out.println("- Content: " + packageContent.getDescription());

        if (packageContent.isFragile()) {
            System.out.println("- (F) Fragile");
        }

        if (packageContent.isLiquid()) {
            System.out.println("- (L) Liquid");
        }

        if (packageContent.isDangerous()) {
            System.out.println("- (D) Dangerous");
        }

        System.out.println("\n");
    }

    private void printMailInfo() {
        System.out.println("MAIL INFO");
        System.out.println("--------------");
        System.out.println("- Sender's name: " + mailInfo.getSenderName());
        System.out.println("- Sender's address: " + mailInfo.getSenderAddress());
        System.out.println("- Receiver's name: " + mailInfo.getReceiverName());
        System.out.println("- Receiver's description: " + mailInfo.getReceiverAddress());
        System.out.println("\n");
    }
}

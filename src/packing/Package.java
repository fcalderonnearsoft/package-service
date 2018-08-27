package packing;

import mailing.MailingInformation;
import packing.content.PackageContent;
import packing.type.PackageType;
import shipping.ShippingMode;

public class Package {

    private MailingInformation mailingInformation;
    private ShippingMode shippingMode;
    private PackageType packageType;
    private PackageContent packageContent;

    public void setMailingInformation(MailingInformation mailingInformation) {
        this.mailingInformation = mailingInformation;
    }

    public void setShippingType(ShippingMode shippingType) {
        this.shippingMode = shippingType;
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
        printMailingInformation();
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

    private void printMailingInformation() {
        System.out.println("MAILING INFORMATION");
        System.out.println("--------------");
        System.out.println("- Sender's name: " + mailingInformation.getSenderName());
        System.out.println("- Sender's address: " + mailingInformation.getSenderAddress());
        System.out.println("- Receiver's name: " + mailingInformation.getReceiverName());
        System.out.println("- Receiver's description: " + mailingInformation.getReceiverAddress());
        System.out.println("\n");
    }
}

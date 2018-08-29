import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import java.util.Random;

import packing.type.PackageTypeEnum;
import shipment.mode.ShipmentModeEnum;
import shipment.time.DeliveryTimeEnum;

class Package {

    private MailInfo mailInfo;
    private PackageContent packageContent;

    Package(MailInfo mailInfo, PackageContent packageContent) {
        this.mailInfo = mailInfo;
        this.packageContent = packageContent;
    }

    void shipAndPrintTicket(PackageTypeEnum packageTypeEnum,
                                   PackageSizeEnum packageSizeEnum,
                                   ShipmentModeEnum shippingModeEnum,
                                   DeliveryTimeEnum deliveryTimeEnum) {

        System.out.println("PACKAGE INFORMATION");
        System.out.println("--------------");

        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            System.out.println("Type: box (multi-purpose box-type package)");

            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                printSmallBoxDescription();
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                printMediumBoxDescription();
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                printLargeBoxDescription();
            }

            System.out.println("Content: " + packageContent.getDescription());

        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            System.out.println("Type: envelope (multi-purpose box-type package)");

            if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
                printSmallEnvelopeDescription();
            } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
                printMediumEnvelopeDescription();
            } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
                printLargeEnvelopeDescription();
            }

            System.out.println("Content: " + packageContent.getDescription());
        }

        if (packageContent.isFragile()) {
            System.out.println("(F) Fragile");
        }

        if (packageContent.isLiquid()) {
            System.out.println("(L) Liquid");
        }

        if (packageContent.isDangerous()) {
            System.out.println("(D) Dangerous");
        }

        System.out.println("\n");
        System.out.println("MAIL INFORMATION");
        System.out.println("--------------");

        System.out.println("Sender's name: " + mailInfo.getSenderName());
        System.out.println("Sender's address: " + mailInfo.getSenderAddress());
        System.out.println("Receiver's name: " + mailInfo.getReceiverName());
        System.out.println("Receiver's address: " + mailInfo.getReceiverAddress());
        System.out.println("\n");

        System.out.println("SHIPPING INFORMATION");
        System.out.println("--------------");

        if (shippingModeEnum.equals(ShipmentModeEnum.LAND)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                printLandExpressDeliveryInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                printLandRegularDeliveryInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                printLandSlowDeliveryInfo();
            }
        } else if (shippingModeEnum.equals(ShipmentModeEnum.AIR)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                printAirExpressDeliveryInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                printAirRegularDeliveryInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                printAirSlowDeliveryInfo();
            }
        }

        System.out.println("**********************************************");
        System.out.println("\n");
    }

    private void printSmallBoxDescription() {
        System.out.println("Size: small (Length: 40cm, Width: 30cm, Height: 30cm)");
    }

    private void printMediumBoxDescription() {
        System.out.println("Size: medium (Length: 100cm, Width: 100cm, Height: 100cm)");
    }

    private void printLargeBoxDescription() {
        System.out.println("Size: large (Length: 300cm, Width: 100cm, Height: 100cm)");
    }

    private void printSmallEnvelopeDescription() {
        System.out.println("Size: small (Length: 30cm, Width: 10cm");
    }

    private void printMediumEnvelopeDescription() {
        System.out.println("Size: medium (Length: 40cm, Width: 30cm");
    }

    private void printLargeEnvelopeDescription() {
        System.out.println("Size: large (Length: 60cm, Width: 45cm");
    }

    private void printLandExpressDeliveryInfo() {
        System.out.println("- Mode: land express shipping");
        System.out.println("- Delivery time: 2 to 3 day delivery");
        printFolio();
        printLandDeliveryStages();
    }

    private void printLandRegularDeliveryInfo() {
        System.out.println("- Mode: land express shipping");
        System.out.println("- Delivery time: 5 to 6 day delivery");
        printFolio();
        printLandDeliveryStages();
    }

    private void printLandSlowDeliveryInfo() {
        System.out.println("- Mode: land express shipping");
        System.out.println("- Delivery time: 2 week delivery");
        printFolio();
        printLandDeliveryStages();
    }

    private void printAirExpressDeliveryInfo() {
        System.out.println("- Mode: air express shipping");
        System.out.println("- Delivery time: guaranteed next day delivery");
        printFolio();
        printAirDeliveryStages();
    }

    private void printAirRegularDeliveryInfo() {
        System.out.println("- Mode: air regular shipping");
        System.out.println("- Delivery time: 2 to 3 day delivery");
        printFolio();
        printAirDeliveryStages();
    }

    private void printAirSlowDeliveryInfo() {
        System.out.println("- Mode: air slow shipping");
        System.out.println("- Delivery time: one week delivery");
        printFolio();
        printAirDeliveryStages();
    }

    private void printFolio() {
        System.out.println("- Folio number: " + new Random().nextInt(1000000));
        System.out.println("\n");
    }

    private void printLandDeliveryStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a delivery truck");
        System.out.println("- Driving to destination");
        System.out.println("- Arriving to the destination office");
        System.out.println("- Receiving package at destination office");
    }

    private void printAirDeliveryStages() {
        System.out.println("- Receiving package at the origin office");
        System.out.println("- Labeling package for shipping");
        System.out.println("- Putting package in a plane");
        System.out.println("- Flying to destination");
        System.out.println("- Delivering to the destination office");
        System.out.println("- Receiving package at destination office");
    }
}

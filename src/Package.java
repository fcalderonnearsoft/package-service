import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import java.util.Random;

import packing.size.impl.box.LargeBox;
import packing.size.impl.box.MediumBox;
import packing.size.impl.box.SmallBox;
import packing.size.impl.envelope.LargeEnvelope;
import packing.size.impl.envelope.MediumEnvelope;
import packing.size.impl.envelope.SmallEnvelope;
import packing.type.PackageTypeEnum;
import shipment.impl.air.ExpressAirShipping;
import shipment.impl.air.RegularAirShipping;
import shipment.impl.air.SlowAirShipping;
import shipment.impl.land.ExpressLandShipping;
import shipment.impl.land.RegularLandShipping;
import shipment.impl.land.SlowLandShipping;
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

        System.out.println("MAIL INFORMATION");
        System.out.println("--------------");

        printMailingInformation();

        System.out.println("PACKAGE INFORMATION");
        System.out.println("--------------");

        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            printBoxDescription(packageSizeEnum);
        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            printEnvelopeDescription(packageSizeEnum);
        }

        printPackageContent();

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

    private void printMailingInformation() {
        System.out.println("Sender's name: " + mailInfo.getSenderName());
        System.out.println("Sender's address: " + mailInfo.getSenderAddress());
        System.out.println("Receiver's name: " + mailInfo.getReceiverName());
        System.out.println("Receiver's address: " + mailInfo.getReceiverAddress());
        System.out.println("\n");
    }

    private void printBoxDescription(PackageSizeEnum packageSizeEnum) {
        System.out.println("Type: Box (Multi-purpose box-type package)");

        if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
            printSmallBoxDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
            printMediumBoxDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
            printLargeBoxDescription();
        }
    }

    private void printEnvelopeDescription(PackageSizeEnum packageSizeEnum) {
        System.out.println("Type: Envelope (For posting documents, photos and stuff like that)");

        if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
            printSmallEnvelopeDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
            printMediumEnvelopeDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
            printLargeEnvelopeDescription();
        }
    }

    private void printPackageContent() {
        System.out.println("Content: " + packageContent.getDescription());

        if (packageContent.isFragile()) {
            System.out.println("(F) Fragile");
        }

        if (packageContent.isLiquid()) {
            System.out.println("(L) Liquid");
        }

        if (packageContent.isDangerous()) {
            System.out.println("(D) Dangerous");
        }
    }

    private void printSmallBoxDescription() {
        SmallBox box = new SmallBox();
        System.out.println("Size: " + box.getDescription() + " (Length: " + box.getLength() + ", Width: " + box.getWidth() + ", Height: " + box.getHeight() + ")");
    }

    private void printMediumBoxDescription() {
        MediumBox box = new MediumBox();
        System.out.println("Size: " + box.getDescription() + " (Length: " + box.getLength() + ", Width: " + box.getWidth() + ", Height: " + box.getHeight() + ")");
    }

    private void printLargeBoxDescription() {
        LargeBox box = new LargeBox();
        System.out.println("Size: " + box.getDescription() + " (Length: " + box.getLength() + ", Width: " + box.getWidth() + ", Height: " + box.getHeight() + ")");
    }

    private void printSmallEnvelopeDescription() {
        SmallEnvelope envelope = new SmallEnvelope();
        System.out.println("Size: " + envelope.getDescription() + " (Length: " + envelope.getLength() + ", Width: " + envelope.getWidth() + ")");
    }

    private void printMediumEnvelopeDescription() {
        MediumEnvelope envelope = new MediumEnvelope();
        System.out.println("Size: " + envelope.getDescription() + " (Length: " + envelope.getLength() + ", Width: " + envelope.getWidth() + ")");
    }

    private void printLargeEnvelopeDescription() {
        LargeEnvelope envelope = new LargeEnvelope();
        System.out.println("Size: " + envelope.getDescription() + " (Length: " + envelope.getLength() + ", Width: " + envelope.getWidth() + ")");
    }

    private void printLandExpressDeliveryInfo() {
        ExpressLandShipping shippingMode = new ExpressLandShipping();
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
        printFolio();
        printLandDeliveryStages();
    }

    private void printLandRegularDeliveryInfo() {
        RegularLandShipping shippingMode = new RegularLandShipping();
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
        printFolio();
        printLandDeliveryStages();
    }

    private void printLandSlowDeliveryInfo() {
        SlowLandShipping shippingMode = new SlowLandShipping();
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
        printFolio();
        printLandDeliveryStages();
    }

    private void printAirExpressDeliveryInfo() {
        ExpressAirShipping shippingMode = new ExpressAirShipping();
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
        printFolio();
        printAirDeliveryStages();
    }

    private void printAirRegularDeliveryInfo() {
        RegularAirShipping shippingMode = new RegularAirShipping();
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
        printFolio();
        printAirDeliveryStages();
    }

    private void printAirSlowDeliveryInfo() {
        SlowAirShipping shippingMode = new SlowAirShipping();
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
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

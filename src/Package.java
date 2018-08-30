import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import java.util.Random;

import packing.size.box.SizedBox;
import packing.size.envelope.SizedEnvelope;
import packing.size.impl.box.Box;
import packing.size.impl.box.LargeBox;
import packing.size.impl.box.MediumBox;
import packing.size.impl.box.SmallBox;
import packing.size.impl.envelope.Envelope;
import packing.size.impl.envelope.LargeEnvelope;
import packing.size.impl.envelope.MediumEnvelope;
import packing.size.impl.envelope.SmallEnvelope;
import packing.type.PackageTypeEnum;
import shipment.mode.air.AirShipping;
import shipment.impl.air.ExpressAirShipping;
import shipment.impl.air.RegularAirShipping;
import shipment.impl.air.SlowAirShipping;
import shipment.impl.land.ExpressLandShipping;
import shipment.mode.land.LandShipping;
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
                printLandExpressShippingInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                printLandRegularShippingInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                printLandSlowShippingInfo();
            }
        } else if (shippingModeEnum.equals(ShipmentModeEnum.AIR)) {
            if (deliveryTimeEnum.equals(DeliveryTimeEnum.EXPRESS)) {
                printAirExpressShippingInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.REGULAR)) {
                printAirRegularShippingInfo();
            } else if (deliveryTimeEnum.equals(DeliveryTimeEnum.SLOW)) {
                printAirSlowShippingInfo();
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
        Box box = new Box();
        System.out.println("Type: " + box.getName() + " " + box.getDescription());

        if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
            printSmallBoxDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
            printMediumBoxDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
            printLargeBoxDescription();
        }
    }

    private void printEnvelopeDescription(PackageSizeEnum packageSizeEnum) {
        Envelope envelope = new Envelope();
        System.out.println("Type: " + envelope.getName() + " " + envelope.getDescription());

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
        SizedBox box = new SmallBox();
        printSizedBoxDescription(box);
    }

    private void printMediumBoxDescription() {
        SizedBox box = new MediumBox();
        printSizedBoxDescription(box);
    }

    private void printLargeBoxDescription() {
        SizedBox box = new LargeBox();
        printSizedBoxDescription(box);
    }

    private void printSmallEnvelopeDescription() {
        SizedEnvelope envelope = new SmallEnvelope();
        printSizedEnvelopeDescription(envelope);
    }

    private void printMediumEnvelopeDescription() {
        SizedEnvelope envelope = new MediumEnvelope();
        printSizedEnvelopeDescription(envelope);
    }

    private void printLargeEnvelopeDescription() {
        SizedEnvelope envelope = new LargeEnvelope();
        printSizedEnvelopeDescription(envelope);
    }

    private void printSizedBoxDescription(SizedBox box) {
        System.out.println("Size: " + box.getSize() + " (Length: " + box.getLength() + ", Width: " + box.getWidth() + ", Height: " + box.getHeight() + ")");
    }

    private void printSizedEnvelopeDescription(SizedEnvelope envelope) {
        System.out.println("Size: " + envelope.getSize() + " (Length: " + envelope.getLength() + ", Width: " + envelope.getWidth() + ")");
    }

    private void printLandExpressShippingInfo() {
        LandShipping shippingMode = new ExpressLandShipping();
        printLandShippingInfo(shippingMode);
    }

    private void printLandRegularShippingInfo() {
        LandShipping shippingMode = new RegularLandShipping();
        printLandShippingInfo(shippingMode);
    }

    private void printLandSlowShippingInfo() {
        LandShipping shippingMode = new SlowLandShipping();
        printLandShippingInfo(shippingMode);
    }

    private void printAirExpressShippingInfo() {
        AirShipping shippingMode = new ExpressAirShipping();
        printAirShippingInfo(shippingMode);
    }

    private void printAirRegularShippingInfo() {
        AirShipping shippingMode = new RegularAirShipping();
        printAirShippingInfo(shippingMode);
    }

    private void printAirSlowShippingInfo() {
        AirShipping shippingMode = new SlowAirShipping();
        printAirShippingInfo(shippingMode);
    }

    private void printLandShippingInfo(LandShipping shippingMode) {
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
        printFolio();
        LandShipping.printShippingStages();
    }

    private void printAirShippingInfo(AirShipping shippingMode) {
        System.out.println("- Mode: " + shippingMode.getMode());
        System.out.println("- Delivery time: " + shippingMode.getDeliveryTime());
        printFolio();
        AirShipping.printShippingStages();
    }

    private void printFolio() {
        System.out.println("- Folio number: " + new Random().nextInt(1000000));
        System.out.println("\n");
    }
}

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import java.util.Random;

import packing.size.box.SizedBox;
import packing.size.envelope.SizedEnvelope;
import packing.type.PackageType;
import packing.type.impl.Box;
import packing.size.impl.box.LargeBox;
import packing.size.impl.box.MediumBox;
import packing.size.impl.box.SmallBox;
import packing.type.impl.Envelope;
import packing.size.impl.envelope.LargeEnvelope;
import packing.size.impl.envelope.MediumEnvelope;
import packing.size.impl.envelope.SmallEnvelope;
import packing.type.PackageTypeEnum;
import shipment.mode.Shipping;
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

        printPackageInformation(packageTypeEnum, packageSizeEnum);

        System.out.println("SHIPPING INFORMATION");
        System.out.println("--------------");

        printShippingInformation(shippingModeEnum, deliveryTimeEnum);

        System.out.println("**********************************************");
        System.out.println("\n");
    }

    private void printPackageInformation(PackageTypeEnum packageTypeEnum, PackageSizeEnum packageSizeEnum) {
        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            printBoxInformation(packageSizeEnum);
        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            printEnvelopeInformation(packageSizeEnum);
        }

        printPackageContent();
    }

    private void printMailingInformation() {
        System.out.println("Sender's name: " + mailInfo.getSenderName());
        System.out.println("Sender's address: " + mailInfo.getSenderAddress());
        System.out.println("Receiver's name: " + mailInfo.getReceiverName());
        System.out.println("Receiver's address: " + mailInfo.getReceiverAddress());
        System.out.println("\n");
    }

    private void printBoxInformation(PackageSizeEnum packageSizeEnum) {
        PackageType packageType = new Box();
        printPackageTypeDescription(packageType);
        printSizedBoxDescription(packageSizeEnum);
    }

    private void printEnvelopeInformation(PackageSizeEnum packageSizeEnum) {
        PackageType packageType = new Envelope();
        printPackageTypeDescription(packageType);
        printSizedEnvelopeDescription(packageSizeEnum);
    }

    private void printPackageTypeDescription(PackageType packageType) {
        System.out.println("Type: " + packageType.getName() + " " + packageType.getDescription());
    }

    private void printSizedBoxDescription(PackageSizeEnum packageSizeEnum) {
        if (packageSizeEnum.equals(PackageSizeEnum.SMALL)) {
            printSmallBoxDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.MEDIUM)) {
            printMediumBoxDescription();
        } else if (packageSizeEnum.equals(PackageSizeEnum.LARGE)) {
            printLargeBoxDescription();
        }
    }

    private void printSizedEnvelopeDescription(PackageSizeEnum packageSizeEnum) {
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

        System.out.println("\n");
    }

    private void printShippingInformation(ShipmentModeEnum shippingModeEnum, DeliveryTimeEnum deliveryTimeEnum) {
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
        Shipping shipping = new ExpressLandShipping();
        printShippingInfo(shipping);
    }

    private void printLandRegularShippingInfo() {
        Shipping shipping = new RegularLandShipping();
        printShippingInfo(shipping);
    }

    private void printLandSlowShippingInfo() {
        Shipping shipping = new SlowLandShipping();
        printShippingInfo(shipping);
    }

    private void printAirExpressShippingInfo() {
        Shipping shipping = new ExpressAirShipping();
        printShippingInfo(shipping);
    }

    private void printAirRegularShippingInfo() {
        Shipping shipping = new RegularAirShipping();
        printShippingInfo(shipping);
    }

    private void printAirSlowShippingInfo() {
        Shipping shipping = new SlowAirShipping();
        printShippingInfo(shipping);
    }

    private void printShippingInfo(Shipping shipping) {
        printShippingMode(shipping);
        shipping.printStages();
    }

    private void printShippingMode(Shipping shipping) {
        System.out.println("- Mode: " + shipping.getMode());
        System.out.println("- Delivery time: " + shipping.getDeliveryTime());
        printFolio();
    }

    private void printFolio() {
        System.out.println("- Folio number: " + new Random().nextInt(1000000));
        System.out.println("\n");
    }
}

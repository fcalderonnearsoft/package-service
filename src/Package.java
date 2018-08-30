import javafx.util.Pair;
import mailing.MailInfo;
import packing.SizedPackageType;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

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

        Printer printer = new MapPrinter();

        printer.print(getMailingInformation());
        System.out.println("\n");

        printPackageInformation(packageTypeEnum, packageSizeEnum);
        printShippingInformation(shippingModeEnum, deliveryTimeEnum);

        System.out.println("**********************************************");
        System.out.println("\n");
    }

    private void printPackageInformation(PackageTypeEnum packageTypeEnum, PackageSizeEnum packageSizeEnum) {
        System.out.println("PACKAGE INFORMATION");
        System.out.println("--------------");
        if (packageTypeEnum.equals(PackageTypeEnum.BOX)) {
            printBoxInformation(packageSizeEnum);
        } else if (packageTypeEnum.equals(PackageTypeEnum.ENVELOPE)) {
            printEnvelopeInformation(packageSizeEnum);
        }

        printPackageContent();
    }

    private Pair<String, Map<String, String>> getMailingInformation() {
        Map<String, String> mailInfoMap = new LinkedHashMap<>();
        Pair<String, Map<String, String>> section = new Pair<>("MAIL INFORMATION", mailInfoMap);
        mailInfoMap.put("Sender's name", mailInfo.getSenderName());
        mailInfoMap.put("Sender's address", mailInfo.getSenderAddress());
        mailInfoMap.put("Receiver's name", mailInfo.getReceiverName());
        mailInfoMap.put("Receiver's address", mailInfo.getReceiverAddress());
        return section;
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
    }

    private void printSmallBoxDescription() {
        SizedPackageType box = new SmallBox();
        printSizedPackageTypeDescription(box);
    }

    private void printMediumBoxDescription() {
        SizedPackageType box = new MediumBox();
        printSizedPackageTypeDescription(box);
    }

    private void printLargeBoxDescription() {
        SizedPackageType box = new LargeBox();
        printSizedPackageTypeDescription(box);
    }

    private void printSmallEnvelopeDescription() {
        SizedPackageType envelope = new SmallEnvelope();
        printSizedPackageTypeDescription(envelope);
    }

    private void printMediumEnvelopeDescription() {
        SizedPackageType envelope = new MediumEnvelope();
        printSizedPackageTypeDescription(envelope);
    }

    private void printLargeEnvelopeDescription() {
        SizedPackageType envelope = new LargeEnvelope();
        printSizedPackageTypeDescription(envelope);
    }

    private void printSizedPackageTypeDescription(SizedPackageType sizedPackageType) {
        System.out.println("Size: " + sizedPackageType.getSize() + " (" + sizedPackageType.getMeasurements() + ")");
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

    private class MapPrinter implements Printer {
        public void print(Pair<String, Map<String, String>> information) {
            System.out.println("\n");
            System.out.println(information.getKey());
            System.out.println("--------------");
            for(Map.Entry<String, String> e : information.getValue().entrySet()) {
                String key = e.getKey();
                String value = e.getValue();
                System.out.println("- " + key + ": " + value);
            }
        }
    }
}

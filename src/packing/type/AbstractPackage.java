package packing.type;

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;
import shipment.mode.ShipmentMode;

import util.Printer;

import java.util.LinkedHashMap;
import java.util.Map;

import shipment.mode.ShipmentModeEnum;
import shipment.mode.ShipmentModeFactory;
import shipment.time.DeliveryTimeEnum;

public abstract class AbstractPackage {

    private MailInfo mailInfo;
    private ShipmentMode shippingMode;
    private PackageType packageType;
    private PackageContent packageContent;

    public void setMailInfo(MailInfo mailInfo) {
        this.mailInfo = mailInfo;
    }

    public void setShippingMode(ShipmentModeEnum shippingModeEnum, DeliveryTimeEnum deliveryTimeEnum) {
        this.shippingMode = ShipmentModeFactory.create(shippingModeEnum, deliveryTimeEnum);
    }

    public void setPackageType(PackageTypeEnum packageTypeEnum, PackageSizeEnum packageSizeEnum) {
        this.packageType = PackageTypeFactory.create(packageTypeEnum, packageSizeEnum);
    }

    public void setPackageContent(PackageContent packageContent) {
        this.packageContent = packageContent;
    }

    public void shipAndPrintTicket() {
        Printer printer = new PrinterImpl();
        printer.print("MAILING INFORMATION", buildPackageMailingInformationMap());
        printer.print("PACKAGE INFORMATION", buildPackageDescriptionMap());
        printer.print("SHIPPING INFORMATION", buildShipmentInformationMap());
        System.out.println("****************************************");
    }

    private Map<String, String> buildPackageMailingInformationMap() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("Sender's name", mailInfo.getSenderName());
        info.put("Sender's address", mailInfo.getSenderAddress());
        info.put("Receiver's name", mailInfo.getReceiverName());
        info.put("Receiver's address", mailInfo.getReceiverAddress());
        return info;
    }

    private Map<String,String> buildPackageDescriptionMap() {
        Map<String, String> description = new LinkedHashMap<>();
        description.put("Type", packageType.getName() + " (" + packageType.getDescription() + ")");
        description.put("Size", packageType.getPackageSize().getDescription() +
                " (" + packageType.getPackageSize().getSize() + ")");
        description.put("Content", packageContent.getDescription());

        if (packageContent.isFragile()) {
            description.put("(F)", "Fragile");
        }

        if (packageContent.isLiquid()) {
            description.put("(L)", "Liquid");
        }

        if (packageContent.isDangerous()) {
            description.put("(D)", "Dangerous");
        }

        return description;
    }

    private Map<String, String> buildShipmentInformationMap() {
        return shippingMode.getShipmentInfo();
    }

    class PrinterImpl implements Printer {
        public void print(String title, Map<String, String> information) {
            System.out.println("\n");
            System.out.println(title);
            System.out.println("--------------");
            for(Map.Entry<String, String> e : information.entrySet()) {
                String key = e.getKey();
                String value = e.getValue();
                System.out.println("- " + key + ": " + value);
            }
        }
    }
}

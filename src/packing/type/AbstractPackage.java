package packing.type;

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.type.PackageType;
import shipment.mode.ShipmentMode;
import util.Printer;

import java.util.LinkedHashMap;
import java.util.Map;

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
        new PrinterImpl().printTicket();
    }

    class PrinterImpl {
        public void printTicket() {
            Map<String, String> description = buildPackageDescriptionMap();
            Map<String, String> mailingInfo = buildPackageMailingInformationMap();

            Printer printer = (title, information) -> {
                System.out.println("\n");
                System.out.println(title);
                System.out.println("--------------");
                for(Map.Entry<String, String> e : information.entrySet()) {
                    String key = e.getKey();
                    String value = e.getValue();
                    System.out.println("- " + key + ": " + value);
                }
                System.out.println("\n");
            };

            printer.print("PACKAGE INFORMATION", description);
            printer.print("MAILING INFORMATION", mailingInfo);
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

        private Map<String, String> buildPackageMailingInformationMap() {
            Map<String, String> info = new LinkedHashMap<>();
            info.put("Sender's name", mailInfo.getSenderName());
            info.put("Sender's address", mailInfo.getSenderAddress());
            info.put("Receiver's name", mailInfo.getReceiverName());
            info.put("Receiver's description", mailInfo.getReceiverName());
            return info;
        }

    }
}

package promo.impl;

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;
import packing.type.PackageTypeEnum;
import promo.Promotion;
import shipment.mode.ShipmentModeEnum;
import shipment.time.DeliveryTimeEnum;

public class ExpressBoxDelivery extends Promotion {

    public ExpressBoxDelivery(MailInfo mailInfo, PackageContent packageContent) {
        super(mailInfo, packageContent);
        setPackageType(PackageTypeEnum.BOX, PackageSizeEnum.MEDIUM);
        setShippingMode(ShipmentModeEnum.AIR, DeliveryTimeEnum.EXPRESS);
    }
}

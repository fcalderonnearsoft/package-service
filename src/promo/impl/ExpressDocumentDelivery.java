package promo.impl;

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.type.PackageTypeEnum;
import promo.Promotion;
import shipment.mode.ShipmentModeEnum;
import shipment.time.DeliveryTimeEnum;

public class ExpressDocumentDelivery extends Promotion {

    public ExpressDocumentDelivery(MailInfo mailInfo, PackageContent packageContent) {
        super(mailInfo, packageContent);
        setPackageType(PackageTypeEnum.ENVELOPE);
        setShippingMode(ShipmentModeEnum.AIR, DeliveryTimeEnum.EXPRESS);
    }
}

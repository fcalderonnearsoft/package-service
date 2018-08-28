package promo.impl;

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.type.PackageTypeEnum;
import packing.type.PackageTypeFactory;
import promo.Promotion;
import shipment.mode.ShipmentModeEnum;
import shipment.mode.ShipmentModeFactory;
import shipment.time.DeliveryTimeEnum;

public class ExpressDocumentDelivery extends Promotion {

    public ExpressDocumentDelivery(MailInfo mailInfo, PackageContent packageContent) {
        super(mailInfo, packageContent);
        setPackageType(PackageTypeFactory.create(PackageTypeEnum.ENVELOPE));
        setShippingMode(ShipmentModeFactory.create(ShipmentModeEnum.AIR, DeliveryTimeEnum.EXPRESS));
    }
}

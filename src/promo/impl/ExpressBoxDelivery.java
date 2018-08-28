package promo.impl;

import mailing.MailInfo;
import packing.content.PackageContent;
import packing.size.PackageSizeEnum;
import packing.type.PackageTypeEnum;
import packing.type.PackageTypeFactory;
import promo.Promotion;
import shipment.mode.ShipmentModeEnum;
import shipment.mode.ShipmentModeFactory;
import shipment.time.DeliveryTimeEnum;

public class ExpressBoxDelivery extends Promotion {

    public ExpressBoxDelivery(MailInfo mailInfo, PackageContent packageContent) {
        super(mailInfo, packageContent);
        setPackageType(PackageTypeFactory.create(PackageTypeEnum.BOX, PackageSizeEnum.MEDIUM));
        setShippingMode(ShipmentModeFactory.create(ShipmentModeEnum.AIR, DeliveryTimeEnum.EXPRESS));
    }
}

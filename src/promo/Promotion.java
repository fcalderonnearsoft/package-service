package promo;

import mailing.MailInfo;
import packing.type.AbstractPackage;
import packing.content.PackageContent;

public abstract class Promotion extends AbstractPackage {

    public Promotion(MailInfo mailInfo, PackageContent packageContent) {
        setMailInfo(mailInfo);
        setPackageContent(packageContent);
    }
}

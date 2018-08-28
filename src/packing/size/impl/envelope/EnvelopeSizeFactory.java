package packing.size.impl.envelope;

import packing.size.envelope.EnvelopeSize;
import packing.size.PackageSizeEnum;
import packing.size.PackageSizeFactory;

public class EnvelopeSizeFactory implements PackageSizeFactory {

    private static EnvelopeSizeFactory uniqueInstance;

    private EnvelopeSizeFactory() {
    }

    public static EnvelopeSizeFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EnvelopeSizeFactory();
        }
        return uniqueInstance;
    }

    @Override
    public EnvelopeSize create(PackageSizeEnum size) {
        EnvelopeSize packageSize = null;

        switch (size) {
            case SMALL:
                packageSize = new SmallEnvelope();
                break;
            case MEDIUM:
                packageSize = new MediumEnvelope();
                break;
            case LARGE:
                packageSize = new LargeEnvelope();
                break;
        }

        return packageSize;
    }
}

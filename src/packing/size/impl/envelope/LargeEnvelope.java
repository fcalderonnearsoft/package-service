package packing.size.impl.envelope;

import packing.size.envelope.EnvelopeSize;

public class LargeEnvelope extends EnvelopeSize {

    @Override
    public String getDescription() {
        return "large envelope";
    }

    @Override
    public String getLength() {
        return "60cm";
    }

    @Override
    public String getWidth() {
        return "45cm";
    }
}

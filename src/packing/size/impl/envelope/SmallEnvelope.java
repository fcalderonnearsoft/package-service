package packing.size.impl.envelope;

import packing.size.envelope.EnvelopeSize;

public class SmallEnvelope extends EnvelopeSize {

    @Override
    public String getDescription() {
        return "small envelope";
    }

    @Override
    public String getLength() {
        return "30cm";
    }

    @Override
    public String getWidth() {
        return "10cm";
    }
}

package packing.size.impl.envelope;

import packing.size.envelope.SizedEnvelope;

public class LargeEnvelope implements SizedEnvelope {

    public String getSize() {
        return "Large";
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
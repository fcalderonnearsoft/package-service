package mailing;

public class MailingInformation {

    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;

    public String getSenderName() {
        return senderName;
    }

    public MailingInformation setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public MailingInformation setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
        return this;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public MailingInformation setReceiverName(String receiverName) {
        this.receiverName = receiverName;
        return this;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public MailingInformation setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
        return this;
    }
}

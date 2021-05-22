package src.payment;

public class CheckMail extends Payment {
    private String recipient; // Destinatario
    private String sender; // Remetente


    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public CheckMail(int id, String recipient, String sender){
        setIdEmployee(id);
        setRecipient(recipient);
        setSender(sender);
    }
}
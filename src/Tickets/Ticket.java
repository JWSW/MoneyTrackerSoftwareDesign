package Tickets;

public abstract class Ticket {
    private String ticketName;
    private String payerName;
    private Double amount;

    public Ticket(String ticketName, String payerName, Double amount) {
        this.ticketName = ticketName;
        this.payerName = payerName;
        this.amount = amount;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "A " + ticketName + " of " + amount + " paid by " + payerName;
    }
}

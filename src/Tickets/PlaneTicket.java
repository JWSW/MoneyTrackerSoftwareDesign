package Tickets;

public class PlaneTicket extends Ticket{
    public PlaneTicket(String payerName, Double amount) {
        super("planeticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.evenTicketSplit();
        if (ticketSplit.isEven){

        }
    }
}

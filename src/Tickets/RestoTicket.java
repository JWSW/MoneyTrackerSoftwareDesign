package Tickets;

public class RestoTicket extends Ticket{
    public RestoTicket(String payerName, Double amount) {
        super("restaurant ticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.evenTicketSplit();
        if (ticketSplit.isEven){

        }
    }
}

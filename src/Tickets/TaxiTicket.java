package Tickets;

public class TaxiTicket extends Ticket{

    public TaxiTicket(String payerName, Double amount) {
        super("taxi ticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.evenTicketSplit();
        if (ticketSplit.isEven){

        }
    }

}

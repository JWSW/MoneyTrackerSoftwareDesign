package TicketFactories;

import Tickets.Ticket;
import Tickets.*;

public class OtherTicketFactory implements TicketFactory{
    @Override
    public Ticket addTicket(String payerName, Double amount) {
        return null;
    }

    @Override
    public Ticket addOther(String ticketName, String payerName, Double amount) {
        return new OtherTicket(ticketName, payerName, amount);
    }

}

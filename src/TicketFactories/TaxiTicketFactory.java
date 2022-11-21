package TicketFactories;

import Tickets.Ticket;

public class TaxiTicketFactory implements TicketFactory{
    @Override
    public Ticket addTicket(String payerName, Double amount) {
        return null;
    }

    @Override
    public Ticket addOther(String ticketName, String payerName, Double amount) {
        return null;
    }
}

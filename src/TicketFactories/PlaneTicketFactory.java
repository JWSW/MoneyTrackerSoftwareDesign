package TicketFactories;

import Tickets.PlaneTicket;
import Tickets.Ticket;

public class PlaneTicketFactory implements TicketFactory{
    @Override
    public Ticket addTicket(String payerName, Double amount) {
        return new PlaneTicket(payerName, amount);
    }

    @Override
    public Ticket addOther(String ticketName, String payerName, Double amount) {
        return null;
    }
}

package TicketFactories;

import Tickets.Ticket;

public interface TicketFactory {
    Ticket addTicket(String payerName, Double amount);
    Ticket addOther(String ticketName, String payerName, Double amount, boolean isEven);

}

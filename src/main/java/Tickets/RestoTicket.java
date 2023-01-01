package Tickets;

import Databases.DataPersons;
import Databases.RegisterPerson;

import java.util.Objects;

public class RestoTicket extends Ticket{

    public RestoTicket(String payerName, Double amount) {
        super("restaurant ticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.unevenTicketSplit();
    }
}

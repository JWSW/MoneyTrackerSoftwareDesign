package Tickets;

import Databases.DataPersons;
import Databases.RegisterPerson;

import java.text.DecimalFormat;
import java.util.Objects;

public class TaxiTicket extends Ticket{

    public TaxiTicket(String payerName, Double amount) {
        super("taxi ticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.evenTicketSplit(payerName, amount);
    }
}

package Tickets;

import Databases.DataPersons;
import Databases.RegisterPerson;

import java.text.DecimalFormat;
import java.util.Objects;

public class PlaneTicket extends Ticket{
    private DataPersons dbPerson = RegisterPerson.getInstance();
    public PlaneTicket(String payerName, Double amount) {
        super("planeticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.evenTicketSplit(payerName, amount);
    }
}

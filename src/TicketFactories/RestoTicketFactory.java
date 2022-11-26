package TicketFactories;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import Tickets.PlaneTicket;
import Tickets.RestoTicket;
import Tickets.Ticket;

public class RestoTicketFactory implements TicketFactory{
    private DataPersons dataPersons = RegisterPerson.getInstance();
    private DataTickets dataTickets = RegisterTickets.getInstance();
    @Override
    public Ticket addTicket(String payerName, Double amount) {
        if(!dataPersons.getPersonList().containsKey(payerName)){
            Person person = new Person(payerName);
            dataPersons.addPerson(person);
        }
        Ticket ticket = new RestoTicket(payerName,amount);
        dataTickets.addTicket(ticket);
        return ticket;
    }

    @Override
    public Ticket addOther(String ticketName, String payerName, Double amount) {
        return null;
    }
}

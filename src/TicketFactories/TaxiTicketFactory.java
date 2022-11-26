package TicketFactories;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import Tickets.PlaneTicket;
import Tickets.Ticket;

public class TaxiTicketFactory implements TicketFactory{
    private DataPersons dataPersons = RegisterPerson.getInstance();
    private DataTickets dataTickets = RegisterTickets.getInstance();
    @Override
    public Ticket addTicket(String payerName, Double amount) {
        if(!dataPersons.getPersonList().containsKey(payerName)){
            Person person = new Person(payerName);
            dataPersons.addPerson(person);
        }
        Ticket ticket = new PlaneTicket(payerName,amount);
        dataTickets.addTicket(ticket);
        return ticket;
    }

    @Override
    public Ticket addOther(String ticketName, String payerName, Double amount) {
        return null;
    }
}

package TicketFactories;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import Tickets.Ticket;
import Tickets.*;

public class OtherTicketFactory implements TicketFactory{
    private DataPersons dataPersons = RegisterPerson.getInstance();
    private DataTickets dataTickets = RegisterTickets.getInstance();
    @Override
    public Ticket addTicket(String payerName, Double amount) {
        return null;
    }

    @Override
    public Ticket addOther(String ticketName, String payerName, Double amount, boolean isEven) {
        if(!dataPersons.getPersonList().containsKey(payerName)){
            Person person = new Person(payerName);
            dataPersons.addPerson(person);
        }
        System.out.println("Een ticket type: " + ticketName);
        Ticket ticket = new OtherTicket(ticketName, payerName,amount, isEven);
        dataTickets.addTicket(ticket);
        return ticket;
    }

}

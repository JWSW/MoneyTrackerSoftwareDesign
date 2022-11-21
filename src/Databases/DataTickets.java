package Databases;

import PersonData.Person;
import Tickets.Ticket;

public abstract class DataTickets {
    public DataTickets(){}
    public abstract void addTicket(Ticket ticket);
    public abstract Ticket getTicket(Person person);


}

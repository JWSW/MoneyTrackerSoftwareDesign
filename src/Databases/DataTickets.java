package Databases;

import PersonData.Person;
import Tickets.Ticket;
import observers.Observer;

public abstract class DataTickets {
    public DataTickets(){}
    public abstract void addTicket(Ticket ticket);
    public abstract Ticket getTicket(String name);

    public abstract void addObserver(Observer observer);
}

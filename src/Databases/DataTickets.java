package Databases;

import PersonData.Person;
import Tickets.Ticket;
import observers.Observer;

import java.util.HashMap;

public abstract class DataTickets {
    public DataTickets(){}
    public abstract void addTicket(Ticket ticket);
    public abstract HashMap<String, HashMap<String,Double>> getTicketList();
    public abstract Ticket getTicket(String personName, String ticketName);
    public abstract void removeTicket(String personName, String ticketName);

    public abstract void addObserver(Observer observer);
}

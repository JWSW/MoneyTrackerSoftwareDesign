package Databases;

import PersonData.Person;
import Tickets.OtherTicket;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.HashMap;

public class RegisterTickets extends DataTickets{
    private static RegisterTickets uniqueInstance;
    private HashMap<String,HashMap<String,Double>> db;
    private ArrayList<Ticket> ticketList;

    private RegisterTickets() {
        this.db = new HashMap<String, HashMap<String,Double>>() {
        };
    }

    @Override
    public void addTicket(Ticket ticket) {
        HashMap<String,Double> tmp = new HashMap<String,Double>();
        tmp.put(ticket.getTicketName(),ticket.getAmount());
        db.put(ticket.getPayerName(),tmp);
    }

    public static DataTickets getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new RegisterTickets();
        }
        return uniqueInstance;
    }

    @Override
    public Ticket getTicket(Person person) {
        Double getal = 0.0;
        for(double i:db.get(person.getName()).values()) {
            getal = i;
        }
        Ticket ticket = new OtherTicket(db.get(person.getName()).keySet().toString(),person.getName(),getal);
        return ticket;
    }
}

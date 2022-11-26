package Databases;

import PersonData.Person;
import Tickets.OtherTicket;
import Tickets.Ticket;
import observers.Observer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisterTickets extends DataTickets{
    private static RegisterTickets uniqueInstance;
    private HashMap<String,HashMap<String,Double>> db;
    private ArrayList<Ticket> ticketList;
    private ArrayList<Observer> observerList = new ArrayList<>();

    private RegisterTickets() {
        this.db = new HashMap<String, HashMap<String,Double>>() {
        };
    }

    @Override
    public void addTicket(Ticket ticket) {
        HashMap<String,Double> tmp = new HashMap<String,Double>();
        tmp.put(ticket.getTicketName(),ticket.getAmount());
        db.put(ticket.getPayerName(),tmp);
        for (Observer o: observerList){
            o.updateTicket();
        }
    }

    public static DataTickets getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new RegisterTickets();
        }
        return uniqueInstance;
    }
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public Ticket getTicket(String name) {
        /*
        #G
         */
        Double getal = 0.0;
        for(double i:db.get(name).values()) {
            getal = i;
        }
        String ticketName = null;
        for(String i:db.get(name).keySet()) {
            ticketName = i;
        }
        Ticket ticket = new OtherTicket(ticketName,name,getal, true);
        return ticket;
    }
}

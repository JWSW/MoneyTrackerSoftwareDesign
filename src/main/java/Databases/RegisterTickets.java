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
        if(db.containsKey(ticket.getPayerName())){
            db.get(ticket.getPayerName()).put(ticket.getTicketName(), ticket.getAmount());
        }else{
            db.put(ticket.getPayerName(), tmp);
        }
//        db.put(ticket.getPayerName(),tmp);
        for (Observer o: observerList){
            o.updateTicket();
        }
    }

    @Override
    public HashMap<String, HashMap<String, Double>> getTicketList() {
        return db;
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
    public Ticket getTicket(String personName, String ticketName) {
        /*
        #Geeft de ticket terug van de gegeven persoon.
         */
        Double getal = 0.0;
        Ticket ticket;
        if(db.get(personName).size()<2){
            for(double i:db.get(personName).values()) {
                getal = i;
            }
            String ticketName2 = null;
            for(String i:db.get(personName).keySet()) {
                ticketName2 = i;
            }
            ticket = new OtherTicket(ticketName2,personName,getal, false);
        }else{
            getal = db.get(personName).get(ticketName);
            ticket = new OtherTicket(ticketName,personName,getal, false);
        }

        return ticket;
    }

    @Override
    public void removeTicket(String personName, String ticketName) {
        if(db.get(personName).size()<2){
            db.remove(personName);
        }else{
            db.remove(personName).remove(ticketName);
        }
        System.out.println("Ticket got removed.");
    }
}

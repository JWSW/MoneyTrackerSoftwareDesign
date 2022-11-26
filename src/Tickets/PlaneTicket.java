package Tickets;

import Databases.DataPersons;
import Databases.RegisterPerson;

import java.util.Objects;

public class PlaneTicket extends Ticket{
    private DataPersons dbPerson = RegisterPerson.getInstance();
    public PlaneTicket(String payerName, Double amount) {
        super("planeticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.evenTicketSplit();
        if (ticketSplit.isEven){
            for(String i:dbPerson.getPersonList().keySet()){
                if(Objects.equals(i, payerName)){
                    dbPerson.changeValue(i,(-amount+(amount/dbPerson.getPersonList().keySet().size())));
                }else{
                    dbPerson.changeValue(i, amount / dbPerson.getPersonList().keySet().size());
                }
            }
        }
    }
}

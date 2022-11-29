package Tickets;

import Databases.DataPersons;
import Databases.RegisterPerson;

import java.text.DecimalFormat;
import java.util.Objects;

public class PlaneTicket extends Ticket{
    private DataPersons dbPerson = RegisterPerson.getInstance();
    public PlaneTicket(String payerName, Double amount) {
        super("planeticket", payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        ticketSplit.evenTicketSplit();
        if (ticketSplit.isEven){
            for(String i:dbPerson.getPersonList().keySet()){
                if(!Objects.equals(i, payerName)){
                    DecimalFormat f = new DecimalFormat("##.00");
                    dbPerson.changeValue(i,payerName, amount / dbPerson.getPersonList().keySet().size());
                }
//                else{
//                    dbPerson.changeValue(i, payerName, (-amount+(amount/dbPerson.getPersonList().keySet().size())));
//                }
            }
        }
    }
}

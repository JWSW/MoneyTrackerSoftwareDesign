package Tickets;

import Databases.DataPersons;
import Databases.RegisterPerson;

import java.util.Objects;

public class OtherTicket extends Ticket{
    private DataPersons dbPerson = RegisterPerson.getInstance();
    public OtherTicket(String ticketName, String payerName, Double amount, boolean isEven) {
        super(ticketName, payerName, amount);
        TicketSplit ticketSplit = new TicketSplit();
        if (isEven){
            ticketSplit.evenTicketSplit();
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

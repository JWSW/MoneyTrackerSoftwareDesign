package Tickets;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;

import java.util.Objects;

class TicketSplit{
    private DataPersons dbPerson = RegisterPerson.getInstance();
    public boolean isEven;
    public void evenTicketSplit(String payerName, Double amount){
        isEven = true;
        for(String i:dbPerson.getPersonList().keySet()){
            if(!Objects.equals(i, payerName)){
                dbPerson.changeValue(i,payerName, (amount / dbPerson.getPersonList().keySet().size()));
            }
//                else{
//                    dbPerson.changeValue(i, payerName, (-amount+(amount/dbPerson.getPersonList().keySet().size())));
//                }
        }
    }
    public void unevenTicketSplit(){
        isEven = false;
    }
}
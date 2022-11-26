package Tickets;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;

import java.util.Objects;

class TicketSplit{
    public boolean isEven;
    public void evenTicketSplit(){
        isEven = true;
    }
    public void unevenTicketSplit(){
        isEven = false;
    }
}
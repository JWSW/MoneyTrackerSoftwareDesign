package controller;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import Tickets.Ticket;

public class RegistrationController implements Controller{
    private final DataPersons personData = RegisterPerson.getInstance();
    private final DataTickets ticketData = RegisterTickets.getInstance();

    public RegistrationController()
    {}

    @Override
    public void addTicket(Ticket ticket) {

    }

//    @Override
//    public void checkIn()
//    {
//        RegisterEntry entry = new RegisterEntry(true);
//        db.addEntry(e, entry);
//    }

//    @Override
//    public void checkOut()
//    {
//        RegisterEntry entry = new RegisterEntry(false);
//        db.addEntry(e, entry);
//    }
}

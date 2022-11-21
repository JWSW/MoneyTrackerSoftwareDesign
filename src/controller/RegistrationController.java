package controller;

import Databases.DataPersons;
import Tickets.Ticket;

public class RegistrationController implements Controller{
    private DataPersons db;

    public RegistrationController(DataPersons db)
    {
        this.db = db;
    }

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

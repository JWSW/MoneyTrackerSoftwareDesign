package controller;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import TicketFactories.TaxiTicketFactory;
import TicketFactories.TicketFactory;
import TicketFactories.TicketFactoryProvider;
import Tickets.Ticket;

import java.util.Objects;

public class RegistrationController implements Controller{
    private DataPersons dbPersons = RegisterPerson.getInstance();
    private DataTickets dbTickets = RegisterTickets.getInstance();
    TicketFactory taxiTicketFactory = TicketFactoryProvider.getTaxiTicketFactory();
    TicketFactory planeTicketFactory = TicketFactoryProvider.getPlaneTicketFactory();
    TicketFactory restoTicketFactory = TicketFactoryProvider.getRestoTicketFactory();
    TicketFactory otherTicketFactory = TicketFactoryProvider.getOtherTicketFactory();

    public RegistrationController()
    {

    }

    @Override
    public void addTicket(String ticketName, String payerName, Double amount, boolean isEven) { //The boolean is only for the otherTicketFactory, the other ones do not use this boolean
        if(Objects.equals(ticketName, "taxi")){
            taxiTicketFactory.addTicket(payerName,amount);
        }else if(Objects.equals(ticketName, "resto")){
            restoTicketFactory.addTicket(payerName,amount);
        }else if(Objects.equals(ticketName, "plane")){
            planeTicketFactory.addTicket(payerName,amount);
        }else{
            otherTicketFactory.addOther(ticketName, payerName, amount, isEven);
        }
    }

    @Override
    public void removeTicket(String personName, String ticketName) {

    }

    @Override
    public void addPerson(String name) {
        Person person = new Person(name);
        dbPersons.addPerson(person);
    }

    @Override
    public DataPersons getDBPerson() {
        return dbPersons;
    }

    @Override
    public void changeValue(String name, Double amount) {
        dbPersons.changeValue(name, amount);
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

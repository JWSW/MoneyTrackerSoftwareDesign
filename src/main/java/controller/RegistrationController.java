package controller;

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import TicketFactories.TicketFactory;
import TicketFactories.TicketFactoryProvider;

import java.util.Objects;

public class RegistrationController implements Controller{
    private DataPersons dbPersons = RegisterPerson.getInstance();
    private DataTickets dbTickets = RegisterTickets.getInstance();
    TicketFactory taxiTicketFactory = TicketFactoryProvider.getTaxiTicketFactory();
    TicketFactory planeTicketFactory = TicketFactoryProvider.getPlaneTicketFactory();
    TicketFactory restoTicketFactory = TicketFactoryProvider.getRestoTicketFactory();
    TicketFactory otherTicketFactory = TicketFactoryProvider.getOtherTicketFactory();

    public RegistrationController(DataPersons dbPersons, DataTickets dbTickets)
    {
        this.dbPersons = dbPersons;
        this.dbTickets = dbTickets;
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
        dbTickets.removeTicket(personName, ticketName);
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
    public DataTickets getDBTicket() {
        return dbTickets;
    }

    @Override
    public void changeValue(String name, String creditor, Double amount) {
        dbPersons.changeValue(name, creditor, amount);
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

package controller;

import Databases.DataPersons;
import Databases.DataTickets;
import PersonData.Person;
import Tickets.Ticket;

public interface Controller {
    void addTicket(String ticketName, String payerName, Double amount, boolean isEven);
    void removeTicket(String personName, String ticketName);
    void addPerson(String name);
    void removePerson(String name);
    DataPersons getDBPerson();

    DataTickets getDBTicket();

    void changeValue(String name, String creditor, Double amount);
}

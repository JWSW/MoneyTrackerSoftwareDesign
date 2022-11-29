package controller;

import Databases.DataPersons;
import PersonData.Person;
import Tickets.Ticket;

public interface Controller {
    void addTicket(String ticketName, String payerName, Double amount, boolean isEven);
    void removeTicket(String personName, String ticketName);
    void addPerson(String name);
    DataPersons getDBPerson();

    void changeValue(String name, String creditor, Double amount);
}

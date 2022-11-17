package Databases;

import PersonData.Person;

public abstract class DataTickets {
    public DataTickets(){}

    public abstract void addPerson(Person person);
    public abstract Integer getPerson(Person person);

}

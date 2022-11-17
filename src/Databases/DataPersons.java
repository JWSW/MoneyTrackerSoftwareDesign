package Databases;

import PersonData.Person;

public abstract class DataPersons {

    public DataPersons(){}

    public abstract void addPerson(Person person);
    public abstract Integer getPerson(Person person);
}

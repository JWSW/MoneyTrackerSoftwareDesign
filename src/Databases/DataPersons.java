package Databases;

import PersonData.Person;

import java.util.ArrayList;

public abstract class DataPersons {

    public DataPersons(){}

    public abstract void addPerson(Person person);
    public abstract Person getPerson(String personName);

    public abstract ArrayList<Person> getPersonList();
}

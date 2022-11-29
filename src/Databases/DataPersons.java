package Databases;

import PersonData.Person;
import observers.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DataPersons {

    public DataPersons(){}

    public abstract void addPerson(Person person);
    public abstract Person getPerson(String personName);

    public abstract HashMap<String,HashMap<String,Double>> getPersonList();
    public abstract void addObserver(Observer observer);

    public abstract void changeValue(String name, String eiserName, Double value);
}

package Databases;

import PersonData.Person;
import PersonData.PersonNull;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabasePerson extends DataPersons{
    private static DatabasePerson uniqueInstance;
    private final HashMap<String, Double> db;

    private DatabasePerson() {
        this.db = new HashMap<String, Double>() {
        };
    }
    public static DataPersons getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new DatabasePerson();
        }
        return uniqueInstance;
    }

    @Override
    public void addPerson(Person person) {
        db.put(person.getName(),person.getSchuld());
    }

    @Override
    public ArrayList<Person> getPersonList() {
        return null;
    }

    @Override
    public Person getPerson(String personName) {
        Person person = new Person();
        if(db.get(personName)!=null){
            person.setName(personName);
            person.setSchuld(db.get(personName));
        }
        return person;
    }
}

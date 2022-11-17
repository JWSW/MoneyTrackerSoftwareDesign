package Databases;

import PersonData.Person;
import PersonData.PersonNull;

import java.util.HashMap;

public class DatabasePerson extends DataPersons{
    private static DatabasePerson uniqueInstance;
    private final HashMap<String, Integer> db;

    private DatabasePerson() {
        this.db = new HashMap<String, Integer>() {
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

    }

    @Override
    public Integer getPerson(Person person) {
        PersonNull nullPerson = new PersonNull();
        return this.db.getOrDefault(person,nullPerson.getSchuld());
    }
}

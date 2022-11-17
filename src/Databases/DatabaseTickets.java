package Databases;

import PersonData.Person;

import java.util.HashMap;

public class DatabaseTickets extends DataTickets{
    private static DatabaseTickets uniqueInstance;
    private final HashMap<String, Integer> db;

    private DatabaseTickets() {
        this.db = new HashMap<String, Integer>() {
        };
    }
    public static DataTickets getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new DatabaseTickets();
        }
        return uniqueInstance;
    }
    @Override
    public void addPerson(Person person) {

    }

    @Override
    public Integer getPerson(Person person) {
        return null;
    }
}

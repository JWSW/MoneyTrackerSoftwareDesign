package Databases;

import PersonData.Person;

import java.util.HashMap;

public class RegisterTickets extends DataTickets{
    private static RegisterTickets uniqueInstance;
    private final HashMap<String, Integer> db;

    private RegisterTickets() {
        this.db = new HashMap<String, Integer>() {
        };
    }
    public static DataTickets getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new RegisterTickets();
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

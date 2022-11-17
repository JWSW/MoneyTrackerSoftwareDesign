package Databases;

import PersonData.Person;

import java.util.HashMap;

public class RegisterDT extends DataTickets{
    private static RegisterDT uniqueInstance;
    private final HashMap<String, Integer> db;

    private RegisterDT() {
        this.db = new HashMap<String, Integer>() {
        };
    }
    public static DataTickets getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new RegisterDT();
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

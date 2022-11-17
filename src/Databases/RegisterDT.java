package Databases;

import PersonData.Person;

import java.util.HashMap;

public class RegisterDT extends DataTickets{
    private static RegisterDP uniqueInstance;
    private final HashMap<String, Integer> db;

    public RegisterDT() {
        this.db = new HashMap<>() {
        };
    }
    public static DataPersons getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new RegisterDP();
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

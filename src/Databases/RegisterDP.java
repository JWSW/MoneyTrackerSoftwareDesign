package Databases;

import PersonData.Person;
import PersonData.PersonNull;

import java.util.HashMap;

public class RegisterDP extends DataPersons{
    private static RegisterDP uniqueInstance;
    private final HashMap<String, Integer> db;

    private RegisterDP() {
        this.db = new HashMap<String, Integer>() {
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
        PersonNull nullPerson = new PersonNull();
        return this.db.getOrDefault(person,nullPerson.getSchuld());
    }
}

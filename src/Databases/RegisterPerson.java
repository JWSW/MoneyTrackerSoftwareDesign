package Databases;

import PersonData.Person;
import observers.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class RegisterPerson extends DataPersons{
    private static RegisterPerson uniqueInstance;
    private final HashMap<String, Double> db;
    private ArrayList<Observer> observerList = new ArrayList<>();

    private RegisterPerson() {
        this.db = new HashMap<String, Double>() {
        };
    }
    public static DataPersons getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new RegisterPerson();
        }
        return uniqueInstance;
    }

    @Override
    public void addPerson(Person person) {
        db.put(person.getName(),person.getSchuld());
        System.out.println(db.keySet());
    }

    @Override
    public HashMap<String, Double> getPersonList() {
        return db;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public Person getPerson(String personName) {
        Person person = new Person();
        if(db.containsKey(personName)){
            person.setName(personName);
            person.setSchuld(db.get(personName));
        }
        return person;
    }
}

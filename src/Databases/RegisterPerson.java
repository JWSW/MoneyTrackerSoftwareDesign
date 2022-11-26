package Databases;

import PersonData.Person;
import observers.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class RegisterPerson extends DataPersons{
    private static RegisterPerson uniqueInstance;
    private HashMap<String, Double> db;
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
        db.put(person.getName(), person.getSchuld());
        for (Observer o: observerList){
            o.updatePerson();
        }
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
    public void changeValue(String name, Double value) {
        if(db.containsKey(name)){
            System.out.println(name + " komt hier>\n" + db.get(name) + " wordt normaal gezien " + (db.get(name)+value));
            db.replace(name,db.get(name),(db.get(name)+value));
        }
    }

    @Override
    public Person getPerson(String personName) {
        Person person = new Person(personName);
        if(db.containsKey(personName)){
            person.setName(personName);
            person.setSchuld(db.get(personName));
        }
        return person;
    }


}

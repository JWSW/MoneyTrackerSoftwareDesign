package Databases;

import PersonData.Person;
import observers.Observer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class RegisterPerson extends DataPersons{
    private static RegisterPerson uniqueInstance;
    private HashMap<String, HashMap<String,Double>> db;
    private ArrayList<Observer> observerList = new ArrayList<>();

    private RegisterPerson() {
        this.db = new HashMap<String, HashMap<String,Double>>() {
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
        db.put(person.getName(), person.getSchuldList());
        for (Observer o: observerList){
            o.updatePerson(person);
        }
    }

    @Override
    public HashMap<String, HashMap<String,Double>> getPersonList() {
        return db;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void changeValue(String name, String eiserName, Double value) {
        if(db.containsKey(name)) {
            if (db.get(name).containsKey(eiserName)) {
                db.get(name).replace(eiserName, db.get(name).get(eiserName), (double) (Math.round((db.get(name).get(eiserName) + value)*100))/100);
            } else {
                db.get(name).put(eiserName, (double) (Math.round(value*100))/100);
            }
        }
        if(db.get(eiserName).containsKey(name)){
            Double verschil = (double)(Math.round(100*Math.abs(db.get(name).get(eiserName)-db.get(eiserName).get(name))))/100;
            if(db.get(name).get(eiserName)<db.get(eiserName).get(name)){
                db.get(eiserName).replace(name,db.get(eiserName).get(name), verschil);
                db.get(name).remove(eiserName);
            }else{
                db.get(name).replace(eiserName,db.get(name).get(eiserName), verschil);
                db.get(eiserName).remove(name);
            }
        }
    }

    @Override
    public Person getPerson(String personName) {
        Person person = new Person(personName);
        if(db.containsKey(personName)){
            person.setName(personName);
            person.setSchuldList(db.get(personName));
        }
        return person;
    }


}

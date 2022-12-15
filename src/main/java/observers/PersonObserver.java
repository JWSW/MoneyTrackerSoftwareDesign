package observers;

import PersonData.Person;

public class PersonObserver implements Observer {
    @Override
    public void updatePerson(Person person) {
        System.out.println("Person " + person.getName() + " got added.");
    }

    @Override
    public void updateTicket() {
    }
}

package observers;

import PersonData.Person;

public interface Observer {
    void updatePerson(Person person);
    void updateTicket();
}

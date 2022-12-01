package observers;

import PersonData.Person;

public class TicketObserver implements Observer{
    @Override
    public void updatePerson(Person person) {
    }

    @Override
    public void updateTicket() {
        System.out.println("Ticket got added.");
    }
}

package observers;

public class PersonObserver implements Observer {
    @Override
    public void updatePerson() {
        System.out.println("Person got added.");
    }

    @Override
    public void updateTicket() {
    }
}

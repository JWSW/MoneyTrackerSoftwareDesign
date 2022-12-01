package observers;

public class TicketObserver implements Observer{
    @Override
    public void updatePerson() {
    }

    @Override
    public void updateTicket() {
        System.out.println("Ticket got added.");
    }
}

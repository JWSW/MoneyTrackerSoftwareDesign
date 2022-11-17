package observers;

public class TicketObserver implements Observer{
    @Override
    public void update() {
        System.out.println("Ticket got added.");
    }
}

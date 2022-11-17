package observers;

public class PersonObserver implements Observer {
    @Override
    public void update() {
        System.out.println("Person got added.");
    }
}

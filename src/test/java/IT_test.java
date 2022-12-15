import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import TicketFactories.TicketFactory;
import TicketFactories.TicketFactoryProvider;
import controller.RegistrationController;
import org.junit.Before;

public class IT_test {
    DataPersons dbPerson;
    DataTickets dbTicket;
    RegistrationController controller;

    @Before
    public void initialize(){
        dbPerson = RegisterPerson.getInstance();
        dbTicket = RegisterTickets.getInstance();
        controller = new RegistrationController();
        Person person1 = new Person("Bob");
    }
}

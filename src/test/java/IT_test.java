import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import TicketFactories.PlaneTicketFactory;
import TicketFactories.TaxiTicketFactory;
import TicketFactories.TicketFactory;
import TicketFactories.TicketFactoryProvider;
import controller.RegistrationController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;

public class IT_test {
    DataPersons dbPerson;
    DataTickets dbTicket;
    RegistrationController controller;

    Person testPerson1;
    Person testPerson2;
    Person testPerson3;
    Person testPerson4;
    TicketFactory factory;

    @Before
    public void initialize(){
        dbPerson = RegisterPerson.getInstance();
        dbTicket = RegisterTickets.getInstance();
        controller = new RegistrationController();
        factory = new TaxiTicketFactory();
        testPerson1 = new Person("Bob");
        testPerson2 = new Person("Marie");
        testPerson3 = new Person("Jef");
        testPerson4 = new Person("An");
    }

    @Test
    public void t_addTickets(){
        dbPerson.addPerson(testPerson1);
        dbPerson.addPerson(testPerson2);
        dbPerson.addPerson(testPerson3);
        dbPerson.addPerson(testPerson4);

        factory.addTicket(testPerson1.getName(), 20.0);
        HashMap<String,HashMap<String, Double>> personList = dbPerson.getPersonList();
        double debt = personList.get(testPerson2.getName()).get(testPerson1.getName());
        assertEquals(debt, 5.0, 0);

        factory = new PlaneTicketFactory();
        factory.addTicket(testPerson2.getName(), 400.0);
        personList = dbPerson.getPersonList();
        debt = personList.get(testPerson1.getName()).get(testPerson2.getName());

        assertEquals(debt, 95.0, 0);
    }

}

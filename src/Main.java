/*
Credits to Jens de Hoog.
 */

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import TicketFactories.TaxiTicketFactory;
import TicketFactories.TicketFactory;
import TicketFactories.TicketFactoryProvider;
import controller.RegistrationController;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main()
    {

    }

    public void run()
    {
        // Replace with your own objects
        DataPersons dbPerson = RegisterPerson.getInstance();
        DataTickets dbTicket = RegisterTickets.getInstance();
        RegistrationController controller= new RegistrationController();
        TicketFactory TaxiTicketFactory = TicketFactoryProvider.getTaxiTicketFactory();
        TicketFactory PlaneTicketFactory = TicketFactoryProvider.getPlaneTicketFactory();
        TicketFactory RestoTicketFactory = TicketFactoryProvider.getRestoTicketFactory();
        TicketFactory OtherTicketFactory = TicketFactoryProvider.getOtherTicketFactory();
        GUI view = new GUI();

        dbPerson.addObserver(view);
        dbTicket.addObserver(view);

        Person person1 = new Person("Bob");
        Person person2 = new Person("Marie");
        Person person3 = new Person("Jef");
        Person person4 = new Person("An");

        dbPerson.addPerson(person1);
        dbPerson.addPerson(person2);
        dbPerson.addPerson(person3);
        dbPerson.addPerson(person4);

        TaxiTicketFactory.addTicket("Bob", 40.0);
        System.out.println(dbPerson.getPerson(person1.getName()));
        System.out.println(dbPerson.getPerson(person2.getName()));
        System.out.println(dbPerson.getPerson(person3.getName()));
        System.out.println(dbPerson.getPerson(person4.getName()));

        PlaneTicketFactory.addTicket("Marie", 120.0);
        System.out.println(dbPerson.getPerson(person1.getName()));
        System.out.println(dbPerson.getPerson(person2.getName()));
        System.out.println(dbPerson.getPerson(person3.getName()));
        System.out.println(dbPerson.getPerson(person4.getName()));
        System.out.println(dbTicket.getTicket("Marie"));

        view.initialize();
        //register.IetsDatIetsToevoegd();

        sleep(3000);
    }

    public void sleep(int millis)
    {
        try
        {
            System.out.print("Sleeping [    ]\r");
            Thread.sleep(millis);
            System.out.println("Sleeping [ OK ]");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

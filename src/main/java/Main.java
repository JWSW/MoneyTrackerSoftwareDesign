/*
Credits to Abdelkarim Sallami.
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
        new RegistrationController();
        GUI view = new GUI();

        dbPerson.addObserver(view);
        dbTicket.addObserver(view);

    }

}

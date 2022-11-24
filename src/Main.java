/*
Credits to Jens de Hoog.
 */

import Databases.DataPersons;
import Databases.DataTickets;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import controller.RegistrationController;
import observers.PersonObserver;

import javax.xml.crypto.Data;

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
        DataPersons personRegister = RegisterPerson.getInstance();
        DataTickets ticketRegister = RegisterTickets.getInstance();
        RegistrationController register= new RegistrationController();

        personRegister.addObserver(new PersonObserver());
        GUI view = new GUI();
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

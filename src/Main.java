/*
Credits to Jens de Hoog.
 */

import Databases.DataPersons;
import Databases.RegisterPerson;
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
        DataPersons timedb = RegisterPerson.getInstance();
        RegistrationController register= new RegistrationController(timedb);

        GUI view = new GUI();
        view.initialize();
        timedb.addObserver(view);
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

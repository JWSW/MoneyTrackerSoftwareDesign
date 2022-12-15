/*
Credits to Jens de Hoog
 */

import javax.swing.*;

import Databases.RegisterPerson;
import Databases.RegisterTickets;
import controller.RegistrationController;
import observers.Observer;
//import observers.PrintEntry;
//import observers.PrintUpdate;
import observers.PersonObserver;
import observers.TicketObserver;
import panels.ListPanel;
import panels.RegistrationButtonPanel;
//import register_entry.RegisterEntry;


public class GUI extends JFrame implements Observer{

        // Get your controller in this private field
        RegistrationController controller = new RegistrationController();

        ListPanel panel;
        RegistrationButtonPanel panels;

        public GUI()
        {
            super("Moneytracker");
        }

        public void initialize()
        {
            panels = new RegistrationButtonPanel();
        }



    @Override
    public void updatePerson() {
        PersonObserver personObserver  = new PersonObserver();
        personObserver.updatePerson();
    }

    @Override
    public void

    updateTicket() {
        TicketObserver ticketObserver = new TicketObserver();
        ticketObserver.updateTicket();
    }
}

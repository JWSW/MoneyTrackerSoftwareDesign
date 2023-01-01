/*
Credits to Jens de Hoog
 */

import javax.swing.*;

import PersonData.Person;
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

    RegistrationButtonPanel panels = new RegistrationButtonPanel();

        public GUI()
        {
            super("Moneytracker");
        }



    @Override
    public void updatePerson(Person person) {
        PersonObserver personObserver  = new PersonObserver();
        personObserver.updatePerson(person);
        panels.addPerson(person);
    }

    @Override
    public void

    updateTicket() {
        TicketObserver ticketObserver = new TicketObserver();
        ticketObserver.updateTicket();
    }
}

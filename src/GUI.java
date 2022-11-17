/*
Credits to Jens de Hoog
 */

import javax.swing.*;
import java.awt.*;

import observers.Observer;
//import observers.PrintEntry;
//import observers.PrintUpdate;
import observers.PersonObserver;
import observers.TicketObserver;
import panels.ListPanel;
import panels.RegistrationButtonPanel;
//import register_entry.RegisterEntry;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class GUI extends JFrame implements Observer{

        // Get your controller in this private field
//    RegistrationController registrationController;
        ListPanel panel;
        RegistrationButtonPanel buttons;

        public GUI()
        {
            super("Registration");
        }

        public void initialize()
        {
            this.setSize(500, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GridBagLayout layout = new GridBagLayout();
            this.setLayout(layout);

            // Pass the controller to the ButtonPanel
            buttons = new RegistrationButtonPanel();
            panel = new ListPanel();

            this.add(panel);
            this.add(buttons);
            this.setVisible(true);
        }

    @Override
    public void update() {
        PersonObserver personObserver  = new PersonObserver();
        TicketObserver ticketObserver = new TicketObserver();
        personObserver.update();
        ticketObserver.update();
    }

//        @Override
//        public void update(RegisterEntry re) {
//            PrintEntry printEntry = new PrintEntry();
//            PrintUpdate printUpdate = new PrintUpdate();
//            printUpdate.update(re);
//            printEntry.update(re);
//        }
}

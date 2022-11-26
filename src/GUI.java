/*
Credits to Jens de Hoog
 */

import javax.swing.*;

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
//            this.setSize(500, 300);
//            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//            GroupLayout layout = new GroupLayout();
//            this.setLayout(layout);
//            JPanel panel = new JPanel();
//            this.add(panel);
//            this.setVisible(true);
//
//            JLabel label = new JLabel("Wat wil je doen?");
//            label.setBounds(200, 5, 100, 25);
//
//            JButton addTicket = new JButton("Add ticket");
//            addTicket.setBounds(80, 30, 100, 25);
//
//            JButton addPerson = new JButton("Add person");
//            addPerson.setBounds(185, 30, 100, 25);
//
//            JButton seeDepts = new JButton("See depts");
//            seeDepts.setBounds(290, 30, 100, 25);
//
//            panel.add(label);
//            panel.add(addTicket);
//            panel.add(addPerson);
//            panel.add(seeDepts);


//             Pass the controller to the ButtonPanel
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

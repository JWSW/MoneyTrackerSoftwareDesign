/*
Credits to Jens de Hoog
 */

package panels;


import controller.RegistrationController;

import javax.swing.*;

public class RegistrationButtonPanel extends JPanel {

    private JButton addTicket;
    private JButton addPerson;

    // Get your controller in this private field
    private RegistrationController controller;

    // For now, just make a new employee in this class via your factory.
    // You can change this later on to a more unified way

    // Get your controller in this class via the constructor
    public RegistrationButtonPanel()
    {
        JLabel label = new JLabel("Chose an action");
        this.addTicket = new JButton("Add ticket");
        this.addPerson = new JButton("Add person");

        // Create your temporary employee here
//        this.employee = your factory creating an employee
        addTicketButtonActionListener();
        addPersonButtonActionListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(label);
        this.add(this.addTicket);
        this.add(this.addPerson);
    }

    public void addTicketButtonActionListener()
    {
        this.addTicket.addActionListener(listener ->
        {
            // Insert here your controller functionality
//            controller.addTicket();
        });
    }

    public void addPersonButtonActionListener()
    {
        this.addPerson.addActionListener(listener ->
        {
            // Insert here your controller functionality
        });
    }





}

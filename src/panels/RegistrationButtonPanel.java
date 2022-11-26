/*
Credits to Jens de Hoog
 */

package panels;


import controller.RegistrationController;

import javax.swing.*;
import java.util.Objects;

public class RegistrationButtonPanel extends JPanel {

    private JButton addTicket;
    private JButton addPerson;
    private JButton seeDepts;
    private boolean isEven;
    private boolean isUpdated;
    private int index = 0;
    private Double sum = 0.0;
    private JFrame frame1 = new JFrame("Moneykeeper");

    // Get your controller in this private field
    private RegistrationController controller = new RegistrationController();

    // For now, just make a new employee in this class via your factory.
    // You can change this later on to a more unified way

    // Get your controller in this class via the constructor
    public RegistrationButtonPanel()
    {
        frame1.setSize(500, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame1.add(panel);
        frame1.setVisible(true);

        JLabel label = new JLabel("Chose an action");
        label.setBounds(200, 5, 100, 40);

        addTicket = new JButton("Add ticket");
        addTicket.setBounds(80, 45, 100, 35);

        addPerson = new JButton("Add person");
        addPerson.setBounds(185, 45, 100, 35);

        seeDepts = new JButton("See depts");
        seeDepts.setBounds(290, 45, 100, 35);


        // Create your temporary employee here
//        this.employee = your factory creating an employee
        addTicketButtonActionListener(panel);
        addPersonButtonActionListener(panel);
        addseeDeptButtonActionListener(panel);

//        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        panel.add(label);
        panel.add(addTicket);
        panel.add(addPerson);
        panel.add(seeDepts);
    }

    private void addseeDeptButtonActionListener(JPanel panel1) {
        seeDepts.addActionListener(listener ->
        {
            JPanel deptsPanel = new JPanel();
            frame1.remove(panel1);
            frame1.add(deptsPanel);
            frame1.setVisible(true);

            JLabel headLabel = new JLabel("Here you see the depts per person.");
            headLabel.setBounds(100, 5, 200, 20);
            deptsPanel.add(headLabel);
            JLabel remarkLabel = new JLabel("(negative means, has to receive money.)");
            remarkLabel.setBounds(100, 25, 240, 20);
            deptsPanel.add(remarkLabel);

            int index = 50;

            for(String name:controller.getDBPerson().getPersonList().keySet()){
                JLabel deptLabel = new JLabel(controller.getDBPerson().getPerson(name).toString());
                deptLabel.setBounds(100, index, 180, 20);
                deptsPanel.add(deptLabel);
                index+=20;
            }

            JButton back = new JButton("Back");
            back.setBounds(300, 180, 80, 25);
            deptsPanel.add(back);
            back.addActionListener(e ->
            {
                frame1.remove(deptsPanel);
                frame1.add(panel1);
                frame1.repaint();
            });
        });
    }

    public void addTicketButtonActionListener(JPanel panel1)
    {
        addTicket.addActionListener(listener ->
        {
            JPanel addTicketPanel = new JPanel();
            frame1.remove(panel1);
            frame1.add(addTicketPanel);
            frame1.setVisible(true);

            JLabel nameLabel = new JLabel("Chose the kind of ticket:");
            nameLabel.setBounds(160, 5, 180, 25);
            addTicketPanel.add(nameLabel);

            JButton taxiTicket = new JButton("Taxi ticket");
            taxiTicket.setBounds(80, 45, 140, 35);
            addTicketPanel.add(taxiTicket);
            ticketButtonActionListener("taxi",taxiTicket,addTicketPanel);

            JButton planeTicket = new JButton("Plane ticket");
            planeTicket.setBounds(225, 45, 140, 35);
            addTicketPanel.add(planeTicket);
            ticketButtonActionListener("plane",planeTicket,addTicketPanel);

            JButton restoTicket = new JButton("Restaurant ticket");
            restoTicket.setBounds(80, 85, 140, 35);
            addTicketPanel.add(restoTicket);
            ticketButtonActionListener("resto",restoTicket,addTicketPanel);

            JButton otherTicket = new JButton("Other ticket");
            otherTicket.setBounds(225, 85, 140, 35);
            addTicketPanel.add(otherTicket);
            ticketButtonActionListener("other",otherTicket,addTicketPanel);

            JButton back = new JButton("Back");
            back.setBounds(300, 180, 80, 25);
            addTicketPanel.add(back);
            back.addActionListener(e ->
            {
                frame1.remove(addTicketPanel);
                frame1.add(panel1);
                frame1.repaint();
            });
        });
    }

    public void addPersonButtonActionListener(JPanel panel1)
    {
        addPerson.addActionListener(listener ->
        {
            JPanel personPanel = new JPanel();
            frame1.remove(panel1);
            frame1.add(personPanel);
            frame1.setVisible(true);

            JLabel nameLabel = new JLabel("Give the name of the person");
            nameLabel.setBounds(100, 5, 180, 25);
            personPanel.add(nameLabel);

            JTextField personText = new JTextField();
            personText.setBounds(120, 35, 100, 25);
            personPanel.add(personText);

            JButton add = new JButton("Add person");
            add.setBounds(120, 60, 100, 25);
            personPanel.add(add);
            add.addActionListener(a ->
            {
                String name = personText.getText();
                controller.addPerson(name);
                if(!isUpdated){
                    JLabel feedback = new JLabel("Person got added.");
                    feedback.setBounds(100, 90, 140, 25);
                    personPanel.add(feedback);
                    personPanel.repaint();
                    isUpdated=true;
                }
            });
            JButton back = new JButton("Back");
            back.setBounds(300, 180, 80, 25);
            personPanel.add(back);
            back.addActionListener(a ->
            {
                frame1.remove(personPanel);
                frame1.add(panel1);
                frame1.repaint();
                isUpdated=false;
            });
        });
    }

    public void ticketButtonActionListener(String ticketName, JButton ticketButton, JPanel panel1){
        ticketButton.addActionListener(e ->
        {
            JPanel ticketPanel = new JPanel();
            frame1.remove(panel1);
            frame1.add(ticketPanel);
            frame1.setVisible(true);

            JLabel nameLabel = new JLabel("Give the name of the payer");
            nameLabel.setBounds(100, 5, 180, 25);
            ticketPanel.add(nameLabel);

            JTextField payerName = new JTextField();
            payerName.setBounds(120, 35, 100, 25);
            ticketPanel.add(payerName);

            JLabel amountLabel = new JLabel("Give the amount payed");
            amountLabel.setBounds(100, 65, 160, 25);
            ticketPanel.add(amountLabel);

            JTextField amount = new JTextField();
            amount.setBounds(120, 95, 100, 25);
            ticketPanel.add(amount);

            JTextField ticketTextName = new JTextField();
            JButton evenSplit = new JButton("Evenly split");
            if(Objects.equals(ticketName, "other")){
                JLabel label1 = new JLabel("Give the kind of ticket");
                label1.setBounds(290, 5, 160, 25);
                ticketPanel.add(label1);
                JLabel label2 = new JLabel("(ex.: plane ticket, taxi ticket,...)");
                label2.setBounds(270, 30, 180, 25);
                ticketPanel.add(label2);

                ticketTextName.setBounds(290, 65, 100, 25);
                ticketPanel.add(ticketTextName);

                evenSplit.setBounds(290, 95, 100, 25);
                ticketPanel.add(evenSplit);
                evenSplit.addActionListener(a -> {
                    isEven = true;
                });
            }

            JButton add = new JButton("Add ticket");
            add.setBounds(120, 125, 100, 25);
            ticketPanel.add(add);
            JLabel feedback = new JLabel("Ticket got added.");
            add.addActionListener(a ->
            {
                String name = payerName.getText();
                String value = amount.getText();
                if(!Objects.equals(ticketName,"other")){
                    controller.addTicket(ticketName,name, Double.valueOf(value), false);
                }else{
                    String tName = ticketTextName.getText();
                    controller.addTicket(ticketName,name, Double.valueOf(value), isEven);
                }
                if((!Objects.equals(ticketName, "taxi") || !Objects.equals(ticketName, "plane"))&&!isEven){
                    JButton setDepts = new JButton("Set depts");
                    setDepts.setBounds(120, 160, 100, 25);
                    ticketPanel.add(setDepts);
                    setDepts.addActionListener(c ->
                    {
                        isUpdated=false;
                        setAmounts(name, ticketPanel, Double.valueOf(value));
                        ticketPanel.remove(setDepts);
                    });
                }
                isEven = false;
                if(!isUpdated){
                    feedback.setBounds(120, 190, 140, 25);
                    ticketPanel.add(feedback);
                    ticketPanel.repaint();
                    isUpdated=true;
                }
            });

            JButton back = new JButton("Back");
            back.setBounds(300, 180, 80, 25);
            ticketPanel.add(back);
            back.addActionListener(a ->
            {
                frame1.remove(ticketPanel);
                frame1.add(panel1);
                frame1.repaint();
                isUpdated=false;
            });
        });
    }

    private void setAmounts(String payerName, JPanel panel1, Double amount){
        JPanel deptSetPanel = new JPanel();
        frame1.remove(panel1);
        frame1.add(deptSetPanel);
        frame1.setVisible(true);

        String[] stringList = controller.getDBPerson().getPersonList().keySet().toArray(new String[controller.getDBPerson().getPersonList().keySet().size()]);

        JLabel nameLabel = new JLabel("Give the amount of dept for " + stringList[index]);
        nameLabel.setBounds(100, 5, 220, 25);
        deptSetPanel.add(nameLabel);

        JTextField value = new JTextField();
        value.setBounds(120, 35, 100, 25);
        deptSetPanel.add(value);

        JButton next = new JButton("Next");
        next.setBounds(100, 80, 80, 25);
        deptSetPanel.add(next);
        next.addActionListener(a ->
        {
            String waarde = value.getText();
            if(index<(controller.getDBPerson().getPersonList().keySet().size()-1)){
                if(!Objects.equals(stringList[index], payerName)){
                    if(sum<amount){
                        controller.changeValue(stringList[index], Double.valueOf(waarde));
                        sum +=Double.parseDouble(waarde);
                    }else {
                        System.out.println("ERROR: your input has exceeded the total amount");
                        JLabel errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                        errorLabel.setBounds(100, 105, 280, 25);
                        deptSetPanel.add(errorLabel);
                        deptSetPanel.repaint();
                    }
                }else{
                    if(sum<amount){
                        controller.changeValue(stringList[index], -(amount-Double.parseDouble(waarde)));
                        sum +=Double.parseDouble(waarde);
                    }else {
                        System.out.println("ERROR: your input has exceeded the total amount");
                        JLabel errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                        errorLabel.setBounds(100, 105, 280, 25);
                        deptSetPanel.add(errorLabel);
                        deptSetPanel.repaint();
                    }

                }
                index += 1;
                deptSetPanel.remove(nameLabel);
                nameLabel.setText("Give the amount of dept for " + stringList[index]);
                deptSetPanel.add(nameLabel);
                deptSetPanel.repaint();
            }
            if(index==(controller.getDBPerson().getPersonList().keySet().size()-1)){
                if(!Objects.equals(stringList[index], payerName)){
                    if(sum<amount){
                        controller.changeValue(stringList[index], (amount-sum));
                    }else{
                        System.out.println("ERROR: your input has exceeded the total amount");
                        JLabel errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                        errorLabel.setBounds(100, 105, 280, 25);
                        deptSetPanel.add(errorLabel);
                        deptSetPanel.repaint();
                    }
                }else{
                    if(sum<amount){
                        controller.changeValue(stringList[index], -(amount-(amount-sum)));
                    }
                    System.out.println("ERROR: your input has exceeded the total amount");
                    JLabel errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                    errorLabel.setBounds(100, 105, 280, 25);
                    deptSetPanel.add(errorLabel);
                    deptSetPanel.repaint();
                }
                index=0;
                sum=0.0;
                frame1.remove(deptSetPanel);
                frame1.add(panel1);
                frame1.repaint();
                isUpdated=false;
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300, 180, 80, 25);
        deptSetPanel.add(back);
        back.addActionListener(a ->
        {
            frame1.remove(deptSetPanel);
            frame1.add(panel1);
            frame1.repaint();
            isUpdated=false;
        });
    }

}

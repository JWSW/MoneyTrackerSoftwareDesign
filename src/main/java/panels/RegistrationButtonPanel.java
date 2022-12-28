/*
Credits to Jens de Hoog
 */

package panels;


import PersonData.Person;
import controller.RegistrationController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RegistrationButtonPanel extends JPanel {

    private JList<Person> personJList;
    private DefaultListModel<Person> personListModel;
    private Person person = new Person("None");
    private JButton addTicket;
    private JButton addPerson;
    private JButton removePerson;
    private JButton seeDepts;
    private JButton getTicket;
    private boolean isEven;
    private boolean isUpdated;
    private boolean payerPassed;
    private int index = 0;
    private Double sum = 0.0;
    private String pName;
    private String tName;
    private ArrayList<Double> inputList = new ArrayList<>();
    private boolean SumGreaterThanAmountError;
    private JFrame frame1 = new JFrame("Moneykeeper");

    // Get your controller in this private field
    private RegistrationController controller = new RegistrationController();

    // For now, just make a new employee in this class via your factory.
    // You can change this later on to a more unified way

    // Get your controller in this class via the constructor
    public RegistrationButtonPanel()
    {
        frame1.setSize(500, 500);
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

        getTicket = new JButton("See tickets");
        getTicket.setBounds(80, 85, 100, 35);

        removePerson = new JButton("Remove person");
        removePerson.setBounds(185, 85, 205, 35);

        personListModel = new DefaultListModel<>();
        personJList = new JList<>(personListModel);


        // Create your temporary employee here
//        this.employee = your factory creating an employee
        addTicketButtonActionListener(panel);
        addPersonButtonActionListener(panel);
        addseeDeptButtonActionListener(panel);
        getTicketButtonActionListener(panel);
        removePersonButtonActionListener(panel);

//        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        panel.add(label);
        panel.add(addTicket);
        panel.add(addPerson);
        panel.add(seeDepts);
        panel.add(getTicket);
        panel.add(removePerson);
    }

    private void removePersonButtonActionListener(JPanel panel1) {
        removePerson.addActionListener(listener ->
        {
            JPanel personPanel = new JPanel();
            frame1.remove(panel1);
            frame1.add(personPanel);
            frame1.setVisible(true);

            JLabel nameLabel = new JLabel("Chose which person to remove.");
            nameLabel.setBounds(100, 5, 180, 25);
            personPanel.add(nameLabel);

            int j = 25;
            for(String i:controller.getDBPerson().getPersonList().keySet()){
                JButton nameButton = new JButton(i);
                nameButton.setBounds(100,j,100,25);
                personPanel.add(nameButton);
                removePersonNameListener(personPanel, nameButton.getText(), nameButton);
                j+=30;
            }

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

    private void removePersonNameListener(JPanel panel1, String personName, JButton button) {
        button.addActionListener(e->{
            controller.removePerson(personName);
            panel1.remove(button);
            panel1.repaint();
        });
    }

    public void addPerson(Person person){
        this.person = person;
    }
    private void addGetTicketNameListener(JPanel panel1, String personName, JButton button){
        button.addActionListener(e->{
            JPanel getNameTicketPanel = new JPanel();
            frame1.remove(panel1);
            frame1.add(getNameTicketPanel);
            frame1.setVisible(true);

            JLabel ticketLabel = new JLabel();
            if (controller.getDBTicket().getTicketList().get(personName).size() < 2) {

                ticketLabel.setText(controller.getDBTicket().getTicket(personName, "DoesntMatter").toString());
                ticketLabel.setBounds(80, 5, 300, 20);
                getNameTicketPanel.add(ticketLabel);
                getNameTicketPanel.repaint();

                JButton removeTicket = new JButton("Remove ticket");
                removeTicket.setBounds(300, 140, 150, 25);
                getNameTicketPanel.add(removeTicket);
                removeTicket.addActionListener(a->{
                    controller.removeTicket(personName,"DoesntMatter");
                    getNameTicketPanel.remove(removeTicket);
                    getNameTicketPanel.repaint();
                    panel1.remove(button);
                    panel1.repaint();
                });

            } else {
                JLabel questionLabel = new JLabel("Which ticket do you want to see?");
                questionLabel.setBounds(80, 5, 300, 20);
                getNameTicketPanel.add(questionLabel);
                String temp = "";
                int j = 25;
                JButton removeTicket = new JButton("Remove ticket");
                JButton back = new JButton("Back");

                for (String i : controller.getDBTicket().getTicketList().get(personName).keySet()) {
                    temp += i + ",";
                    JButton ticketButton = new JButton(i);
                    ticketButton.setBounds(100,j,150,25);
                    j+=30;
                    getNameTicketPanel.add(ticketButton);
                    ticketButton.addActionListener(a->{
                        if(getNameTicketPanel.getComponentAt(300,140) != null) {
                            removeTicket.setBounds(300, 140, 150, 25);
                            getNameTicketPanel.add(removeTicket);
                            removeTicket.addActionListener(z -> {
                                controller.removeTicket(personName, i);
                                getNameTicketPanel.remove(ticketButton);
                                getNameTicketPanel.remove(removeTicket);
                                getNameTicketPanel.repaint();
                            });
                        }

                        ticketLabel.setText(controller.getDBTicket().getTicket(personName, i).toString());
                        ticketLabel.setBounds(80, 180, 300, 20);
                        getNameTicketPanel.add(ticketLabel);
                        getNameTicketPanel.setLayout(new BoxLayout(getNameTicketPanel, BoxLayout.Y_AXIS));
                        getNameTicketPanel.repaint();
                    });
                }
            }
            JButton back = new JButton("Back");
            back.setBounds(300, 180, 80, 25);
            getNameTicketPanel.add(back);
            back.addActionListener(a ->
            {
                frame1.remove(getNameTicketPanel);
                frame1.add(panel1);
                frame1.repaint();
            });
        });
    }
    private void getTicketButtonActionListener(JPanel panel1) {
        getTicket.addActionListener(e -> {
            JPanel getTicketPanel = new JPanel();
            frame1.remove(panel1);
            frame1.add(getTicketPanel);
            frame1.setVisible(true);

            JLabel headLabel = new JLabel("Who's tickets do you want to see?");
            headLabel.setBounds(100, 5, 200, 20);
            getTicketPanel.add(headLabel);

            int j = 25;
            for(String i:controller.getDBTicket().getTicketList().keySet()){
                JButton nameButton = new JButton(i);
                nameButton.setBounds(100,j,100,25);
                getTicketPanel.add(nameButton);
                addGetTicketNameListener(getTicketPanel, nameButton.getText(), nameButton);
                j+=30;
            }

            JButton back = new JButton("Back");
            back.setBounds(300, 180, 80, 25);
            getTicketPanel.add(back);
            back.addActionListener(a ->
            {
                frame1.remove(getTicketPanel);
                frame1.add(panel1);
                frame1.repaint();
            });
        });
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

            int index = 50;

            for(String name:controller.getDBPerson().getPersonList().keySet()){
                for(String payerName:controller.getDBPerson().getPersonList().get(name).keySet()) {
                    JLabel deptLabel = new JLabel(name + " is " + controller.getDBPerson().getPersonList().get(name).get(payerName) + " in dept to " + payerName);
                    deptLabel.setBounds(100, index, 180, 20);
                    deptsPanel.add(deptLabel);
                    index += 20;
                }
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
                    JLabel feedback = new JLabel("Person " + person.getName() + " got added.");
                    feedback.setBounds(100, 90, 140, 25);
                    personJList.setBounds(100,120,personJList.getWidth(),personJList.getHeight());
                    personPanel.add(feedback);
                    personPanel.add(personJList);
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
            JLabel label1 = new JLabel("Give the kind of ticket");
            JLabel label2 = new JLabel("(ex.: plane ticket, taxi ticket,...)");
            JButton back = new JButton("Back");
            if(Objects.equals(ticketName, "other")){
                label1.setBounds(290, 5, 160, 25);
                ticketPanel.add(label1);

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
                pName = payerName.getText();
                String value = amount.getText();
                if(SumGreaterThanAmountError){
                    System.out.println(SumGreaterThanAmountError);
                    SumGreaterThanAmountError = false;
                    index = 0;
                    sum = 0.0;
                    inputList.clear();
                    ticketPanel.removeAll();
                    ticketPanel.add(nameLabel);
                    ticketPanel.add(payerName);
                    ticketPanel.add(amountLabel);
                    ticketPanel.add(amount);
                    if(Objects.equals(ticketName, "other")){
                        ticketPanel.add(label1);
                        ticketPanel.add(label2);
                        ticketPanel.add(ticketTextName);
                        ticketPanel.add(evenSplit);
                    }
                    ticketPanel.add(add);
                    ticketPanel.add(back);
                }
                if(!Objects.equals(ticketName,"other")){
                    controller.addTicket(ticketName,pName, Double.valueOf(value), false);
                }else{
                    tName = ticketTextName.getText();
                    controller.addTicket(tName,pName, Double.valueOf(value), isEven);
                }
                if((!Objects.equals(ticketName, "taxi") && !Objects.equals(ticketName, "plane"))&&!isEven){
                    JButton setDepts = new JButton("Set depts");
                    setDepts.setBounds(120, 160, 100, 25);
                    ticketPanel.add(setDepts);
                    setDepts.addActionListener(c ->
                    {
                        isUpdated=false;
                        setAmounts(pName, ticketName, ticketPanel, Double.valueOf(value));
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

    private void setAmounts(String payerName, String ticketName, JPanel panel1, Double amount){
        JPanel deptSetPanel = new JPanel();
        frame1.remove(panel1);
        frame1.add(deptSetPanel);
        frame1.setVisible(true);

        String[] stringList = controller.getDBPerson().getPersonList().keySet().toArray(new String[controller.getDBPerson().getPersonList().keySet().size()]);

        JLabel nameLabel;
        nameLabel = new JLabel("Give the amount of dept for " + stringList[index]);
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
            inputList.add(Double.valueOf(waarde));
            JLabel errorLabel = null;
            if(index<(controller.getDBPerson().getPersonList().keySet().size()-1)&&!SumGreaterThanAmountError){
                if(!Objects.equals(stringList[index], payerName)){
                    if(sum<amount){
                        controller.changeValue(stringList[index], payerName, Double.valueOf(waarde));
                        sum +=Double.parseDouble(waarde);
                    }else {
                        inputList.remove(inputList.size()-1);
                        int j = 0;
                        for(Double i:inputList){
                            controller.changeValue(stringList[j], payerName, -i);
                            System.out.println();
                            System.out.println(inputList);
                            System.out.println(stringList[j]);
                            System.out.println(controller.getDBPerson().getPerson(stringList[j]).getSchuld(payerName));
                            if(controller.getDBPerson().getPerson(stringList[j]).getSchuld(payerName)<=0.0001 && !Objects.equals(stringList[j], payerName)){ // De computer maakt soms kleine foutjes, en bedragen gaan nooit kleiner zijn dan 0
                                System.out.println(controller.getDBPerson().getPerson(stringList[j]).getSchuldList().remove(payerName));
                            }
                            j+=1;
                        }
                        System.out.println("ERROR: your input has exceeded the total amount");
                        errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                        errorLabel.setBounds(100, 155, 280, 25);
                        isUpdated=false;
                        payerPassed = false;
                        SumGreaterThanAmountError = true;
                        panel1.add(errorLabel);
                        frame1.remove(deptSetPanel);
                        frame1.add(panel1);
                        frame1.repaint();
                    }
                }else{
                    if(sum<amount && !SumGreaterThanAmountError){
//                        controller.changeValue(stringList[index], payerName, -(amount-Double.parseDouble(waarde)));
                        sum +=Double.parseDouble(waarde);
                    }else if(SumGreaterThanAmountError){
                        inputList.remove(inputList.size()-1);
                        int j = 0;
                        for(Double i:inputList){
                            controller.changeValue(stringList[j], payerName, -i);
                            if(controller.getDBPerson().getPerson(stringList[j]).getSchuld(payerName)<=0.0001 && !Objects.equals(stringList[j], payerName)){ // De computer maakt soms kleine foutjes, en bedragen gaan nooit kleiner zijn dan 0
                                System.out.println(controller.getDBPerson().getPerson(stringList[j]).getSchuldList().remove(payerName));
                            }
                            j+=1;
                        }
                        System.out.println("ERROR: your input has exceeded the total amount");
                        errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                        errorLabel.setBounds(100, 155, 280, 25);
                        isUpdated=false;
                        payerPassed = false;
                        SumGreaterThanAmountError = true;
                        panel1.add(errorLabel);
                        frame1.remove(deptSetPanel);
                        frame1.add(panel1);
                        frame1.repaint();
                    }
                }
                index += 1;
                deptSetPanel.remove(nameLabel);
                nameLabel.setText("Give the amount of dept for " + stringList[index]);
                deptSetPanel.add(nameLabel);
                deptSetPanel.repaint();
            }
            if(index==(controller.getDBPerson().getPersonList().keySet().size()-1)&&!SumGreaterThanAmountError){
                if(!Objects.equals(stringList[index], payerName)){
                    if(sum<amount && !SumGreaterThanAmountError){
                        controller.changeValue(stringList[index], payerName, (amount-sum));
                    }else if(SumGreaterThanAmountError){
                        int j = 0;
                        for(Double i:inputList){
                            controller.changeValue(stringList[j], payerName, -i);
                            if(controller.getDBPerson().getPerson(stringList[j]).getSchuld(payerName)<=0.0001 && !Objects.equals(stringList[j], payerName)){ // De computer maakt soms kleine foutjes, en bedragen gaan nooit kleiner zijn dan 0
                                System.out.println(controller.getDBPerson().getPerson(stringList[j]).getSchuldList().remove(payerName));
                            }
                            j+=1;
                        }
                        System.out.println("ERROR: your input has exceeded the total amount");
                        errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                        errorLabel.setBounds(100, 155, 280, 25);
                        isUpdated=false;
                        payerPassed = false;
                        SumGreaterThanAmountError = true;
                        panel1.add(errorLabel);
                        frame1.remove(deptSetPanel);
                        frame1.add(panel1);
                        frame1.repaint();
                    }
                }else{
                    if(sum<amount && !SumGreaterThanAmountError){
//                        controller.changeValue(stringList[index], payerName, -(amount-(amount-sum)));
                        sum = 0.0;
                    }else if(SumGreaterThanAmountError){
                        int j = 0;
                        for(Double i:inputList){
                            controller.changeValue(stringList[j], payerName, -i);
                            if(controller.getDBPerson().getPerson(stringList[j]).getSchuld(payerName)<=0.0001 && !Objects.equals(stringList[j], payerName)){ // De computer maakt soms kleine foutjes, en bedragen gaan nooit kleiner zijn dan 0
                                System.out.println(controller.getDBPerson().getPerson(stringList[j]).getSchuldList().remove(payerName));
                            }
                            j+=1;
                        }
                        System.out.println("ERROR: your input has exceeded the total amount");
                        errorLabel = new JLabel("ERROR: your input has exceeded the total amount");
                        errorLabel.setBounds(100, 155, 280, 25);
                        isUpdated=false;
                        payerPassed = false;
                        SumGreaterThanAmountError = true;
                        panel1.add(errorLabel);
                        frame1.remove(deptSetPanel);
                        frame1.add(panel1);
                        frame1.repaint();
                    }
                }
                index=0;
                sum=0.0;
                if(!SumGreaterThanAmountError) {
                    frame1.remove(deptSetPanel);
                    frame1.add(panel1);
                    frame1.repaint();
                    isUpdated = false;
                    payerPassed = false;
                }
            }
            if(SumGreaterThanAmountError){
                if(!Objects.equals(ticketName, "resto")){
                    controller.removeTicket(pName, tName);
                }else{
                    controller.removeTicket(pName,"restaurant ticket");
                }
//                panel1.remove(errorLabel);
//                SumGreaterThanAmountError = false;
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

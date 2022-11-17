/*
Credits to Jens de Hoog
 */

package panels;

import PersonData.Person;

import javax.swing.*;

public class ListPanel extends JPanel {

    private JList<Person> personJList;
    private DefaultListModel<Person> personListModel;

    public ListPanel()
    {
        JLabel label = new JLabel("Registrations");
        personListModel = new DefaultListModel<>();
        personJList = new JList<>(personListModel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(label);
        this.add(personJList);
    }

    public void addPerson(Person person)
    {
        this.personListModel.addElement(person);
    }
}

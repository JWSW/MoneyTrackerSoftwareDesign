package controller;

import Databases.DataPersons;
import Databases.RegisterPerson;
import Databases.RegisterTickets;
import PersonData.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Field;


@RunWith(PowerMockRunner.class)

@PrepareForTest(RegistrationController.class)
public class RegistrationController_UTest {
    public RegistrationController_UTest(){

    }

    @Before
    public void initialize(){

    }

    @Test
    public void t_addPerson() throws Exception {
        Field field1 = RegistrationController.class.getDeclaredField("dbPersons");
        Field field2 = RegistrationController.class.getDeclaredField("dbTickets");

        field1.setAccessible(true);
        field2.setAccessible(true);

        RegisterPerson mock_rp = Mockito.mock(RegisterPerson.class);
        RegisterTickets mock_rt = Mockito.mock(RegisterTickets.class);
        String mock_name = "name";
        Person mock_person = Mockito.mock(Person.class);

        PowerMockito.whenNew(Person.class).withArguments(mock_name).thenReturn(mock_person);

        Controller controllerUnderTest = new RegistrationController();

        field1.set(controllerUnderTest, mock_rp);
        field2.set(controllerUnderTest, mock_rt);

        controllerUnderTest.addPerson(mock_name);
        Mockito.verify(mock_rp, Mockito.times(1)).addPerson(mock_person);

    }

    @Test
    public void t_addTicket() throws Exception {
        Field field1 = RegistrationController.class.getDeclaredField("dbPersons");
        Field field2 = RegistrationController.class.getDeclaredField("dbTickets");
        field1.setAccessible(true);
        field2.setAccessible(true);
        RegisterPerson mock_rp = Mockito.mock(RegisterPerson.class);
        RegisterTickets mock_rt = Mockito.mock(RegisterTickets.class);

        Controller controllerUnderTest = new RegistrationController();

        field1.set(controllerUnderTest, mock_rp);
        field2.set(controllerUnderTest, mock_rt);
    }
}

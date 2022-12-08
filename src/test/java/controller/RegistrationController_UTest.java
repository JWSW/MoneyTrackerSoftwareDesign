package controller;

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
        RegisterPerson mock_rp = Mockito.mock(RegisterPerson.class);
        RegisterTickets mock_rt = Mockito.mock(RegisterTickets.class);
        String mock_name = "name";
        Person mock_person = Mockito.mock(Person.class);

        PowerMockito.whenNew(Person.class).withArguments(mock_name).thenReturn(mock_person);

        Controller controllerUnderTest = new RegistrationController(mock_rp, mock_rt);
        controllerUnderTest.addPerson(mock_name);
        Mockito.verify(mock_rp, Mockito.times(1)).addPerson(mock_person);

    }
}

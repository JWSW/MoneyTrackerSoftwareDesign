package controller;

import Databases.RegisterPerson;
import PersonData.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RegistrationController_UTest {
    public RegistrationController_UTest(){

    }

    @Before
    public void initialize(){

    }

    @Test
    public void t_addPerson(){
        RegisterPerson mock_rp = Mockito.mock(RegisterPerson.class);
        Person mock_person = Mockito.mock(Person.class);

        Controller controllerUnderTest = new RegistrationController();
        Mockito.verify(mock_rp, Mockito.times(1)).addPerson(mock_person);

    }
}

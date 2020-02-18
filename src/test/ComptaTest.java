package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import util.RandomizerAssistant;
import waka.access.User;
import waka.conta.Movimiento;
import waka.persistence.DataSourceConfig;
import waka.persistence.JPAWakaRepository;

import java.util.Date;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringJUnitWebConfig
public class ComptaTest {

    private DataSourceConfig wakaDatabase = new DataSourceConfig();
    private JPAWakaRepository repo = new JPAWakaRepository();

    @Mock
    Movimiento mov = Mockito.mock(Movimiento.class);
    @Mock
    User us = Mockito.mock(User.class);

    @Test
    public void shouldReturnDefaultQuantity () {
        assert (mov.getFecha() == new Date());
        assert (mov.getCuantia() == 0.0);
    }

    @Test
    public void shouldReturnDefaultUser () {
        assert (us.getName() == "");
        assert (us.getPassWord() == "");
    }

    @Test
    public void saveUser () {
        us.setName(RandomizerAssistant.getRandomString(8,16));
        us.setPassWord(RandomizerAssistant.getRandomString(8,19));
        repo.saveUser(us);
    }

    @Test
    public void saveMov () {
        mov.setCuantia(Math.random());
        mov.setConcepto("Concepto en pruebas");
        mov.setFecha( new Date());
        repo.saveMovement(mov);
    }



//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;

}

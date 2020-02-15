package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import waka.access.User;
import waka.conta.Movimiento;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringJUnitWebConfig
public class ComptaTest {

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

//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;

}

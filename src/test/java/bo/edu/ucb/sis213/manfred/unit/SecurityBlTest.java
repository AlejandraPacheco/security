package bo.edu.ucb.sis213.manfred.unit;

import bo.edu.ucb.sis213.manfred.bl.SecurityBl;
import bo.edu.ucb.sis213.manfred.dao.PersonDao;
import bo.edu.ucb.sis213.manfred.dto.AuthReqDto;
import bo.edu.ucb.sis213.manfred.dto.AuthResDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SecurityBlTest {
    @Test
    void succesfulAuthentication(){
        PersonDao personDao = Mockito.mock(PersonDao.class);
        // Que clase estoy probando: SecurityBl
        SecurityBl securityBl = new SecurityBl(personDao);
        // Se invoca el metodo que quiero probar (en este caso el metodo "authenticate")
        AuthResDto response = securityBl.authenticate(new AuthReqDto("jperez@gmail.com", "12345678"));
        Assertions.assertNotNull(response); // Que la respuesta no sea nulo
        Assertions.assertNotNull(response.getToken()); // Que el token no sea nulo
        Assertions.assertNotNull(response.getRefresh()); // Que el refresh token no sea nulo
    }
}

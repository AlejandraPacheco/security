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
        // Implementacion falsa
        PersonDao personDao = Mockito.mock(PersonDao.class);
        // Nosotros sabemos que para esta prueba se necesita:
        // personDao.findByEmailAndPassword(credentials.email());
        // Sabido a que es prueba unitaria debemos crear el comportamiento de lo que va a hacer al mock
        // Cuando se llame a findByEmailAndPassword con el argumento "alejandra@gmail.com"
        Mockito.when(personDao.findPasswordByEmail("alejandra@gmail.com"))
                .thenReturn("$2a$12$THAiW3mBVlkuOx6p2.WrF.zxNsbZSIl6fNAG0KZyAzGsQCiV41nRm");
        // Que clase estoy probando: SecurityBl
        SecurityBl securityBl = new SecurityBl(personDao);
        // Se invoca el metodo que quiero probar (en este caso el metodo "authenticate")
        AuthResDto response = securityBl.authenticate(new AuthReqDto("alejandra@gmail.com", "ABCabc123"));
        Assertions.assertNotNull(response); // Que la respuesta no sea nulo
        Assertions.assertNotNull(response.getToken()); // Que el token no sea nulo
        Assertions.assertNotNull(response.getRefresh()); // Que el refresh token no sea nulo
    }
}

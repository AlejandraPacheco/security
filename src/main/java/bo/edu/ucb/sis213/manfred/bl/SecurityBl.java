package bo.edu.ucb.sis213.manfred.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.manfred.dao.PersonDao;
import bo.edu.ucb.sis213.manfred.dto.AuthReqDto;
import bo.edu.ucb.sis213.manfred.dto.AuthResDto;
import bo.edu.ucb.sis213.manfred.dto.PersonDto;
import bo.edu.ucb.sis213.manfred.entity.Person;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SecurityBl {
    private PersonDao personDao;

    public SecurityBl(PersonDao personDao) {
        this.personDao = personDao;
    }

    /**
     * Metodo realizado para probar la conexion a la BBDD
     * @param personId
     * @return
     */
    public PersonDto getPersonByPk(Integer personId){
        Person person = personDao.findByPrimaryKey(personId);
        //Se transforma la entidad de la BBDD a un DTO para retornar via API
        PersonDto personDto = new PersonDto(person.getPersonId(), person.getEmail());
        return personDto;
    }

    // El siguiente metodo realiza la autenticacion del sistema, va a buscar al repositorio de BBDD
    // la contraseña del usuario y la compara con su equivelente en BCrypt
    public AuthResDto authenticate(AuthReqDto credentials){
        System.out.println("Email: " + credentials.email());
        AuthResDto result = new AuthResDto();
        System.out.println("Comenzando el proceso de autenticacion con: " + credentials);
        String currentPasswordInBCrypt = personDao.findByEmailAndPassword(credentials.email());
        System.out.println("Se obtuvo la siguiente contraseña de bbdd: " + currentPasswordInBCrypt);
        // Se consulta si los passwords coinciden

        if(currentPasswordInBCrypt != null){
            System.out.println("Se procede a verificar si las contraseñas coinciden");
            // Verificador:
            BCrypt.Result bcryptResult= BCrypt.verifyer().verify(credentials.password().toCharArray(), currentPasswordInBCrypt);
            if(bcryptResult.verified){
                // Se genera el token
                System.out.println("Las contraseñas coinciden, se genera el token");
                result = generateTokenJwt(credentials.email(), 300, new String[]{"admin", "user"});
                //result.setToken("TEST TOKEN");
                //result.setRefresh("TEST REFRESH TOKEN");
            } else{
                System.out.println("Las contraseñas no coinciden");
                throw new RuntimeException("Forbiden the secret and password are wrong");
            }
        } else {
            System.out.println("Usuario no existente");
            throw new RuntimeException("Forbiden the secret and password are wrong");
        }
        return result;
    }

    public void createPerson(){

    }

    private AuthResDto generateTokenJwt(String subject, int expirationTimeInSeconds, String [] roles){
        AuthResDto result = new AuthResDto();
        // Generamos el token principal
        try {
            Algorithm algorithm = Algorithm.HMAC256("TigreCampeon2022");
            String token = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withArrayClaim("roles", roles)
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 1000)))
                    .sign(algorithm);
            result.setToken(token);
            result.setRefresh("TEST REFRESH TOKEN");
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("Error al generar el token", exception);
        }
        return result;
    }
}

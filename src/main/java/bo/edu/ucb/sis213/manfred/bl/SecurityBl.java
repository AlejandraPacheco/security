package bo.edu.ucb.sis213.manfred.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.manfred.dao.ManfredRoleDao;
import bo.edu.ucb.sis213.manfred.dao.PersonDao;
import bo.edu.ucb.sis213.manfred.dto.AuthReqDto;
import bo.edu.ucb.sis213.manfred.dto.AuthResDto;
import bo.edu.ucb.sis213.manfred.dto.PersonDto;
import bo.edu.ucb.sis213.manfred.entity.ManfredRole;
import bo.edu.ucb.sis213.manfred.entity.Person;
import bo.edu.ucb.sis213.manfred.util.ManfredException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SecurityBl {
    private final static String JWT_SECRET = "TigreCampeon2022";
    private PersonDao personDao;

    private ManfredRoleDao manfredRoleDao;

    public SecurityBl(PersonDao personDao, ManfredRoleDao manfredRoleDao) {
        this.personDao = personDao;
        this.manfredRoleDao = manfredRoleDao;
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
        String currentPasswordInBCrypt = personDao.findPasswordByEmail(credentials.email());
        System.out.println("Se obtuvo la siguiente contraseña de bbdd: " + currentPasswordInBCrypt);
        // Se consulta si los passwords coinciden

        if(currentPasswordInBCrypt != null){
            System.out.println("Se procede a verificar si las contraseñas coinciden");
            // Verificador:
            BCrypt.Result bcryptResult= BCrypt.verifyer().verify(credentials.password().toCharArray(), currentPasswordInBCrypt);
            if(bcryptResult.verified){
                // Se genera el token
                System.out.println("Las contraseñas coinciden, se genera el token");
                // Consultamos los roles que tiene la persona
                List<ManfredRole> roles = manfredRoleDao.findRolesByEmail(credentials.email());
                List<String> rolesAsString = new ArrayList<>();
                for (ManfredRole role: roles) {
                    rolesAsString.add(role.getName());
                    System.out.println("Rol: " + role.getName());
                }
                result = generateTokenJwt(credentials.email(), 300, rolesAsString);
                //result.setToken("TEST TOKEN");
                //result.setRefresh("TEST REFRESH TOKEN");
            } else{
                System.out.println("Las contraseñas no coinciden");
                throw new ManfredException("Forbiden the secret and password are wrong");
            }
        } else {
            System.out.println("Usuario no existente");
            throw new ManfredException("Forbiden the secret and password are wrong");
        }
        return result;
    }

    public void createPerson(){

    }

    // Metodo para verificar el token JWT y retornar un Person
    public Person validateJwtToken(String jwt) {
        Person result = null;
        try {
            String email = JWT.require(Algorithm.HMAC256(JWT_SECRET))
                    .build()
                    .verify(jwt)
                    .getSubject();
            result = personDao.findByEmail(email);
        } catch (Exception exception) {
            throw new ManfredException("Forbiden the secret and password are wrong", exception);
        }
        return result;
    }

    // El siguiente metodo genera los tokens JWT
    private AuthResDto generateTokenJwt(String subject, int expirationTimeInSeconds, List<String> roles){
        AuthResDto result = new AuthResDto();
        // Generamos el token principal
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            String token = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                    .withClaim("refresh", false)
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 1000)))
                    .sign(algorithm);
            result.setToken(token);
            String refreshToken = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withClaim("refresh", true)
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 1000 * 2)))
                    .sign(algorithm);
            result.setToken(token);
            result.setRefresh(refreshToken);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            throw new ManfredException("Error al generar el token", exception);
        }
        return result;
    }
}

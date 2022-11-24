package bo.edu.ucb.sis213.manfred.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.manfred.dao.PersonDao;
import bo.edu.ucb.sis213.manfred.dto.AuthReqDto;
import bo.edu.ucb.sis213.manfred.dto.AuthResDto;
import bo.edu.ucb.sis213.manfred.dto.PersonDto;
import bo.edu.ucb.sis213.manfred.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class SecurityBl {
    private PersonDao personDao;

    public SecurityBl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public PersonDto getPersonByPk(Integer personId){
        Person person = personDao.findByPrimaryKey(personId);
        //Se transforma la entidad de la BBDD a un DTO para retornar via API
        PersonDto personDto = new PersonDto(person.getPersonId(), person.getEmail());
        return personDto;
    }

    // El siguiente metodo realiza la autenticacion del sistema, va a buscar al repositorio de BBDD
    // la contraseña del usuario y la compara con su equivelente en BCrypt
    public AuthResDto authenticate(AuthReqDto credentials){
        AuthResDto result = null;
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
                result.setToken("TEST TOKEN");
                result.setRefresh("TEST REFRESH TOKEN");
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
}

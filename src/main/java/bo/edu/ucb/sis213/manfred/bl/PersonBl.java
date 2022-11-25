package bo.edu.ucb.sis213.manfred.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.manfred.dao.PersonDao;
import bo.edu.ucb.sis213.manfred.dto.CreatePersonDto;
import bo.edu.ucb.sis213.manfred.entity.Person;
import org.springframework.stereotype.Service;

@Service // Lo marcamos como service para que sea Spring que gestione este objeto
public class PersonBl {
    private PersonDao personDao;

    public PersonBl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void createPerson(CreatePersonDto createPersonDto){
        Person person = new Person();
        person.setEmail(createPersonDto.getEmail());
        // Encrypt password with BCrypt
        String password = BCrypt.withDefaults().hashToString(12, createPersonDto.getPassword().toCharArray());
        person.setPassword(password);

        this.personDao.createPerson(person);
    }
}

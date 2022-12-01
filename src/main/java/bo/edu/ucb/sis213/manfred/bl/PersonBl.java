package bo.edu.ucb.sis213.manfred.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.manfred.dao.CompanyPersonDao;
import bo.edu.ucb.sis213.manfred.dao.PersonDao;
import bo.edu.ucb.sis213.manfred.dto.CreatePersonDto;
import bo.edu.ucb.sis213.manfred.entity.CompanyPerson;
import bo.edu.ucb.sis213.manfred.entity.Person;
import org.springframework.stereotype.Service;

@Service // Lo marcamos como service para que sea Spring que gestione este objeto
public class PersonBl {
    private PersonDao personDao;
    private CompanyPersonDao companyPersonDao;

    public PersonBl(PersonDao personDao, CompanyPersonDao companyPersonDao) {
        this.personDao = personDao;
        this.companyPersonDao = companyPersonDao;
    }

    public void createPerson(CreatePersonDto createPersonDto){
        Person person = new Person();
        person.setEmail(createPersonDto.getEmail());
        // Encrypt password with BCrypt
        String password = BCrypt.withDefaults().hashToString(12, createPersonDto.getPassword().toCharArray());
        person.setPassword(password);
        this.personDao.createPerson(person);
    }

    public CompanyPerson findByEmail(String email){
        return companyPersonDao.findByEmail(email);
    }
}

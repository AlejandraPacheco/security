package bo.edu.ucb.sis213.manfred.bl;

import bo.edu.ucb.sis213.manfred.dao.PersonDao;
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
        PersonDto personDto = new PersonDto(person.getPersonId(), person.getEmail());
        return personDto;
    }
}

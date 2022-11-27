package bo.edu.ucb.sis213.manfred.api;

import bo.edu.ucb.sis213.manfred.bl.PersonBl;
import bo.edu.ucb.sis213.manfred.dto.CreatePersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/person")
public class PersonApi {
    private PersonBl personBl;

    public PersonApi(PersonBl personBl) {
        this.personBl = personBl;
    }

    @PostMapping
    public Map createPerson(@RequestBody CreatePersonDto createPersonDto){
        personBl.createPerson(createPersonDto);
        return Map.of("message", "User created");
    }

}

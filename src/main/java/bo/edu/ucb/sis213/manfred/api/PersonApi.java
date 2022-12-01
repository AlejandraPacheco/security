package bo.edu.ucb.sis213.manfred.api;

import bo.edu.ucb.sis213.manfred.dto.ResponseDto;
import bo.edu.ucb.sis213.manfred.bl.PersonBl;
import bo.edu.ucb.sis213.manfred.dto.CreatePersonDto;
import bo.edu.ucb.sis213.manfred.dto.PersonDto;
import bo.edu.ucb.sis213.manfred.entity.CompanyPerson;
import org.springframework.web.bind.annotation.*;
import bo.edu.ucb.sis213.manfred.bl.SecurityBl;
import bo.edu.ucb.sis213.manfred.util.ManfredException;
import bo.edu.ucb.sis213.manfred.util.AuthUtil;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/person")
public class PersonApi {
    private PersonBl personBl;
    private SecurityBl securityBl;

    public PersonApi(PersonBl personBl) {
        this.personBl = personBl;
    }

    @PostMapping
    public ResponseDto<String> createPerson(@RequestHeader Map<String, String> headers, @RequestBody CreatePersonDto createPersonDto) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            // Si no tiene error, se lanzaraá una excepción
            AuthUtil.verifyHasRole(jwt, "CREAR_USUARIO"); // Authorization
            personBl.createPerson(createPersonDto);
            return new ResponseDto<>("Usuario creado correctamente", null, true);
        } catch (ManfredException ex) {
            return new ResponseDto<>(ex.getMessage(), null, false);
        }
    }

    /**
     * Endpoint para probar la busqueda de una persona por su id (llave primaria)
     * @return
     */
    @GetMapping("/")
    public ResponseDto<CompanyPerson> getCompanyFromToken(@RequestHeader Map<String, String> headers) {
        try {
            String email = AuthUtil.isUserAuthenticated(AuthUtil.getTokenFromHeader(headers));
            return new ResponseDto<>(this.personBl.findByEmail(email), null, true);
        }
        catch (ManfredException ex) {
            return new ResponseDto<>(null, ex.getMessage(), false);
        }
    }

}

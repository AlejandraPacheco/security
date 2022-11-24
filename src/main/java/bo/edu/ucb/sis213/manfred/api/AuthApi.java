package bo.edu.ucb.sis213.manfred.api;

import bo.edu.ucb.sis213.manfred.bl.SecurityBl;
import bo.edu.ucb.sis213.manfred.dto.AuthReqDto;
import bo.edu.ucb.sis213.manfred.dto.AuthResDto;
import bo.edu.ucb.sis213.manfred.dto.PersonDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthApi {
    private SecurityBl securityBl;

    public AuthApi(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

    @GetMapping("/{personId}")
    public PersonDto test(@PathVariable(name = "personId") Integer personId){
        return this.securityBl.getPersonByPk(personId);
    }

    @PostMapping()
    public AuthResDto authentication(@RequestBody AuthReqDto authReqDto){
        return securityBl.authenticate(authReqDto);
    }
}

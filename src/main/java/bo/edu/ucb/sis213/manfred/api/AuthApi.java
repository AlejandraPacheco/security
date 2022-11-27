package bo.edu.ucb.sis213.manfred.api;

import bo.edu.ucb.sis213.manfred.bl.SecurityBl;
import bo.edu.ucb.sis213.manfred.dto.AuthReqDto;
import bo.edu.ucb.sis213.manfred.dto.AuthResDto;
import bo.edu.ucb.sis213.manfred.dto.PersonDto;
import bo.edu.ucb.sis213.manfred.dto.ResponseDto;
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
    public ResponseDto<AuthResDto> authentication(@RequestBody  AuthReqDto authReqDto) {
        if (authReqDto != null && authReqDto.email() != null && authReqDto.password() != null) {
            // Retorna los tokens, null (porque no hay error), true porque fue exitoso
            return new ResponseDto<>(securityBl.authenticate(authReqDto), null, true);
        } else {
            return new ResponseDto<>(null, "Credenciales incorrectas", false);
        }
    }
}

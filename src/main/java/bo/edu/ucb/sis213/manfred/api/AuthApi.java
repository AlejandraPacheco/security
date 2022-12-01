package bo.edu.ucb.sis213.manfred.api;

import bo.edu.ucb.sis213.manfred.util.ManfredException;
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

    @PostMapping()
    public ResponseDto<AuthResDto> authentication(@RequestBody  AuthReqDto authReqDto) {
        if (authReqDto != null && authReqDto.email() != null && authReqDto.password() != null) {
            // Retorna los tokens, null (porque no hay error), true porque fue exitoso
            try{
                return new ResponseDto<>(securityBl.authenticate(authReqDto), null, true);
            } catch (ManfredException ex){
                return new ResponseDto<>(null, ex.getMessage(), false);
            }

        } else {
            return new ResponseDto<>(null, "Credenciales incorrectas", false);
        }
    }
}

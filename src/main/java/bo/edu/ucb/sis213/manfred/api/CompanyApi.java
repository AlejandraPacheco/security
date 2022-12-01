package bo.edu.ucb.sis213.manfred.api;

import bo.edu.ucb.sis213.manfred.bl.CompanyBl;
import bo.edu.ucb.sis213.manfred.dto.CreateCompanyDto;
import bo.edu.ucb.sis213.manfred.dto.ResponseDto;
import bo.edu.ucb.sis213.manfred.util.ManfredException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyApi {
    private CompanyBl companyBl;

    public CompanyApi(CompanyBl companyBl) {
        this.companyBl = companyBl;
    }

    @PostMapping
    public ResponseDto<String> createCompany(@RequestHeader Map<String, String> headers, @RequestBody CreateCompanyDto createCompanyDto) {
        try{
            Thread.sleep(3000);
        } catch (Exception ex){
            // Do nothing
        }
        try {
            companyBl.createCompany(createCompanyDto);
            return new ResponseDto<>("Company created succesfully", null, true);
        } catch (ManfredException ex) {
            return new ResponseDto<>(ex.getMessage(), null, false);
        }
    }
}

package bo.edu.ucb.sis213.manfred.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.manfred.dao.CompanyDao;
import bo.edu.ucb.sis213.manfred.dao.PersonDao;
import bo.edu.ucb.sis213.manfred.dto.CreateCompanyDto;
import bo.edu.ucb.sis213.manfred.entity.Company;
import bo.edu.ucb.sis213.manfred.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class CompanyBl {
    private PersonDao personDao;
    private CompanyDao companyDao;


    public CompanyBl(PersonDao personDao, CompanyDao companyDao) {
        this.personDao = personDao;
        this.companyDao = companyDao;
    }

    public void createCompany(CreateCompanyDto createCompanyDto){
        Company company = new Company();
        company.setPersonId(personDao.maximoPersonId());
        company.setCompanyName(createCompanyDto.getCompanyName());
        company.setDescription(createCompanyDto.getDescription());
        company.setCompanyWebsite(createCompanyDto.getCompanyWebsite());
        company.setManagerName(createCompanyDto.getManagerName());
        company.setManagerPhoneNumber(createCompanyDto.getManagerPhoneNumber());
        System.out.println(personDao.maximoPersonId());
        System.out.println(createCompanyDto.getCompanyName());
        System.out.println(createCompanyDto.getDescription());
        System.out.println(createCompanyDto.getCompanyWebsite());
        this.companyDao.createCompany(company);
    }
}

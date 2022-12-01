package bo.edu.ucb.sis213.manfred.dao;

import bo.edu.ucb.sis213.manfred.entity.Company;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface CompanyDao {
    @Insert("""
            INSERT INTO company (person_id, company_name, logo_url, description, company_website,
                        manager_name, manager_phone_number, status, tx_user, tx_date, tx_host)
            VALUES (#{personId}, #{companyName}, null, #{description}, #{companyWebsite}, 
            #{managerName}, #{managerPhoneNumber}, 1, 'admin', now(), 'localhost');
            """)
    void createCompany(Company company);
}

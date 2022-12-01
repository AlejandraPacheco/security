package bo.edu.ucb.sis213.manfred.dao;

import bo.edu.ucb.sis213.manfred.entity.CompanyPerson;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface CompanyPersonDao {
    @Select("""
            SELECT c.company_name, p.email
            FROM person p join company c ON p.person_id = c.person_id
            WHERE p.email = #{email}
            AND p.status = 1;
            """)
    public CompanyPerson findByEmail(String email);
}

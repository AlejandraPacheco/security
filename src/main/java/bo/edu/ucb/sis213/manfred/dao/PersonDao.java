package bo.edu.ucb.sis213.manfred.dao;

import bo.edu.ucb.sis213.manfred.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface PersonDao {
    @Select("""
            SELECT
                person_id,
                email,
                password,
                status,
                tx_user,
                tx_date,
                tx_host
            FROM 
                PERSON
            WHERE 
                person_id = #{personId}
                AND status = 1;
            """)
    Person findByPrimaryKey(Integer personId);

    @Select("""
            SELECT
                person_id,
                email,
                password,
                status,
                tx_user,
                tx_date,
                tx_host
            FROM 
                PERSON
            WHERE 
                email = #{email}
                AND status = 1;
            """)
    Person findByEmail(String email);

    @Select("""
            SELECT password
            FROM 
                PERSON
            WHERE 
                email= #{email}
                AND status = 1;
            """)
    String findPasswordByEmail(String email);

    @Insert("""
            INSERT INTO 
            person(email, password, status, tx_user, tx_date, tx_host)
            VALUES (#{email}, #{password}, 1, 'anonymous', now(), 'localhost');
            """)
    void createPerson(Person person);

    @Select("""
            SELECT MAX(person_id) FROM person;
            """)
    Integer maximoPersonId();
}


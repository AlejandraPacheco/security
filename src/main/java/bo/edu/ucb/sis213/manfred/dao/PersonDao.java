package bo.edu.ucb.sis213.manfred.dao;

import bo.edu.ucb.sis213.manfred.entity.Person;
import org.apache.ibatis.annotations.Select;

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
            FROM PERSON
            WHERE person_id = #{personId};
            """)
    Person findByPrimaryKey(Integer personId);
}


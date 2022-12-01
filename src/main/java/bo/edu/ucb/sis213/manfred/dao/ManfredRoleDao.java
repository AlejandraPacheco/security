package bo.edu.ucb.sis213.manfred.dao;

import bo.edu.ucb.sis213.manfred.entity.ManfredRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ManfredRoleDao {

    @Select("""
            SELECT
                role.role_id,
                role.name,
                role.description,
                role.status,
                role.tx_user,
                role.tx_date,
                role.tx_host
            FROM
                manfred_role role
            JOIN
                manfred_group_role group_role ON role.role_id = group_role.role_id
            JOIN
                manfred_person_group person_group ON group_role.group_id = person_group.group_id
            JOIN
                person p ON person_group.person_id = p.person_id
            WHERE
                p.email = #{email}
                AND role.status = 1
                AND group_role.status = 1
                AND person_group.status = 1
                AND p.status = 1;
            """)
    public List<ManfredRole> findRolesByEmail(String email);
}

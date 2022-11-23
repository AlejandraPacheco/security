-- Datos de prueba para la tabla person
INSERT INTO person (email, password, status, tx_user, tx_date, tx_host)
VALUES ('jperez@gmail.com', 'ABCDE!@123123123', 1, 'admin', now(), '127.0.0.1');

INSERT INTO person (email, password, status, tx_user, tx_date, tx_host)
VALUES ('mgomez@gmail.com', 'ABCDE!@123123123', 1, 'admin', now(), '127.0.0.1');

INSERT INTO person (email, password, status, tx_user, tx_date, tx_host)
VALUES ('lramirez@gmail.com', 'ABCDE!@123123123', 1, 'admin', now(), '127.0.0.1');

-- Datos para la tabla manfred_group
INSERT INTO manfred_group (name, description, status, tx_user, tx_date, tx_host)
VALUES ('USUARIO', 'Grupo para usuarios de la aplicacion Manfred', 1, 'admin', now(), '127.0.0.1');

INSERT INTO manfred_group (name, description, status, tx_user, tx_date, tx_host)
VALUES ('EMPRESA', 'Grupo para empresas de la aplicacion Manfred', 1, 'admin', now(), '127.0.0.1');

-- Datos para la tabla manfred_role
INSERT INTO manfred_role (name, description, status, tx_user, tx_date, tx_host)
VALUES ('APLICAR_TRABAJO', 'Rol para usuarios de la aplicacion Manfred', 1, 'admin', now(), '127.0.0.1');

INSERT INTO manfred_role (name, description, status, tx_user, tx_date, tx_host)
VALUES ('CREAR_REQUERIMIENTO', 'Rol para empresas de la aplicacion Manfred', 1, 'admin', now(), '127.0.0.1');

-- Tabla manfred_group_role
INSERT INTO manfred_group_role (role_id, group_id, status, tx_user, tx_date, tx_host)
VALUES (1, 1, 1, 'admin', now(), '127.0.0.1');

INSERT INTO manfred_group_role (role_id, group_id, status, tx_user, tx_date, tx_host)
VALUES (2, 2, 1, 'admin', now(), '127.0.0.1');

-- Tabla manfred_person_group
INSERT INTO manfred_person_group (person_id, group_id, status, tx_user, tx_date, tx_host)
VALUES (1, 1, 1, 'admin', now(), '127.0.0.1');

INSERT INTO manfred_person_group (person_id, group_id, status, tx_user, tx_date, tx_host)
VALUES (2, 1, 1, 'admin', now(), '127.0.0.1');

INSERT INTO manfred_person_group (person_id, group_id, status, tx_user, tx_date, tx_host)
VALUES (3, 2, 1, 'admin', now(), '127.0.0.1');

-- Pruebas
SELECT mf.name, mf.description
FROM
    person per
        LEFT JOIN manfred_person_group mpg on per.person_id = mpg.person_id
        LEFT JOIN manfred_group mg on mpg.group_id = mg.group_id
        LEFT JOIN manfred_group_role mgr on mg.group_id = mgr.group_id
        LEFT JOIN manfred_role mf on mgr.role_id = mf.role_id
WHERE
        per.email = 'mgomez@gmail.com';
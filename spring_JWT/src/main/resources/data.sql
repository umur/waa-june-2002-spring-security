INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1, 'apokhrel@miu.edu', 'ashish', 'pokhrel', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2, 'admin@miu.edu', 'admin', 'user', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');

INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (users_id, roles_id)
VALUES (2, 2);


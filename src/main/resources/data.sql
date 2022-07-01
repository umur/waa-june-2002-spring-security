-- USERS

INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1, 'alisher_admin@miu.edu', 'Alisher', 'Abdullaev', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2, 'alisher_user@miu.edu', 'Alisher2', 'Abdullaev2' , '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');

INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);

-- PRODUCTS
--
INSERT INTO product (id, name, price, rating, user_id)
VALUES (1, 'iPhone', 1200, 10, 1);

INSERT INTO product (id, name, price, rating, user_id)
VALUES (2, 'iPad', 900, 10, 1);

INSERT INTO product (id, name, price, rating, user_id)
VALUES (3, 'Pen', 5, 10, 1);

-- REVIEWS

INSERT INTO review (id,comment,product_id,user_id)
VALUES (1,'awesome phone',1,1);

INSERT INTO review (id,comment,product_id,user_id)
VALUES (2,'amazing phone',1,1);

INSERT INTO review (id,comment,product_id,user_id)
VALUES (3,'awesome tablet',1,2);
INSERT INTO users (id, user_name, firstname, lastname, password)
VALUES (1, 'admin', 'admin', 'admin', '$2a$10$NWnU7YutFYM3pDp2Mdy3xuKRcau8DNNAKA6iEyqaZwqyN5oU9srby');
INSERT INTO users (id, user_name, firstname, lastname, password)
VALUES (2, 'pprajapati', 'puru', 'prajapati', '$2a$10$NWnU7YutFYM3pDp2Mdy3xuKRcau8DNNAKA6iEyqaZwqyN5oU9srby');
INSERT INTO users (id, user_name, firstname, lastname, password)
VALUES (3, 'user', 'user', 'user', '$2a$10$NWnU7YutFYM3pDp2Mdy3xuKRcau8DNNAKA6iEyqaZwqyN5oU9srby');

INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

INSERT INTO users_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_role (user_id, role_id)
VALUES (2, 2);
INSERT INTO users_role (user_id, role_id)
VALUES (3, 1);

INSERT INTO products (id, product_name, price, user_id)
VALUES (1, 'iPhone', 1200, 1);
INSERT INTO products (id, product_name, price, user_id)
VALUES (2, 'iPad', 900, 1);
INSERT INTO products (id, product_name, price, user_id)
VALUES (3, 'Pen', 5, 2);


INSERT INTO reviews (id,comment,number_of_stars,product_id)
VALUES (1,'awesome phone',5,1);

INSERT INTO reviews (id,comment,number_of_stars,product_id)
VALUES (2,'amazing phone',5,1);

INSERT INTO reviews (id,comment,number_of_stars,product_id)
VALUES (3,'awesome tablet',5,2);


INSERT INTO categories (id, name) VALUES (1, 'Mac');
INSERT INTO categories (id, name) VALUES (2, 'Microsoft');

INSERT INTO categories_products (category_id, product_id) VALUES (1, 1);
INSERT INTO categories_products (category_id, product_id) VALUES (1, 2);
INSERT INTO categories_products (category_id, product_id) VALUES (1, 3);



select setval('products_id_seq',COALESCE((select max(id) + 1 from products), 1));
select setval('users_id_seq',COALESCE((select max(id) + 1 from users), 1));
select setval('roles_id_seq',COALESCE((select max(id) + 1 from roles), 1));
select setval('categories_id_seq',COALESCE((select max(id) + 1 from roles), 1));
select setval('reviews_id_seq',COALESCE((select max(id) + 1 from roles), 1));
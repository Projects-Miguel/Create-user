INSERT INTO phones (numero,city_code,contry_code) VALUES ('1','57', 3127197930);
INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');
INSERT INTO usernames (enabled, name, email,password, create_at, update_at, last_login, token) VALUES (true,'Miguel', 'jorgemiguelfv05@gmail.com','$2a$10$b35og39bpqERloyc8uTqSOfdCBnbEK7WnD/UUyfWhADgd1.m8JIB.', null,null,null, 'ecnbei');
INSERT INTO usernames_phones (username_id,phones_id) VALUES  (1,1);
INSERT INTO usernames_roles (username_id, roles_id) VALUES (1,1);
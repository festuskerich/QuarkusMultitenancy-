CREATE SEQUENCE base.users_id_seq;
SELECT setval('base."users_id_seq"', 3);
CREATE TABLE base.users
(
  id   INT,
  name VARCHAR(40)
);
INSERT INTO base.users(id, name) VALUES (1, 'mika');
INSERT INTO base.users(id, name) VALUES (2, 'monika');
INSERT INTO base.users(id, name) VALUES (3, 'mary');

CREATE SEQUENCE mycompany.users_id_seq;
SELECT setval('mycompany."users_id_seq"', 3);
CREATE TABLE mycompany.users
(
  id   INT,
  name VARCHAR(40)
);
INSERT INTO mycompany.users(id, name) VALUES (1, 'dan');
INSERT INTO mycompany.users(id, name) VALUES (2, 'wafula');
INSERT INTO mycompany.users(id, name) VALUES (3, 'tracy');
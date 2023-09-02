CREATE SCHEMA mydbschema;
GRANT USAGE ON SCHEMA mydbschema TO mydbuser;

CREATE TABLE IF NOT EXISTS mydbschema.users
(
    id          uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    first_name  VARCHAR(255),
    second_name VARCHAR(255),
    age         INTEGER, --deprecated?
    birthdate   date,
    city        VARCHAR(255),
    biography   VARCHAR(8000),
    password    VARCHAR(255) NOT NULL
);

insert into mydbschema.users(first_name, second_name, age, birthdate, city, biography, password)
VALUES ('ruslan', 'ruslanovich', 23, '2000-03-13', 'msk', 'programmer1', 'q123123'),
       ('alexander', 'alexandrovich', 35, '1987-10-22', 'nsk', 'programmer2', 'qwerty123');

CREATE TABLE IF NOT EXISTS mydbschema.logins
(
    id      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id uuid NOT NULL UNIQUE
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA mydbschema TO mydbuser;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA mydbschema TO postgres;
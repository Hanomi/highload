CREATE SCHEMA mydbschema;
GRANT USAGE ON SCHEMA mydbschema TO mydbuser;

CREATE TABLE IF NOT EXISTS mydbschema.users
(
    id         uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    firstname  VARCHAR(255),
    secondname VARCHAR(255),
    age        INTEGER, --deprecated?
    birthdate  date,
    city       VARCHAR(255),
    biography  VARCHAR(8000)
);

insert into mydbschema.users(firstname, secondname, age, birthdate, city, biography)
VALUES ('ruslan', 'ruslanovich', 23, '2000-03-13', 'msk', 'programmer1'),
       ('alexander', 'alexandrovich', 35, '1987-10-22', 'nsk', 'programmer2');

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA mydbschema TO mydbuser;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA mydbschema TO postgres;
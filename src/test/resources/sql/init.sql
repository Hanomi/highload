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

-- Секретная строка

insert into mydbschema.users(first_name, second_name, age, birthdate, city, biography, password)
VALUES ('ruslan', 'ruslanovich', 23, '2000-03-13', 'msk', 'programmer1', '$argon2id$v=19$m=15360,t=2,p=1$FeYUB2fk8hUhzUUZgvlJvDO9J2Y5YaX9ygQVbiWLdLg$kUtEfYsntfUF8Mo9I8GQrycubnrasuS623GlkWhyjJu4fFeuDy8OyVnHiIOEq8BSjNTiihD+dQNOdgBzqC2rjQ'),
       ('alexander', 'alexandrovich', 35, '1987-10-22', 'nsk', 'programmer2', '$argon2id$v=19$m=15360,t=2,p=1$R4VX+CnEEXFDMI1OVC/oXGhX/9VcMaRW5MhIyHH0aWU$nTgmhySqN3Zz589ZYPB2YRHH3lOVrUfINNRCaqJVaLclaKdYaCJ9vUSmzKU8WdEiMhuz2Ak8pVrW90OzwhozjQ');

CREATE TABLE IF NOT EXISTS mydbschema.logins
(
    id      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id uuid NOT NULL UNIQUE
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA mydbschema TO mydbuser;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA mydbschema TO postgres;
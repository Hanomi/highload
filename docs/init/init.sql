CREATE SCHEMA mydbschema;

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

CREATE TABLE IF NOT EXISTS mydbschema.logins
(
    id      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id uuid NOT NULL UNIQUE
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA mydbschema TO postgres;
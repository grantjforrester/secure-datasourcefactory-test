CREATE DATABASE test;

\connect test;

CREATE TABLE greeting (
    id integer NOT NULL,
    hello VARCHAR(255) NOT NULL
);

INSERT INTO greeting values (0, 'Hello from Postgres');
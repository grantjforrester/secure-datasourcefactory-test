-- Connect as system/oracle

create user test identified by mysecretpassword;

grant CREATE SESSION, ALTER SESSION, CREATE DATABASE LINK, -
  CREATE MATERIALIZED VIEW, CREATE PROCEDURE, CREATE PUBLIC SYNONYM, -
  CREATE ROLE, CREATE SEQUENCE, CREATE SYNONYM, CREATE TABLE, - 
  CREATE TRIGGER, CREATE TYPE, CREATE VIEW, UNLIMITED TABLESPACE -
  to test;
  
  
connect test/mysecretpassword
  
CREATE TABLE greeting (
    id integer NOT NULL,
    hello VARCHAR(255) NOT NULL
);

INSERT INTO greeting values (0, 'Hello from Oracle');
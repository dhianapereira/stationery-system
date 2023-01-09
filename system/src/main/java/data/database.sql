CREATE DATABASE stationery;
USE stationery;

CREATE TABLE users(
    cpf VARCHAR(11) NOT NULL,
    fullName VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    isActive BOOL DEFAULT 1,
    isAdmin BOOL DEFAULT 0,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (cpf)
);

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

CREATE TABLE products(
    id VARCHAR(40) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    isActive BOOL DEFAULT 1,
    type VARCHAR(255) NOT NULL,
    quantity INTEGER DEFAULT 0,
    userCPf VARCHAR(11) NOT NULL,

    CONSTRAINT products_fk FOREIGN KEY (userCPf) REFERENCES users(cpf),
    CONSTRAINT products_pk PRIMARY KEY (id)
);
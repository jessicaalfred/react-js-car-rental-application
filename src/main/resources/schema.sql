DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
    id serial NOT NULL PRIMARY KEY,
    userName VARCHAR unique NOT NULL,
    password VARCHAR NOT NULL, 
    firstName VARCHAR NOT NULL,
    lastName VARCHAR NOT NULL, 
    email VARCHAR unique NOT NULL
);
--DROP TABLE IF EXISTS Car;
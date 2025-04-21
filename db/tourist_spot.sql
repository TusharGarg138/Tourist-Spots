create database tourism;

use tourism;

CREATE TABLE states (
state_id INT AUTO_INCREMENT PRIMARY KEY,
state_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE cities (
city_id INT AUTO_INCREMENT PRIMARY KEY,
city_name VARCHAR(50) NOT NULL,
state_id INT,
FOREIGN KEY (state_id) REFERENCES states(state_id)
);

CREATE TABLE tourist_spots (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
city_id INT,
description TEXT,
FOREIGN KEY (city_id) REFERENCES cities(city_id)
);

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

INSERT INTO states (state_name) VALUES
('Uttar Pradesh'),
('Delhi'),
('Maharashtra'),
('Rajasthan'),
('Tamil Nadu'),
('Karnataka'),
('West Bengal'),
('Kerala'),
('Gujarat'),
('Himachal Pradesh');

INSERT INTO cities (city_name, state_id) VALUES
('Agra', 1),
('Delhi', 2),
('Mumbai', 3),
('Jaipur', 4),
('Madurai', 5),
('Bengaluru', 6),
('Mysuru', 6),
('Kolkata', 7),
('Kochi', 8),
('Ahmedabad', 9),
('Manali', 10),
('Shimla', 10);

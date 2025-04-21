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

INSERT INTO tourist_spots (name, city_id, description) VALUES
('Taj Mahal', 1, 'Iconic white marble mausoleum'),
('Red Fort', 2, 'Historic fort and UNESCO World Heritage Site'),
('Gateway of India', 3, 'Famous arch monument overlooking the Arabian Sea'),
('Hawa Mahal', 4, 'Palace with a unique honeycomb structure'),
('Meenakshi Temple', 5, 'Ancient Hindu temple with intricate carvings'),
('Lalbagh Botanical Garden', 6, 'Historic garden with a glasshouse, lake and rare plants'),
('Mysore Palace', 7, 'Grand royal palace with Indo-Saracenic architecture'),
('Victoria Memorial', 8, 'Marble building dedicated to Queen Victoria, now a museum'),
('Fort Kochi', 9, 'Historic coastal area with colonial architecture and Chinese fishing nets'),
('Sabarmati Ashram', 10, 'Historic home of Mahatma Gandhi'),
('Solang Valley', 11, 'Popular adventure and skiing destination'),
('The Ridge', 12, 'Large open space in the heart of Shimla with scenic views');

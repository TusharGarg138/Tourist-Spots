create database tourism;

use tourism;

CREATE TABLE states (
state_id INT AUTO_INCREMENT PRIMARY KEY,
state_name VARCHAR(50) NOT NULL UNIQUE
);

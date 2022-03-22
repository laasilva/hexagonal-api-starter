DROP TABLE IF EXISTS user;

CREATE TABLE user (
     id INT NOT NULL AUTO_INCREMENT,
     username VARCHAR(255),
     password VARCHAR(255)
);
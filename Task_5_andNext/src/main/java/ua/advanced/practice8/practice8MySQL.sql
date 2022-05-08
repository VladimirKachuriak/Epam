DROP DATABASE IF EXISTS `practice8`;
CREATE SCHEMA `practice8` DEFAULT CHARACTER SET utf8;

CREATE TABLE `practice8`.`films` (
  `name` VARCHAR(20) NOT NULL,
  `releaseDate` DATE NOT NULL,
  `releaseCountry` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`name`));

CREATE TABLE `practice8`.`persons` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(20) NOT NULL,
  `patronymic` VARCHAR(20) NOT NULL,
  `birthdate` DATE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `practice8`.`participants` (
  `film_name` VARCHAR(20) NOT NULL,
  `person_id` INT NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  INDEX `to_film_idx` (`film_name` ASC) VISIBLE,
  INDEX `to_person_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `to_film`
    FOREIGN KEY (`film_name`)
    REFERENCES `practice8`.`films` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `to_person`
    FOREIGN KEY (`person_id`)
    REFERENCES `practice8`.`persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

USE practice8;

INSERT INTO films (name, releaseDate, releaseCountry) VALUES ('Matrix', '1999-01-01', 'USA');
INSERT INTO films (name, releaseDate, releaseCountry) VALUES ('Matrix2', '2003-05-04', 'Canada');
INSERT INTO films (name, releaseDate, releaseCountry) VALUES ('Avatar', '2009-05-04', 'France');
INSERT INTO films (name, releaseDate, releaseCountry) VALUES ('Avatar2', '2021-11-21', 'USA');


INSERT INTO persons  (name, surname, patronymic, birthdate) VALUES ('Brad', 'Pitt', 'William', '2002-02-21');
INSERT INTO persons  (name, surname, patronymic, birthdate) VALUES ('Keanu', 'charles', 'Reves', '1955-02-21');
INSERT INTO persons  (name, surname, patronymic, birthdate) VALUES ('Pupkin', 'Vasya', 'Kirilenkov', '2005-02-21');
INSERT INTO persons  (name, surname, patronymic, birthdate) VALUES ('Makuh', 'Sasha', 'Serhii', '1966-02-21');
INSERT INTO persons  (name, surname, patronymic, birthdate) VALUES ('Keri', 'Jim', 'Ulian', '1966-02-21');

INSERT INTO participants (film_name, person_id, type) VALUES ('Matrix', 1, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Matrix', 2, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Matrix', 1, 'Director');

INSERT INTO participants (film_name, person_id, type) VALUES ('Matrix2', 3, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Matrix2', 4, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Matrix2', 4, 'Director');

INSERT INTO participants (film_name, person_id, type) VALUES ('Avatar', 1, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Avatar', 2, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Avatar', 3, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Avatar', 4, 'Actor');
INSERT INTO participants (film_name, person_id, type) VALUES ('Avatar', 1, 'Director');

INSERT INTO participants (film_name, person_id, type) VALUES ('Avatar2', 4, 'Director');
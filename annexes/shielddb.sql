-- MySQL Script generated by MySQL Workbench
-- Tue Mar 16 22:40:02 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

CREATE DATABASE IF NOT EXISTS `shield` ;
USE `shield`;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `access_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `access_role` ;

CREATE TABLE IF NOT EXISTS `access_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `accreditation` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `superbeing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `superbeing` ;

CREATE TABLE IF NOT EXISTS `superbeing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ref` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NULL,
  `superhero` TINYINT NULL,
  `likability` DOUBLE NULL,
  `active` TINYINT NOT NULL,
  `event_participated_in` INT NOT NULL DEFAULT 0,
  `event_succeeded` INT NOT NULL DEFAULT 0,
  `event_failed` INT NOT NULL DEFAULT 0,
  `event_caused` INT NOT NULL DEFAULT 0,
  `arrest_number` INT NOT NULL DEFAULT 0,
  `collateral_damage_risk` DOUBLE NOT NULL DEFAULT 0,
  `dangerousness` DOUBLE NOT NULL DEFAULT 0,
  `discovered_at` DATETIME NOT NULL,
  `treason_risk` DOUBLE NOT NULL DEFAULT 0,
  `affiliated` TINYINT NOT NULL,
  `archive` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `being`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `being` ;

CREATE TABLE IF NOT EXISTS `being` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ref` VARCHAR(50) NOT NULL DEFAULT 'CV',
  `organisation` TINYINT NOT NULL DEFAULT 0,
  `malevolant` TINYINT NOT NULL DEFAULT 0,
  `name` VARCHAR(100) NULL,
  `siret` VARCHAR(100) NULL,
  `title` ENUM('Mr', 'Mme') NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `gender` ENUM('male', 'female', 'other') NULL,
  `birthdate` DATETIME NULL,
  `deathdate` DATETIME NULL,
  `social_security_number` VARCHAR(100) NULL,
  `address` VARCHAR(255) NULL,
  `city` VARCHAR(100) NULL,
  `state` VARCHAR(100) NULL,
  `zipcode` VARCHAR(5) NULL,
  `country` VARCHAR(50) NULL,
  `mobile_phone` VARCHAR(16) NULL,
  `added_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `how_many_declared_incident` INT NULL DEFAULT 0,
  `victim_of_how_many_mission` INT NULL DEFAULT 0,
  `archive` TINYINT NOT NULL DEFAULT 0,
  `email` VARCHAR(50) NULL,
  `password` TEXT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `access_role_id` INT NULL,
  `superbeing_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_being_access_role1_idx` (`access_role_id` ASC),
  INDEX `fk_being_superbeing1_idx` (`superbeing_id` ASC),
  CONSTRAINT `fk_being_access_role1`
    FOREIGN KEY (`access_role_id`)
    REFERENCES `access_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_being_superbeing1`
    FOREIGN KEY (`superbeing_id`)
    REFERENCES `superbeing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee_department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_department` ;

CREATE TABLE IF NOT EXISTS `employee_department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `department` VARCHAR(50) NOT NULL,
  `city` VARCHAR(50) NOT NULL,
  `country` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee` ;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ref` VARCHAR(50) NOT NULL DEFAULT 'A',
  `function` VARCHAR(50) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NULL,
  `active` TINYINT NOT NULL,
  `contract` ENUM('CDI', 'CDD', 'Alternance', 'Stage', 'N/C') NOT NULL,
  `archive` TINYINT NOT NULL,
  `email` VARCHAR(100) NULL,
  `password` TEXT NULL,
  `being_id` INT NOT NULL,
  `employee_department_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_being1_idx` (`being_id` ASC),
  INDEX `fk_employee_employee_department1_idx` (`employee_department_id` ASC),
  CONSTRAINT `fk_employee_being1`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_employee_department1`
    FOREIGN KEY (`employee_department_id`)
    REFERENCES `employee_department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ability` ;

CREATE TABLE IF NOT EXISTS `ability` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `weakness` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_type` ;

CREATE TABLE IF NOT EXISTS `event_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `incident`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `incident` ;

CREATE TABLE IF NOT EXISTS `incident` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ref` VARCHAR(50) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NULL,
  `solved` TINYINT NOT NULL DEFAULT 0,
  `dangerousness` DOUBLE NOT NULL DEFAULT 0,
  `archive` TINYINT NOT NULL DEFAULT 0,
  `status` ENUM('À prendre en charge', 'Traitement en cours', 'Intervention demandée', 'Refusée') NOT NULL DEFAULT 'À prendre en charge',
  `event_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_incident_event_type1_idx` (`event_type_id` ASC),
  CONSTRAINT `fk_incident_event_type1`
    FOREIGN KEY (`event_type_id`)
    REFERENCES `event_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mission` ;

CREATE TABLE IF NOT EXISTS `mission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ref` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NULL,
  `dangerousness` DOUBLE NOT NULL DEFAULT 0,
  `emergency` INT NOT NULL DEFAULT 0,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `report_validated` TINYINT NOT NULL DEFAULT 0,
  `archive` TINYINT NOT NULL DEFAULT 0,
  `intervention_start_date` DATETIME NULL,
  `intervention_end_date` DATETIME NULL,
  `status` ENUM('À prendre en charge', 'Traitement en cours', 'À valider', 'Mission en cours', 'Terminée', 'Refusée') NOT NULL DEFAULT 'À prendre en charge',
  `event_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mission_event_type1_idx` (`event_type_id` ASC),
  CONSTRAINT `fk_mission_event_type1`
    FOREIGN KEY (`event_type_id`)
    REFERENCES `event_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `litige`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `litige` ;

CREATE TABLE IF NOT EXISTS `litige` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ref` VARCHAR(50) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NULL,
  `validated` TINYINT NOT NULL DEFAULT 0,
  `solved` TINYINT NOT NULL DEFAULT 0,
  `cost` DOUBLE NULL,
  `trial_start_date` DATETIME NULL,
  `trial_end_date` DATETIME NULL,
  `archive` TINYINT NOT NULL DEFAULT 0,
  `incident_id` INT NOT NULL,
  `mission_id` INT NULL,
  `event_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_litige_incident1_idx` (`incident_id` ASC),
  INDEX `fk_litige_mission1_idx` (`mission_id` ASC),
  INDEX `fk_litige_event_type1_idx` (`event_type_id` ASC),
  CONSTRAINT `fk_litige_incident1`
    FOREIGN KEY (`incident_id`)
    REFERENCES `incident` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_litige_mission1`
    FOREIGN KEY (`mission_id`)
    REFERENCES `mission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_litige_event_type1`
    FOREIGN KEY (`event_type_id`)
    REFERENCES `event_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `planet` VARCHAR(50) NOT NULL,
  `country` VARCHAR(50) NULL,
  `state` VARCHAR(50) NULL,
  `address` VARCHAR(50) NULL,
  `zipcode` VARCHAR(5) NULL,
  `coordinates` VARCHAR(50) NULL,
  `date` DATETIME NOT NULL,
  `superbeing_id` INT NULL,
  `being_id` INT NULL,
  `incident_id` INT NULL,
  `mission_id` INT NULL,
  `litige_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_superbeing1_idx` (`superbeing_id` ASC),
  INDEX `fk_location_being1_idx` (`being_id` ASC),
  INDEX `fk_location_incident1_idx` (`incident_id` ASC),
  INDEX `fk_location_mission1_idx` (`mission_id` ASC),
  INDEX `fk_location_litige1_idx` (`litige_id` ASC),
  CONSTRAINT `fk_location_superbeing1`
    FOREIGN KEY (`superbeing_id`)
    REFERENCES `superbeing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_being1`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_incident1`
    FOREIGN KEY (`incident_id`)
    REFERENCES `incident` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_mission1`
    FOREIGN KEY (`mission_id`)
    REFERENCES `mission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_litige1`
    FOREIGN KEY (`litige_id`)
    REFERENCES `litige` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `media` ;

CREATE TABLE IF NOT EXISTS `media` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `extension` VARCHAR(10) NOT NULL,
  `media` LONGTEXT NOT NULL,
  `ability_id` INT NULL,
  `superbeing_id` INT NULL,
  `being_id` INT NULL,
  `litige_id` INT NULL,
  `mission_id` INT NULL,
  `incident_id` INT NULL,
  `employee_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_media_ability1_idx` (`ability_id` ASC),
  INDEX `fk_media_superbeing1_idx` (`superbeing_id` ASC),
  INDEX `fk_media_being1_idx` (`being_id` ASC),
  INDEX `fk_media_litige1_idx` (`litige_id` ASC),
  INDEX `fk_media_mission1_idx` (`mission_id` ASC),
  INDEX `fk_media_incident1_idx` (`incident_id` ASC),
  INDEX `fk_media_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_media_ability1`
    FOREIGN KEY (`ability_id`)
    REFERENCES `ability` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_media_superbeing1`
    FOREIGN KEY (`superbeing_id`)
    REFERENCES `superbeing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_media_being1`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_media_litige1`
    FOREIGN KEY (`litige_id`)
    REFERENCES `litige` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_media_mission1`
    FOREIGN KEY (`mission_id`)
    REFERENCES `mission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_media_incident1`
    FOREIGN KEY (`incident_id`)
    REFERENCES `incident` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_media_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback` ;

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('carte postale', 'sms', 'mail', 'enquête', 'presse') NOT NULL,
  `satisfaction` INT NULL,
  `expedition_date` DATETIME NULL,
  `reception_date` DATETIME NOT NULL,
  `validated` TINYINT NOT NULL,
  `status` TINYINT NOT NULL,
  `archive` TINYINT NOT NULL DEFAULT 0,
  `superbeing_id` INT NULL,
  `being_id` INT NULL,
  `mission_id` INT NULL,
  `litige_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_feedback_superbeing1_idx` (`superbeing_id` ASC),
  INDEX `fk_feedback_being1_idx` (`being_id` ASC),
  INDEX `fk_feedback_mission1_idx` (`mission_id` ASC),
  INDEX `fk_feedback_litige1_idx` (`litige_id` ASC),
  CONSTRAINT `fk_feedback_superbeing1`
    FOREIGN KEY (`superbeing_id`)
    REFERENCES `superbeing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_being1`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_mission1`
    FOREIGN KEY (`mission_id`)
    REFERENCES `mission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_litige1`
    FOREIGN KEY (`litige_id`)
    REFERENCES `litige` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comments` TEXT NOT NULL,
  `superbeing_id` INT NULL,
  `being_id` INT NULL,
  `access_role_id` INT NULL,
  `employee_id` INT NULL,
  `ability_id` INT NULL,
  `employee_department_id` INT NULL,
  `location_id` INT NULL,
  `media_id` INT NULL,
  `feedback_id` INT NULL,
  `litige_id` INT NULL,
  `event_type_id` INT NULL,
  `incident_id` INT NULL,
  `mission_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_superbeing1_idx` (`superbeing_id` ASC),
  INDEX `fk_comments_being1_idx` (`being_id` ASC),
  INDEX `fk_comments_access_role1_idx` (`access_role_id` ASC),
  INDEX `fk_comments_employee1_idx` (`employee_id` ASC),
  INDEX `fk_comments_ability1_idx` (`ability_id` ASC),
  INDEX `fk_comments_employee_department1_idx` (`employee_department_id` ASC),
  INDEX `fk_comments_location1_idx` (`location_id` ASC),
  INDEX `fk_comments_media1_idx` (`media_id` ASC),
  INDEX `fk_comments_feedback1_idx` (`feedback_id` ASC),
  INDEX `fk_comments_litige1_idx` (`litige_id` ASC),
  INDEX `fk_comments_event_type1_idx` (`event_type_id` ASC),
  INDEX `fk_comments_incident1_idx` (`incident_id` ASC),
  INDEX `fk_comments_mission1_idx` (`mission_id` ASC),
  CONSTRAINT `fk_comments_superbeing1`
    FOREIGN KEY (`superbeing_id`)
    REFERENCES `superbeing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_being1`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_access_role1`
    FOREIGN KEY (`access_role_id`)
    REFERENCES `access_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_ability1`
    FOREIGN KEY (`ability_id`)
    REFERENCES `ability` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_employee_department1`
    FOREIGN KEY (`employee_department_id`)
    REFERENCES `employee_department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_media1`
    FOREIGN KEY (`media_id`)
    REFERENCES `media` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_feedback1`
    FOREIGN KEY (`feedback_id`)
    REFERENCES `feedback` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_litige1`
    FOREIGN KEY (`litige_id`)
    REFERENCES `litige` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_event_type1`
    FOREIGN KEY (`event_type_id`)
    REFERENCES `event_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_incident1`
    FOREIGN KEY (`incident_id`)
    REFERENCES `incident` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_mission1`
    FOREIGN KEY (`mission_id`)
    REFERENCES `mission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `superbeing_ability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `superbeing_ability` ;

CREATE TABLE IF NOT EXISTS `superbeing_ability` (
  `ability_id` INT NOT NULL,
  `superbeing_id` INT NOT NULL,
  PRIMARY KEY (`ability_id`, `superbeing_id`),
  INDEX `fk_ability_has_superbeing_superbeing1_idx` (`superbeing_id` ASC),
  INDEX `fk_ability_has_superbeing_ability1_idx` (`ability_id` ASC),
  CONSTRAINT `fk_ability_has_superbeing_ability1`
    FOREIGN KEY (`ability_id`)
    REFERENCES `ability` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ability_has_superbeing_superbeing1`
    FOREIGN KEY (`superbeing_id`)
    REFERENCES `superbeing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mission_incident`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mission_incident` ;

CREATE TABLE IF NOT EXISTS `mission_incident` (
  `mission_id` INT NOT NULL,
  `incident_id` INT NOT NULL,
  PRIMARY KEY (`mission_id`, `incident_id`),
  INDEX `fk_mission_has_incident_incident1_idx` (`incident_id` ASC),
  INDEX `fk_mission_has_incident_mission1_idx` (`mission_id` ASC),
  CONSTRAINT `fk_mission_has_incident_mission1`
    FOREIGN KEY (`mission_id`)
    REFERENCES `mission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mission_has_incident_incident1`
    FOREIGN KEY (`incident_id`)
    REFERENCES `incident` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mission_linked_being`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mission_linked_being` ;

CREATE TABLE IF NOT EXISTS `mission_linked_being` (
  `being_id` INT NOT NULL,
  `mission_id` INT NOT NULL,
  PRIMARY KEY (`being_id`, `mission_id`),
  INDEX `fk_being_has_mission_mission1_idx` (`mission_id` ASC),
  INDEX `fk_being_has_mission_being1_idx` (`being_id` ASC),
  CONSTRAINT `fk_being_has_mission_being1`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_being_has_mission_mission1`
    FOREIGN KEY (`mission_id`)
    REFERENCES `mission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `being_litige`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `being_litige` ;

CREATE TABLE IF NOT EXISTS `being_litige` (
  `being_id` INT NOT NULL,
  `litige_id` INT NOT NULL,
  PRIMARY KEY (`being_id`, `litige_id`),
  INDEX `fk_being_has_litige_litige1_idx` (`litige_id` ASC),
  INDEX `fk_being_has_litige_being1_idx` (`being_id` ASC),
  CONSTRAINT `fk_being_has_litige_being1`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_being_has_litige_litige1`
    FOREIGN KEY (`litige_id`)
    REFERENCES `litige` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `incident_linked_entity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `incident_linked_entity` ;

CREATE TABLE IF NOT EXISTS `incident_linked_entity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `incident_id` INT NOT NULL,
  `being_id` INT NULL,
  `superbeing_id` INT NULL,
  `employee_id` INT NULL,
  `declared_by` TINYINT NULL,
  `redacted_by` TINYINT NULL,
  INDEX `fk_being_has_incident_being1_idx` (`being_id` ASC),
  INDEX `fk_being_has_incident_incident1_idx` (`incident_id` ASC),
  INDEX `fk_being_has_incident_superbeing1_idx` (`superbeing_id` ASC),
  INDEX `fk_being_has_incident_employee1_idx` (`employee_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_being`
    FOREIGN KEY (`being_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_incident`
    FOREIGN KEY (`incident_id`)
    REFERENCES `incident` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_superbeing`
    FOREIGN KEY (`superbeing_id`)
    REFERENCES `superbeing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `civil_on_organisation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `civil_on_organisation` ;

CREATE TABLE IF NOT EXISTS `civil_on_organisation` (
  `civil_id` INT NOT NULL,
  `organisation_id` INT NOT NULL,
  PRIMARY KEY (`civil_id`, `organisation_id`),
  INDEX `fk_being_has_being_being2_idx` (`organisation_id` ASC),
  INDEX `fk_being_has_being_being1_idx` (`civil_id` ASC),
  CONSTRAINT `fk_being_has_being_being1`
    FOREIGN KEY (`civil_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_being_has_being_being2`
    FOREIGN KEY (`organisation_id`)
    REFERENCES `being` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `history_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `history_log` ;

CREATE TABLE IF NOT EXISTS `history_log` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `json_content` VARCHAR(45) NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- INSERT INTO `ability` (`id`, `name`, `weakness`) VALUES
-- (1, 'Force', 0),
-- (2, 'Endurance', 0),
-- (3, 'Résistance', 0),
-- (4, 'Régénération', 0),
-- (5, 'Saut', 0),
-- (6, 'Réflexes', 0),
-- (7, 'Precognition', 0),
-- (8, 'Gaz létal', 0),
-- (9, 'Cube Cosmique', 0);

-- INSERT INTO `access_role` (`id`, `name`, `accreditation`) VALUES
-- (1, 'Directeur du S.H.I.E.L.D.', 0),
-- (2, 'Agent_1', 1),
-- (3, 'Agent_2', 2),
-- (4, 'Agent_3', 3),
-- (5, 'Éxtérieur', 4);


-- INSERT INTO `being` (`id`, `ref`, `organisation`, `malevolant`, `name`, `siret`, `title`, `firstname`, `lastname`, `gender`, `birthdate`, `deathdate`, `social_security_number`, `address`, `city`, `state`, `zipcode`, `country`, `mobile_phone`, `added_at`, `updated_at`, `how_many_declared_incident`, `victim_of_how_many_mission`, `archive`, `email`, `password`, `active`, `access_role_id`) VALUES
-- (1, 'CV1321B32294', 0, 0, NULL, NULL, 'Mr', 'Pipriet Molenov', 'Radjasky', 'male', '2017-06-18 00:00:00', NULL, '1321B32294', '136 W 75th St ', 'New York', 'NY', '10023', 'United States', '+15555551234', '2021-03-11 00:00:00', '2021-03-11 16:52:03', 12, 1, 0, 'pipriet.theboss@gmail.com', 'CryptedMdp1!', 1, 5),
-- (2, 'SD1', 0, 0, NULL, NULL, 'Mr', 'Nick', 'Furys', 'male', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'United States', '+15512559283', '2021-03-11 00:00:00', '2021-03-11 00:00:00', 0, 0, 0, 'shield.director@shield.org', 'CryptedMdp1!', 1, 1),
-- (3, 'ORG54205118000066', 1, 0, 'Strategic Homeland Intervention Enforcement Logistics Division', '54205118000066', NULL, NULL, NULL, NULL, '2017-06-18 00:00:00', NULL, NULL, '45 Rockefeller Plaza', 'New York', 'NY', '10111', 'United States', '+15559999991', '2021-03-11 00:00:00', '2021-03-11 00:00:00', 0, 0, 0, 'contact@shield.org', NULL, 1, NULL),
-- (7, 'CV2321C32294', 0, 0, NULL, NULL, 'Mme', 'Joyce Elisabeth', 'Flores', 'female', '1989-02-19 00:00:00', NULL, '2321C32294', '52 Woodland Dr', 'Woodcliff Lake', 'NJ', '07677', 'United States', '+16549294775', '2021-03-11 17:24:39', '2021-03-11 17:24:39', 24, 3, 0, 'Joyce.flores@shield.org', 'CryptedMdp1!', 1, 4),
-- (8, 'EORG1', 1, 1, 'Hydra', NULL, NULL, NULL, NULL, NULL, '1939-04-02 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2021-03-11 17:41:19', '2021-03-11 17:41:19', 0, 0, 0, NULL, NULL, 1, NULL),
-- (9, 'CV1241B11131', 0, 0, NULL, NULL, 'Mr', 'Rijdika', 'Ramathaghana', 'male', '1973-05-29 00:00:00', NULL, '1241B11131', '669 Prospect Pl', 'Brooklyn', 'NY', '11216', 'United States', '+16549000175', '2021-03-11 17:24:39', '2021-03-11 17:24:39', 2, 21, 0, 'rijdirama73@gmail.com', 'CryptedMdp1!', 1, 3),
-- (10, 'CV1431B19977', 0, 0, NULL, NULL, 'Mr', 'Robert Bruce', 'Banner', 'male', '1962-05-01 00:00:00', NULL, '1431B19977', 'Avenger\'s Tower', 'New York', 'NY', '10029', 'United States', '+16549223275', '2021-03-11 18:07:33', '2021-03-11 18:07:33', 0, 0, 0, 'litlegreenman@shield.org', 'CryptedMdp1!', 1, 2),
-- (11, 'CV1264D15509', 0, 0, NULL, NULL, 'Mr', 'Peter', 'Parker', 'male', '2001-08-10 00:00:00', NULL, '1264D15509', '11-05 44th Avenue', 'Long Island City', 'NY', '11101', 'United States', '+16522180462', '2021-03-11 20:55:21', '2021-03-11 20:55:21', 0, 0, 0, 'spidey@shield.com', 'CryptedMdp1!', 1, 3),
-- (12, 'ECV12', 0, 1, NULL, NULL, 'Mr', 'Johann', 'Schmidt', NULL, '1899-01-01 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2021-03-12 10:46:45', '2021-03-12 10:46:45', 0, 0, 0, NULL, NULL, 1, NULL);



-- INSERT INTO `civil_on_organisation` (`civil_id`, `organisation_id`) VALUES
-- (2, 3),
-- (7, 3),
-- (9, 3),
-- (10, 3),
-- (12, 8);


-- INSERT INTO `comment` (`id`, `comments`, `superbeing_id`, `being_id`, `access_role_id`, `employee_id`, `ability_id`, `employee_department_id`, `location_id`, `media_id`, `feedback_id`, `litige_id`, `event_type_id`, `incident_id`, `mission_id`) VALUES
-- (1, 'Directeur du shield. Dossier Secret Défense.', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
-- (2, 'Dr Bruce Banner, Spécialiste en Physique Nucléaire.', NULL, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
-- (3, 'Ancien Nazi fondateur de Hydra. Très dangereux.\r\nWANTED MORT OU VIF.', NULL, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
-- (4, 'Personnes extérieure au S.H.I.E.L.D.', NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
-- (5, 'Super Admin', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
-- (6, 'Organisation dangereuse ayant infiltré différentes couches de la population dans plusieurs pays.\r\nSEARCH AND DESTROY.', NULL, 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- INSERT INTO `employee_department` (`id`, `department`, `city`, `country`) VALUES
-- (1, 'Incident', 'New York', 'United States'),
-- (2, 'Direction General', 'New York', 'United States'),
-- (3, 'Mission', 'New York', 'United States');


-- INSERT INTO `employee` (`id`, `ref`, `function`, `start_date`, `end_date`, `active`, `contract`, `archive`, `email`, `password`, `being_id`, `employee_department_id`) VALUES
-- (1, 'A0012', 'Agent de déclaration d\'incident', '2021-03-12 13:00:16', NULL, 1, 'CDI', 0, 'joyce.flores@shield.incident.org', 'CryptedMdp1!', 7, 1),
-- (2, 'A0029', 'Agent d\'attribution de mission', '2021-03-12 13:06:02', NULL, 1, 'CDI', 0, 'rijdika.ramathaghana@shield.mission.org', 'CryptedMdp1!', 9, 3),
-- (3, 'A000', 'Directeur du Shield', '2021-03-12 13:12:23', NULL, 1, 'N/C', 0, 'nick.furys@shield.director.org', 'CryptedMdp1!', 2, 2);

-- INSERT INTO `event_type` (`id`, `name`) VALUES
-- (1, 'Cambriolage'),
-- (2, 'Attaque de Civils');

-- INSERT INTO `incident` (`id`, `ref`, `start_date`, `end_date`, `solved`, `dangerousness`, `archive`, `status`, `event_type_id`) VALUES
-- (1, 'I20210112095345', '2021-03-12 15:41:15', NULL, 0, 70, 0, 'À prendre en charge', 2),
-- (2, 'I20201225000645', '2021-03-12 15:45:24', NULL, 1, 30, 0, 'À prendre en charge', 1);

-- INSERT INTO `superbeing` (`id`, `ref`, `name`, `superhero`, `likability`, `active`, `event_participated_in`, `event_succeeded`, `event_failed`, `event_caused`, `arrest_number`, `collateral_damage_risk`, `dangerousness`, `discovered_at`, `treason_risk`, `affiliated`, `archive`) VALUES
-- (1, 'SH1', 'Hulk', 1, 75.25, 1, 238, 234, 4, 6, 6, 80.12, 30.55, '2021-03-12 11:25:16', 15, 1, 0),
-- (2, 'SV2', 'Crâne Rouge', 0, 0.8, 1, 0, 0, 0, 1175, 2, 98.01, 66.09, '2021-03-12 11:48:22', 100, 0, 0),
-- (3, 'SH2', 'Spiderman', 1, 98.12, 1, 127, 126, 1, 0, 0, 12.05, 2.05, '2021-03-12 11:54:53', 5, 1, 0);


-- INSERT INTO `superbeing_ability` (`ability_id`, `superbeing_id`) VALUES
-- (1, 1),
-- (2, 1),
-- (3, 1),
-- (4, 1),
-- (5, 1),
-- (8, 2),
-- (9, 2),
-- (1, 3),
-- (2, 3),
-- (3, 3),
-- (4, 3),
-- (6, 3),
-- (7, 3);


-- INSERT INTO `incident_linked_entity` (`id`, `incident_id`, `being_id`, `superbeing_id`, `employee_id`, `declared_by`, `redacted_by`) VALUES
-- (1, 2, 1, NULL, NULL, 1, NULL),
-- (2, 2, 7, NULL, NULL, NULL, 1),
-- (3, 2, NULL, 2, NULL, NULL, NULL),
-- (4, 1, 7, NULL, NULL, NULL, 1),
-- (5, 1, 3, NULL, NULL, 1, NULL),
-- (6, 1, NULL, 2, NULL, NULL, NULL);


-- INSERT INTO `location` (`id`, `planet`, `country`, `state`, `address`, `zipcode`, `coordinates`, `date`, `superbeing_id`, `being_id`, `incident_id`, `mission_id`, `litige_id`) VALUES
-- (1, 'Terre', 'Sokovia', NULL, NULL, NULL, NULL, '2021-03-12 16:48:35', 2, NULL, NULL, NULL, NULL),
-- (4, 'Terre', 'United States', 'NY', 'Central Park New York', '10028', '40°46\'44.7\"N 73°57\'45.0\"W', '2021-03-12 16:53:38', NULL, NULL, 2, NULL, NULL),
-- (5, 'Terre', 'United States', 'NY', 'Central Park New York', '10028', '40°46\'44.7\"N 73°57\'45.0\"W', '2021-03-12 16:53:38', NULL, NULL, 1, NULL, NULL),
-- (6, 'Terre', 'Sokovia', NULL, NULL, NULL, NULL, '2021-03-12 16:48:35', NULL, 12, NULL, NULL, NULL);



-- INSERT INTO `media` (`id`, `name`, `extension`, `media`, `ability_id`, `superbeing_id`, `being_id`, `litige_id`, `mission_id`, `incident_id`, `employee_id`) VALUES
-- (3, 'hydralogo', 'png', 'L1VzZXJzL2t1cmF6dWwvRG9jdW1lbnRzL0NvdXJzIENFU0kvUHJvamV0IEpBVkEvUsOpYWxpc2F0aW9uL2ltYWdlcy9oeWRyYWxvZ28ucG5n', NULL, NULL, 8, NULL, NULL, NULL, NULL);




INSERT INTO `ability` (`id`, `name`, `weakness`) VALUES
(1, 'Force', 0),
(2, 'Endurance', 0),
(3, 'Résistance', 0),
(4, 'Régénération', 0),
(5, 'Saut', 0),
(6, 'Réflexes', 0),
(7, 'Precognition', 0),
(8, 'Gaz létal', 0),
(9, 'Cube Cosmique', 0);


INSERT INTO `access_role` (`id`, `name`, `accreditation`) VALUES
(1, 'Directeur du S.H.I.E.L.D.', 0),
(2, 'Agent_1', 1),
(3, 'Agent_2', 2),
(4, 'Agent_3', 3),
(5, 'Éxtérieur', 4);


INSERT INTO `superbeing` (`id`, `ref`, `name`, `superhero`, `likability`, `active`, `event_participated_in`, `event_succeeded`, `event_failed`, `event_caused`, `arrest_number`, `collateral_damage_risk`, `dangerousness`, `discovered_at`, `treason_risk`, `affiliated`, `archive`) VALUES
(1, 'SH1', 'Hulk', 1, 75.25, 1, 238, 234, 4, 6, 6, 80.12, 30.55, '2021-03-12 11:25:16', 15, 1, 0),
(2, 'SV2', 'Crâne Rouge', 0, 0.8, 1, 0, 0, 0, 1175, 2, 98.01, 66.09, '2021-03-12 11:48:22', 100, 0, 0),
(3, 'SH2', 'Spiderman', 1, 98.12, 1, 127, 126, 1, 0, 0, 12.05, 2.05, '2021-03-12 11:54:53', 5, 1, 0);


INSERT INTO `superbeing_ability` (`ability_id`, `superbeing_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(8, 2),
(9, 2),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(6, 3),
(7, 3);

INSERT INTO `being` (`id`, `ref`, `organisation`, `malevolant`, `name`, `siret`, `title`, `firstname`, `lastname`, `gender`, `birthdate`, `deathdate`, `social_security_number`, `address`, `city`, `state`, `zipcode`, `country`, `mobile_phone`, `added_at`, `updated_at`, `how_many_declared_incident`, `victim_of_how_many_mission`, `archive`, `email`, `password`, `active`, `access_role_id`, `superbeing_id`) VALUES
(1, 'CV1321B32294', 0, 0, NULL, NULL, 'Mr', 'Pipriet Molenov', 'Radjasky', 'male', '2017-06-18 00:00:00', NULL, '1321B32294', '136 W 75th St ', 'New York', 'NY', '10023', 'United States', '+15555551234', '2021-03-11 00:00:00', '2021-03-11 16:52:03', 12, 1, 0, 'pipriet.theboss@gmail.com', 'CryptedMdp1!', 1, 5, NULL),
(2, 'SD1', 0, 0, NULL, NULL, 'Mr', 'Nick', 'Furys', 'male', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'United States', '+15512559283', '2021-03-11 00:00:00', '2021-03-11 00:00:00', 0, 0, 0, 'shield.director@shield.org', 'CryptedMdp1!', 1, 1, NULL),
(3, 'ORG54205118000066', 1, 0, 'Strategic Homeland Intervention Enforcement Logistics Division', '54205118000066', NULL, NULL, NULL, NULL, '2017-06-18 00:00:00', NULL, NULL, '45 Rockefeller Plaza', 'New York', 'NY', '10111', 'United States', '+15559999991', '2021-03-11 00:00:00', '2021-03-11 00:00:00', 0, 0, 0, 'contact@shield.org', NULL, 1, NULL, NULL),
(7, 'CV2321C32294', 0, 0, NULL, NULL, 'Mme', 'Joyce Elisabeth', 'Flores', 'female', '1989-02-19 00:00:00', NULL, '2321C32294', '52 Woodland Dr', 'Woodcliff Lake', 'NJ', '07677', 'United States', '+16549294775', '2021-03-11 17:24:39', '2021-03-11 17:24:39', 24, 3, 0, 'Joyce.flores@shield.org', 'CryptedMdp1!', 1, 4, NULL),
(8, 'EORG1', 1, 1, 'Hydra', NULL, NULL, NULL, NULL, NULL, '1939-04-02 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2021-03-11 17:41:19', '2021-03-11 17:41:19', 0, 0, 0, NULL, NULL, 1, NULL, NULL),
(9, 'CV1241B11131', 0, 0, NULL, NULL, 'Mr', 'Rijdika', 'Ramathaghana', 'male', '1973-05-29 00:00:00', NULL, '1241B11131', '669 Prospect Pl', 'Brooklyn', 'NY', '11216', 'United States', '+16549000175', '2021-03-11 17:24:39', '2021-03-11 17:24:39', 2, 21, 0, 'rijdirama73@gmail.com', 'CryptedMdp1!', 1, 3, NULL),
(10, 'CV1431B19977', 0, 0, NULL, NULL, 'Mr', 'Robert Bruce', 'Banner', 'male', '1962-05-01 00:00:00', NULL, '1431B19977', 'Avenger\'s Tower', 'New York', 'NY', '10029', 'United States', '+16549223275', '2021-03-11 18:07:33', '2021-03-11 18:07:33', 0, 0, 0, 'litlegreenman@shield.org', 'CryptedMdp1!', 1, 2, 1),
(11, 'CV1264D15509', 0, 0, NULL, NULL, 'Mr', 'Peter', 'Parker', 'male', '2001-08-10 00:00:00', NULL, '1264D15509', '11-05 44th Avenue', 'Long Island City', 'NY', '11101', 'United States', '+16522180462', '2021-03-11 20:55:21', '2021-03-11 20:55:21', 0, 0, 0, 'spidey@shield.com', 'CryptedMdp1!', 1, 3, 3),
(12, 'ECV12', 0, 1, NULL, NULL, 'Mr', 'Johann', 'Schmidt', NULL, '1899-01-01 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2021-03-12 10:46:45', '2021-03-12 10:46:45', 0, 0, 0, NULL, NULL, 1, NULL, 2);

INSERT INTO `civil_on_organisation` (`civil_id`, `organisation_id`) VALUES
(2, 3),
(7, 3),
(9, 3),
(10, 3),
(12, 8);

INSERT INTO `comment` (`id`, `comments`, `superbeing_id`, `being_id`, `access_role_id`, `employee_id`, `ability_id`, `employee_department_id`, `location_id`, `media_id`, `feedback_id`, `litige_id`, `event_type_id`, `incident_id`, `mission_id`) VALUES
(1, 'Directeur du shield. Dossier Secret Défense.', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Dr Bruce Banner, Spécialiste en Physique Nucléaire.', NULL, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Ancien Nazi fondateur de Hydra. Très dangereux.\r\nWANTED MORT OU VIF.', NULL, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'Personnes extérieure au S.H.I.E.L.D.', NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'Super Admin', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'Organisation dangereuse ayant infiltré différentes couches de la population dans plusieurs pays.\r\nSEARCH AND DESTROY.', NULL, 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO `employee_department` (`id`, `department`, `city`, `country`) VALUES
(1, 'Incident', 'New York', 'United States'),
(2, 'Direction General', 'New York', 'United States'),
(3, 'Mission', 'New York', 'United States');

INSERT INTO `employee` (`id`, `ref`, `function`, `start_date`, `end_date`, `active`, `contract`, `archive`, `email`, `password`, `being_id`, `employee_department_id`) VALUES
(1, 'A0012', 'Agent de déclaration d\'incident', '2021-03-12 13:00:16', NULL, 1, 'CDI', 0, 'joyce.flores@shield.incident.org', 'CryptedMdp1!', 7, 1),
(2, 'A0029', 'Agent d\'attribution de mission', '2021-03-12 13:06:02', NULL, 1, 'CDI', 0, 'rijdika.ramathaghana@shield.mission.org', 'CryptedMdp1!', 9, 3),
(3, 'A000', 'Directeur du Shield', '2021-03-12 13:12:23', NULL, 1, 'N/C', 0, 'nick.furys@shield.director.org', 'CryptedMdp1!', 2, 2);



INSERT INTO `event_type` (`id`, `name`) VALUES
(1, 'Cambriolage'),
(2, 'Attaque de Civils');

INSERT INTO `incident` (`id`, `ref`, `start_date`, `end_date`, `solved`, `dangerousness`, `archive`, `status`, `event_type_id`) VALUES
(1, 'I20210112095345', '2021-03-12 15:41:15', NULL, 0, 70, 0, 'À prendre en charge', 2),
(2, 'I20201225000645', '2021-03-12 15:45:24', NULL, 1, 30, 0, 'À prendre en charge', 1);



INSERT INTO `incident_linked_entity` (`id`, `incident_id`, `being_id`, `superbeing_id`, `employee_id`, `declared_by`, `redacted_by`) VALUES
(1, 2, 1, NULL, NULL, 1, NULL),
(2, 2, 7, NULL, NULL, NULL, 1),
(3, 2, NULL, 2, NULL, NULL, NULL),
(4, 1, 7, NULL, NULL, NULL, 1),
(5, 1, 3, NULL, NULL, 1, NULL),
(6, 1, NULL, 2, NULL, NULL, NULL);


INSERT INTO `location` (`id`, `planet`, `country`, `state`, `address`, `zipcode`, `coordinates`, `date`, `superbeing_id`, `being_id`, `incident_id`, `mission_id`, `litige_id`) VALUES
(1, 'Terre', 'Sokovia', NULL, NULL, NULL, NULL, '2021-03-12 16:48:35', 2, NULL, NULL, NULL, NULL),
(4, 'Terre', 'United States', 'NY', 'Central Park New York', '10028', '40°46\'44.7\"N 73°57\'45.0\"W', '2021-03-12 16:53:38', NULL, NULL, 2, NULL, NULL),
(5, 'Terre', 'United States', 'NY', 'Central Park New York', '10028', '40°46\'44.7\"N 73°57\'45.0\"W', '2021-03-12 16:53:38', NULL, NULL, 1, NULL, NULL),
(6, 'Terre', 'Sokovia', NULL, NULL, NULL, NULL, '2021-03-12 16:48:35', NULL, 12, NULL, NULL, NULL);



INSERT INTO `media` (`id`, `name`, `extension`, `media`, `ability_id`, `superbeing_id`, `being_id`, `litige_id`, `mission_id`, `incident_id`, `employee_id`) VALUES
(3, 'hydralogo', 'png', 'L1VzZXJzL2t1cmF6dWwvRG9jdW1lbnRzL0NvdXJzIENFU0kvUHJvamV0IEpBVkEvUsOpYWxpc2F0aW9uL2ltYWdlcy9oeWRyYWxvZ28ucG5n', NULL, NULL, 8, NULL, NULL, NULL, NULL);







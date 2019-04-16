SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `clinical_scheduler` DEFAULT CHARACTER SET utf8 ;
USE `clinical_scheduler` ;

CREATE TABLE IF NOT EXISTS `clinical_scheduler`.`appointments` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `date_time` DATE NULL,
  `appointment_kept` TINYINT NULL,
  `patient_id` BIGINT(20) NOT NULL,
  `doctor_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`, `patient_id`, `doctor_id`),
  INDEX `fk_Appointments_Patient Profile_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_appointments_doctor_profile1_idx` (`doctor_id` ASC) VISIBLE,
  CONSTRAINT `fk_Appointments_Patient Profile`
    FOREIGN KEY (`patient_id`)
    REFERENCES `clinical_scheduler`.`patient_profile` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointments_doctor_profile1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `clinical_scheduler`.`doctor_profile` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `clinical_scheduler`.`doctor_profile` (
  `doctor_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(10) NULL,
  `last_name` VARCHAR(20) NULL,
  `email` VARCHAR(35) NULL,
  `phone` INT(10) NULL,
  PRIMARY KEY (`doctor_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `clinical_scheduler`.`patient_profile` (
  `patient_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(10) NULL,
  `last_name` VARCHAR(20) NULL,
  `birthdate` DATE NULL,
  `email` VARCHAR(35) NULL,
  `phone` VARCHAR(10) NULL,
  PRIMARY KEY (`patient_id`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
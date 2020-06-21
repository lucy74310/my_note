-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema my_note
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema my_note
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `my_note` DEFAULT CHARACTER SET utf8 ;
USE `my_note` ;

-- -----------------------------------------------------
-- Table `my_note`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`member` (
  `member_id` VARCHAR(100) NOT NULL,
  `last_login_date` DATETIME NOT NULL,
  `c_passwd` VARCHAR(400) NULL,
  `c_name` VARCHAR(400) NULL,
  `c_phone` VARCHAR(400) NULL,
  `registered_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  `deleted_date` TIMESTAMP NULL,
  PRIMARY KEY (`member_id`),
  UNIQUE INDEX `member_id_UNIQUE` (`member_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_note`.`t_note`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`t_note` (
  `note_no` BIGINT NOT NULL AUTO_INCREMENT,
  `note_name` VARCHAR(100) NULL,
  `main_language` BIGINT NULL,
  `member_id` VARCHAR(100) NOT NULL,
  `registered_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  `deleted_date` TIMESTAMP NULL,
  `image_path` VARCHAR(200) NULL,
  PRIMARY KEY (`note_no`),
  INDEX `fk_note_member_idx` (`member_id` ASC),
  CONSTRAINT `fk_note_member`
    FOREIGN KEY (`member_id`)
    REFERENCES `my_note`.`member` (`member_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_note`.`t_word`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`t_word` (
  `word_no` BIGINT NOT NULL AUTO_INCREMENT,
  `contents` VARCHAR(400) NOT NULL,
  `note_no` BIGINT NULL,
  `image_path` VARCHAR(200) NULL,
  `language_no` BIGINT NOT NULL,
  `registered_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  `deleted_date` TIMESTAMP NULL,
  PRIMARY KEY (`word_no`),
  INDEX `fk_t_note_idx` (`note_no` ASC),
  CONSTRAINT `fk_t_note`
    FOREIGN KEY (`note_no`)
    REFERENCES `my_note`.`t_note` (`note_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_note`.`t_language`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`t_language` (
  `language_no` BIGINT NOT NULL AUTO_INCREMENT,
  `language_name` VARCHAR(400) NOT NULL,
  `is_custom` CHAR(1) NULL,
  `member_id` VARCHAR(100) NULL,
  `registered_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  `deleted_date` TIMESTAMP NULL,
  PRIMARY KEY (`language_no`),
  INDEX `fk_member_idx` (`member_id` ASC),
  CONSTRAINT `fk_member`
    FOREIGN KEY (`member_id`)
    REFERENCES `my_note`.`member` (`member_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_note`.`t_note_language`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`t_note_language` (
  `note_language_no` BIGINT NOT NULL AUTO_INCREMENT,
  `note_no` BIGINT NOT NULL,
  `language_no` BIGINT NOT NULL,
  `registered_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  `deleted_date` TIMESTAMP NULL,
  PRIMARY KEY (`note_language_no`),
  INDEX `fk_t_note_idx` (`note_no` ASC),
  INDEX `fk_t_language_idx` (`language_no` ASC),
  CONSTRAINT `fk_t_note`
    FOREIGN KEY (`note_no`)
    REFERENCES `my_note`.`t_note` (`note_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_language`
    FOREIGN KEY (`language_no`)
    REFERENCES `my_note`.`t_language` (`language_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_note`.`t_word_language`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`t_word_language` (
  `word_language_no` BIGINT NOT NULL AUTO_INCREMENT,
  `word_no` BIGINT NOT NULL,
  `contents` VARCHAR(400) NULL,
  `language_no` BIGINT NOT NULL,
  `registered_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  `deleted_date` TIMESTAMP NULL,
  PRIMARY KEY (`word_language_no`),
  INDEX `fk_t_language_idx` (`language_no` ASC),
  CONSTRAINT `fk_t_word`
    FOREIGN KEY (`word_no`)
    REFERENCES `my_note`.`t_word` (`word_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_language`
    FOREIGN KEY (`language_no`)
    REFERENCES `my_note`.`t_language` (`language_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
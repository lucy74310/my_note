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
  `regist_date` DATETIME NOT NULL,
  `last_login_date` DATETIME NOT NULL,
  `c_passwd` VARCHAR(100) NULL,
  `c_name` VARCHAR(100) NULL,
  `c_phone` VARCHAR(100) NULL,
  PRIMARY KEY (`member_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_note`.`note`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`note` (
  `note_no` INT NOT NULL AUTO_INCREMENT,
  `note_name` VARCHAR(100) NULL,
  `member_id` VARCHAR(100) NOT NULL,
  `regist_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`note_no`),
  INDEX `fk_note_member_idx` (`member_id` ASC),
  CONSTRAINT `fk_note_member`
    FOREIGN KEY (`member_id`)
    REFERENCES `my_note`.`member` (`member_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `my_note`.`word`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `my_note`.`word` (
  `word_no` INT NOT NULL AUTO_INCREMENT,
  `note_no` INT NULL,
  `word_en` VARCHAR(400) NOT NULL,
  `word_kr` VARCHAR(600) NOT NULL,
  `regist_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`word_no`),
  INDEX `fk_word_note1_idx` (`note_no` ASC),
  CONSTRAINT `fk_word_note1`
    FOREIGN KEY (`note_no`)
    REFERENCES `my_note`.`note` (`note_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
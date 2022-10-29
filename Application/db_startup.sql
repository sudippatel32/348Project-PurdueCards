-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema 348project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 348project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `348project` DEFAULT CHARACTER SET utf8 ;
USE `348project` ;

-- -----------------------------------------------------
-- Table `348project`.`Card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `348project`.`Card` ;

CREATE TABLE IF NOT EXISTS `348project`.`Card` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `set` VARCHAR(45) NOT NULL,
  `quantity` VARCHAR(45) NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `rarity` VARCHAR(45) NOT NULL,
  `foil` TINYINT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `348project`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `348project`.`Customer` ;

CREATE TABLE IF NOT EXISTS `348project`.`Customer` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `times_purchased` INT NOT NULL DEFAULT 0,
  `times_sold` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `348project`.`Sales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `348project`.`Sales` ;

CREATE TABLE IF NOT EXISTS `348project`.`Sales` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `buyer_ID` INT NOT NULL,
  `card_ID` INT NOT NULL,
  `profit` INT NOT NULL,
  `quantity` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `bought_from_idx` (`buyer_ID` ASC) VISIBLE,
  INDEX `card_bought_idx` (`card_ID` ASC) VISIBLE,
  CONSTRAINT `bought_from`
    FOREIGN KEY (`buyer_ID`)
    REFERENCES `348project`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `card_sold`
    FOREIGN KEY (`card_ID`)
    REFERENCES `348project`.`Card` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `348project`.`Purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `348project`.`Purchases` ;

CREATE TABLE IF NOT EXISTS `348project`.`Purchases` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `seller_id` INT NOT NULL,
  `card_ID` INT NOT NULL,
  `cost` INT NOT NULL,
  `quantity` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `Seller_idx` (`seller_id` ASC) VISIBLE,
  INDEX `card_bought_idx` (`card_ID` ASC) VISIBLE,
  CONSTRAINT `Seller`
    FOREIGN KEY (`seller_id`)
    REFERENCES `348project`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `card_bought`
    FOREIGN KEY (`card_ID`)
    REFERENCES `348project`.`Card` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `348project`.`Complaints`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `348project`.`Complaints` ;

CREATE TABLE IF NOT EXISTS `348project`.`Complaints` (
  `customer_ID` INT NOT NULL,
  `sale_ID` INT NOT NULL,
  `body` VARCHAR(400) NULL,
  PRIMARY KEY (`customer_ID`, `sale_ID`),
  INDEX `sale_idx` (`sale_ID` ASC) VISIBLE,
  CONSTRAINT `customer`
    FOREIGN KEY (`customer_ID`)
    REFERENCES `348project`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sale`
    FOREIGN KEY (`sale_ID`)
    REFERENCES `348project`.`Sales` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

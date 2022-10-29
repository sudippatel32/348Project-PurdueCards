-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PurdueCards
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PurdueCards
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PurdueCards` DEFAULT CHARACTER SET utf8 ;
USE `PurdueCards` ;

-- -----------------------------------------------------
-- Table `PurdueCards`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PurdueCards`.`Customer`;
CREATE TABLE IF NOT EXISTS `PurdueCards`.`Customer` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `times purchased` INT NULL DEFAULT 0,
  `tims sold` INT NULL DEFAULT 0,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PurdueCards`.`Cards`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PurdueCards`.`Cards`;
CREATE TABLE IF NOT EXISTS `PurdueCards`.`Cards` (
  `name` VARCHAR(100) NOT NULL,
  `set` VARCHAR(45) NOT NULL,
  `foiling` TINYINT NOT NULL,
  `quantity` INT NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `rarity` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`name`, `set`, `foiling`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PurdueCards`.`Sales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PurdueCards`.`Sales`;
CREATE TABLE IF NOT EXISTS `PurdueCards`.`Sales` (
  `ID` INT NOT NULL,
  `SellerID` INT NOT NULL,
  `profit` INT NOT NULL,
  `cardName` VARCHAR(100) NOT NULL,
  `cardSet` VARCHAR(45) NOT NULL,
  `cardFoil` TINYINT NOT NULL,
  `quantity` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `Seller_idx` (`SellerID` ASC) VISIBLE,
  INDEX `Card_idx` (`cardName` ASC, `cardSet` ASC, `cardFoil` ASC) VISIBLE,
  CONSTRAINT `Seller`
    FOREIGN KEY (`SellerID`)
    REFERENCES `PurdueCards`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Card`
    FOREIGN KEY (`cardName` , `cardSet` , `cardFoil`)
    REFERENCES `PurdueCards`.`Cards` (`name` , `set` , `foiling`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PurdueCards`.`Complaint`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PurdueCards`.`Complaint`;
CREATE TABLE IF NOT EXISTS `PurdueCards`.`Complaint` (
  `CustomerID` INT NOT NULL,
  `SaleID` INT NOT NULL,
  `Body` VARCHAR(400) NOT NULL,
  PRIMARY KEY (`CustomerID`, `SaleID`),
  INDEX `SaleID_idx` (`SaleID` ASC) VISIBLE,
  CONSTRAINT `CustomerID`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `PurdueCards`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SaleID`
    FOREIGN KEY (`SaleID`)
    REFERENCES `PurdueCards`.`Sales` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PurdueCards`.`Purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PurdueCards`.`Purchases`;
CREATE TABLE IF NOT EXISTS `PurdueCards`.`Purchases` (
  `ID` INT NOT NULL,
  `customerID` INT NOT NULL,
  `cardName` VARCHAR(100) NOT NULL,
  `cardSet` VARCHAR(45) NOT NULL,
  `cardFoil` TINYINT NOT NULL,
  `cost` INT NOT NULL,
  `quantity` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `purchaserID_idx` (`customerID` ASC) VISIBLE,
  INDEX `cardSold_idx` (`cardName` ASC, `cardSet` ASC, `cardFoil` ASC) VISIBLE,
  CONSTRAINT `purchaserID`
    FOREIGN KEY (`customerID`)
    REFERENCES `PurdueCards`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cardSold`
    FOREIGN KEY (`cardName` , `cardSet` , `cardFoil`)
    REFERENCES `PurdueCards`.`Cards` (`name` , `set` , `foiling`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

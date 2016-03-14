SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `is-dashboard` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `is-dashboard` ;

-- -----------------------------------------------------
-- Table `is-dashboard`.`KATEGORIAK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is-dashboard`.`KATEGORIAK` (
  `idKATEGORIAK` INT NOT NULL,
  `izena` VARCHAR(45) NULL,
  PRIMARY KEY (`idKATEGORIAK`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `is-dashboard`.`APLIKAZIOAK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `is-dashboard`.`APLIKAZIOAK` (
  `idAPLIKAZIOAK` INT NOT NULL,
  `izena` VARCHAR(45) NULL,
  `ikonoa` VARCHAR(45) NULL,
  `helbidea` VARCHAR(45) NULL,
  `kategoria` INT NULL,
  PRIMARY KEY (`idAPLIKAZIOAK`),
  INDEX `FK_KATEGORIA_idx` (`kategoria` ASC),
  CONSTRAINT `FK_KATEGORIA`
    FOREIGN KEY (`kategoria`)
    REFERENCES `is-dashboard`.`KATEGORIAK` (`idKATEGORIAK`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

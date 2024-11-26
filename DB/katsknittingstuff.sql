-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema katsknittingstuff
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `katsknittingstuff` ;

-- -----------------------------------------------------
-- Schema katsknittingstuff
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `katsknittingstuff` DEFAULT CHARACTER SET utf8 ;
USE `katsknittingstuff` ;

-- -----------------------------------------------------
-- Table `needlesandhooks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `needlesandhooks` ;

CREATE TABLE IF NOT EXISTS `needlesandhooks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `material` VARCHAR(45) NULL,
  `type` VARCHAR(45) NOT NULL,
  `length` DECIMAL NOT NULL,
  `US_size` VARCHAR(15) NOT NULL,
  `Metric_size` VARCHAR(15) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS kat@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'kat'@'localhost' IDENTIFIED BY 'kat';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'kat'@'localhost';
GRANT ALL ON * TO 'kat'@'localhost';
GRANT SELECT ON TABLE * TO 'kat'@'localhost';
GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'kat'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

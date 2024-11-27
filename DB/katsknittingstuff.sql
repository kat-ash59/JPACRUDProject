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
  `US_size` VARCHAR(15) NULL,
  `Metric_size` VARCHAR(15) NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS kat@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'kat'@'localhost' IDENTIFIED BY 'kat';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'kat'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `needlesandhooks`
-- -----------------------------------------------------
START TRANSACTION;
USE `katsknittingstuff`;
INSERT INTO `needlesandhooks` (`id`, `material`, `type`, `length`, `US_size`, `Metric_size`, `quantity`) VALUES (1, 'metal', 'interchangeable', 3.5, '10.5', '226.5', 1);
INSERT INTO `needlesandhooks` (`id`, `material`, `type`, `length`, `US_size`, `Metric_size`, `quantity`) VALUES (2, 'plastic', 'cable', 45, NULL, NULL, 1);

COMMIT;


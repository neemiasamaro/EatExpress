-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbdados
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbdados
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbdados` DEFAULT CHARACTER SET utf8 ;
USE `dbdados` ;

-- -----------------------------------------------------
-- Table `dbdados`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbdados`.`produtos` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(50) NOT NULL,
  `QUANTIDADE` INT NOT NULL,
  `DESCRICAO` VARCHAR(200) NULL DEFAULT 'Sem descrição.',
  `VALOR` DOUBLE NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dbdados`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbdados`.`usuarios` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(50) NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `SENHA` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `SENHA_UNIQUE` (`SENHA` ASC) VISIBLE,
  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dbdados`.`relatorios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbdados`.`relatorios` (
  `ID` INT NOT NULL,
  `USUARIOS_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_RELATORIOS_USUARIOS1_idx` (`USUARIOS_ID` ASC) VISIBLE,
  CONSTRAINT `fk_RELATORIOS_USUARIOS1`
    FOREIGN KEY (`USUARIOS_ID`)
    REFERENCES `dbdados`.`usuarios` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dbdados`.`vendas_has_produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbdados`.`vendas_has_produtos` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `PRODUTOS_ID` INT NOT NULL,
  `PRODUTOS_NOME` VARCHAR(50) NOT NULL,
  `VALOR_FINAL` DOUBLE NOT NULL,
  `CLIENTE_CPF` VARCHAR(11) NOT NULL,
  `FORMA_PAGAMENTO` VARCHAR(45) NOT NULL,
  `OBSERVACOES` VARCHAR(200) NULL,
  PRIMARY KEY (`ID`, `PRODUTOS_ID`),
  INDEX `fk_vendas_has_produtos_produtos1_idx` (`PRODUTOS_ID` ASC) VISIBLE,
  CONSTRAINT `fk_vendas_has_produtos_produtos1`
    FOREIGN KEY (`PRODUTOS_ID`)
    REFERENCES `dbdados`.`produtos` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dbdados`.`relatorios_has_produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbdados`.`relatorios_has_produtos` (
  `relatorios_ID` INT NOT NULL,
  `produtos_ID` INT NOT NULL,
  PRIMARY KEY (`relatorios_ID`, `produtos_ID`),
  INDEX `fk_relatorios_has_produtos_produtos1_idx` (`produtos_ID` ASC) VISIBLE,
  INDEX `fk_relatorios_has_produtos_relatorios1_idx` (`relatorios_ID` ASC) VISIBLE,
  CONSTRAINT `fk_relatorios_has_produtos_relatorios1`
    FOREIGN KEY (`relatorios_ID`)
    REFERENCES `dbdados`.`relatorios` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_relatorios_has_produtos_produtos1`
    FOREIGN KEY (`produtos_ID`)
    REFERENCES `dbdados`.`produtos` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;
USE DBDADOS;
ALTER TABLE vendas_has_produtos ADD produtos_nome varchar(50) AFTER produtos_id;
SELECT * FROM VENDAS_HAS_PRODUTOS;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE DBDADOS;

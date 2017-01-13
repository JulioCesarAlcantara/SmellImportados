SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `smell` ;
CREATE SCHEMA IF NOT EXISTS `smell` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `smell` ;

-- -----------------------------------------------------
-- Table `smell`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `smell`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `telefone1Usuario` VARCHAR(45) NOT NULL,
  `telefone2Usuario` VARCHAR(45) NULL,
  `emailUsuario` VARCHAR(45) NOT NULL,
  `tipoUsuario` ENUM('a', 'g', 'e', 'v', 'c') NOT NULL,
  `dataNascimentoUsuario` DATE NOT NULL,
  `sexoUsuario` VARCHAR(45) NOT NULL,
  `passwordUsuario` VARCHAR(45) NOT NULL,
  `cpfUsuario` VARCHAR(45) NULL,
  `enderecoUsuario` VARCHAR(45) NULL,
  `cepUsuario` VARCHAR(45) NULL,
  `cidadeUsuario` VARCHAR(20) NULL,
  `estadoUsuario` VARCHAR(2) NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smell`.`Produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`Produto` ;

CREATE TABLE IF NOT EXISTS `smell`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nomeProduto` VARCHAR(45) NOT NULL,
  `precoProduto` FLOAT NOT NULL,
  `descricaoProduto` VARCHAR(1000) NOT NULL,
  `categoriaProduto` ENUM('m','f') NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smell`.`Compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`Compra` ;

CREATE TABLE IF NOT EXISTS `smell`.`Compra` (
  `idCompra` INT NOT NULL AUTO_INCREMENT,
  `valorCompra` FLOAT NOT NULL,
  `freteCompra` FLOAT NOT NULL,
  `idUsuarioCompra` INT NOT NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_Compra_Usuario1_idx` (`idUsuarioCompra` ASC),
  CONSTRAINT `fk_Compra_Usuario1`
    FOREIGN KEY (`idUsuarioCompra`)
    REFERENCES `smell`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smell`.`ItemCompra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`ItemCompra` ;

CREATE TABLE IF NOT EXISTS `smell`.`ItemCompra` (
  `idItemCompra` INT NOT NULL AUTO_INCREMENT,
  `idCompraItemCompra` INT NOT NULL,
  `idProdutoItemCompra` INT NOT NULL,
  PRIMARY KEY (`idItemCompra`),
  INDEX `fk_Compra_has_Produto_Produto1_idx` (`idProdutoItemCompra` ASC),
  INDEX `fk_Compra_has_Produto_Compra1_idx` (`idCompraItemCompra` ASC),
  CONSTRAINT `fk_Compra_has_Produto_Compra1`
    FOREIGN KEY (`idCompraItemCompra`)
    REFERENCES `smell`.`Compra` (`idCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Produto_Produto1`
    FOREIGN KEY (`idProdutoItemCompra`)
    REFERENCES `smell`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smell`.`Promocao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`Promocao` ;

CREATE TABLE IF NOT EXISTS `smell`.`Promocao` (
  `idPromocao` INT NOT NULL AUTO_INCREMENT,
  `nomePromocao` VARCHAR(45) NOT NULL,
  `dataInicioPromocao` DATE NOT NULL,
  `dataFimPromocao` DATE NOT NULL,
  `descontoPromocao` FLOAT NOT NULL,
  `statusPromocao` ENUM('A','I') NOT NULL COMMENT 'A = Ativa\nI = Inativa',
  PRIMARY KEY (`idPromocao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smell`.`PalavrasChave`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`PalavrasChave` ;

CREATE TABLE IF NOT EXISTS `smell`.`PalavrasChave` (
  `idPalavrasChave` INT NOT NULL AUTO_INCREMENT,
  `palavra1` VARCHAR(45) NOT NULL,
  `palavra2` VARCHAR(45) NULL,
  `palavra3` VARCHAR(45) NULL,
  `idProduto` INT NOT NULL,
  PRIMARY KEY (`idPalavrasChave`),
  INDEX `fk_PalavrasChave_Produto1_idx` (`idProduto` ASC),
  CONSTRAINT `fk_PalavrasChave_Produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `smell`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smell`.`ProdutoPromocao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`ProdutoPromocao` ;

CREATE TABLE IF NOT EXISTS `smell`.`ProdutoPromocao` (
  `idProdutoProdutoPromocao` INT NOT NULL,
  `idPromocaoProdutoPromocao` INT NOT NULL,
  PRIMARY KEY (`idProdutoProdutoPromocao`, `idPromocaoProdutoPromocao`),
  INDEX `fk_Produto_has_Promocao_Promocao1_idx` (`idPromocaoProdutoPromocao` ASC),
  INDEX `fk_Produto_has_Promocao_Produto1_idx` (`idProdutoProdutoPromocao` ASC),
  CONSTRAINT `fk_Produto_has_Promocao_Produto1`
    FOREIGN KEY (`idProdutoProdutoPromocao`)
    REFERENCES `smell`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Promocao_Promocao1`
    FOREIGN KEY (`idPromocaoProdutoPromocao`)
    REFERENCES `smell`.`Promocao` (`idPromocao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smell`.`ImagemDeProduto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smell`.`ImagemDeProduto` ;

CREATE TABLE IF NOT EXISTS `smell`.`ImagemDeProduto` (
  `idImagemDeProduto` INT NOT NULL AUTO_INCREMENT,
  `imagem1` LONGBLOB NOT NULL,
  `imagem2` LONGBLOB NULL,
  `imagem3` LONGBLOB NULL,
  `idProduto` INT NOT NULL,
  PRIMARY KEY (`idImagemDeProduto`),
  INDEX `fk_ImagemDeProduto_Produto1_idx` (`idProduto` ASC),
  CONSTRAINT `fk_ImagemDeProduto_Produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `smell`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

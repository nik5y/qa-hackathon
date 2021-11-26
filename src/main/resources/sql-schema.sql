drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `ims`.`item` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(40) NOT NULL,
    `product_value` DECIMAL(6,2) NOT NULL,
	INDEX `product_name_idx` (`product_name` ASC) VISIBLE,
	INDEX `product_value_idx` (`product_value` ASC) VISIBLE,
    PRIMARY KEY (`id`)
);


CREATE TABLE `ims`.`order` (
  `oder_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `product_value` DECIMAL NOT NULL,
  PRIMARY KEY (`oder_id`),
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `ims`.`customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `ims`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_name`
    FOREIGN KEY (`product_name`)
    REFERENCES `ims`.`item` (`product_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_value`
    FOREIGN KEY (`product_value`)
    REFERENCES `ims`.`item` (`product_value`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


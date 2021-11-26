CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) NOT NULL,
    `item_price` DECIMAL(6 , 2 ) NOT NULL,
	INDEX `item_name_idx` (`item_name` ASC) VISIBLE,
    INDEX `item_price_idx` (`item_price` ASC) VISIBLE,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS  `ims`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`order_id`)
 );
	
CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
    `order_id` INT NOT NULL,
    `item_id` INT NOT NULL,
	`item_name` VARCHAR(45) NOT NULL,
	`item_price` DECIMAL NOT NULL,
    PRIMARY KEY (`order_id` , `item_id`)
);

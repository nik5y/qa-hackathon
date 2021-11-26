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


CREATE TABLE IF NOT EXISTS `ims`.`items` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `item_name` VARCHAR(40) NOT NULL,
    `item_price` DECIMAL(6,2) NOT NULL,
    INDEX `item_name_idx` (`item_name` ASC) VISIBLE,
    INDEX `item_price_idx` (`item_price` ASC) VISIBLE,
    PRIMARY KEY (`id`)
    );


CREATE TABLE IF NOT EXISTS`ims`.`order` (
                               `order_id` INT NOT NULL,
                               `customer_id` INT NOT NULL,
                               `item_id` INT NOT NULL,
                               `item_name` VARCHAR(45) NOT NULL,
                               `item_price` DECIMAL NOT NULL,
                               PRIMARY KEY (`order_id`),
                               INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
                               INDEX `item_id_idx` (`item_id` ASC) VISIBLE,
                               CONSTRAINT `customer_id`
                                   FOREIGN KEY (`customer_id`)
                                       REFERENCES `ims`.`customers` (`id`)
                                       ON DELETE NO ACTION
                                       ON UPDATE NO ACTION,
                               CONSTRAINT `item_id`
                                   FOREIGN KEY (`item_id`)
                                       REFERENCES `ims`.`items` (`id`)
                                       ON DELETE NO ACTION
                                       ON UPDATE NO ACTION,
                               CONSTRAINT `item_name`
                                   FOREIGN KEY (`item_name`)
                                       REFERENCES `ims`.`items` (`item_name`)
                                       ON DELETE NO ACTION
                                       ON UPDATE NO ACTION,
                               CONSTRAINT `item_price`
                                   FOREIGN KEY (`item_price`)
                                       REFERENCES `ims`.`items` (`item_price`)
                                       ON DELETE NO ACTION
                                       ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
    `order_id` INT NOT NULL,
    `item_id` INT NOT NULL,
    PRIMARY KEY (`order_id` , `item_id`),
    CONSTRAINT `order_id` FOREIGN KEY (`order_id`)
        REFERENCES `ims`.`order` (`order_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`item_id`)
        REFERENCES items (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
    
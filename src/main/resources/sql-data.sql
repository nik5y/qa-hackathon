INSERT INTO `ims`.`customers` (`first_name`, `surname`)
VALUES ('jordan', 'harrison'),
('Alexander', 'Bechamel'),
('ImAlways', 'Hungry'),
('CantStop', 'Shopping'),
('WontStop', 'Shopping'),
('EveryDay', 'BlackFriday'),
('Ariana', 'Grande');

INSERT INTO `ims`.`items` (`item_name`, `item_price`)
VALUES ('Excalibur,TheSword', '1333.3'),
('The Seekers Gemstone', '847.9'),
('Pegasus Patronus', '9001'),
('Heavens Goddess Tear', '777.7'),
('Joy N Happiness', '99.99'),
('An Apple', '0.3'),
('Memory Reset', '250.4'),
('It All', '100.00'),
('House', '25.00'),
('Car', '5000'),
('iPhone90X', '4999');

INSERT INTO `ims`.`order` (`order_id`, `customer_id`)
VALUES ('1', '3'),
('2', '4'),
('3', '1'),
('4', '4'),
('5', '5'),
('6', '1'),
('7', '2');

INSERT INTO `ims`.`order_items` (`order_id`, `item_id`, `item_name`, `item_price`)
VALUES ('1', '6', 'An Apple', '0.25'),
('2', '4', 'Heavens Goddess Tear', '777.77'),
('2', '5', 'Joy N Happiness', '99.99'),
('3', '2', 'The Seekers Gemstone', '847.99'),
('4', '1', 'Excalibur,TheSword', '1333.3'),
('5', '11', 'iPhone90X', '4999'),
('5', '9', 'House', '25.00'),
('6', '7', 'Memory Reset', '250.44'),
('7', '3', 'Pegasus Patronus', '9001');

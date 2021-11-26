Coverage: 34%
# Project IMS - Inventory Management System 


IMS is an inventory management system running through command line with CRUD functionality. 
There are three main entities of which can be created, updated, read and deleted. 
- Customer
- Order
- Item

## Functionality 

### Customer 
- In the customer entity inputting CREATE will ask the user to input a first name and a last name to create a new customer. 
- Inputting READ will retrieve the relevant record from teh database adn inform the user of the id, first name and surname.
- Inputting UPDATE the console will ask the user to input the ID of the record they wish to update and the user can update the record's first and surname. The console will then confirm that the record has been updated. 
- Inputting DELETE the console will ask the user to input the ID of the record they wish to delete and the record will then be deleted. 
- Inputting RETURN will take the user back to the main domain selection screen. 


### Item
- In the item entity inputting CREATE will ask the user to input an item name and the price to create a new item. 
- Inputting READ will retrieve of all the items and inform the user of the ids, item names and the prices. 
- Inputting UPDATE the console will ask the user to input the ID of the item they wish to update and the user can update the record's name and price. The console will then confirm that the record has been updated. 
- Inputting DELETE the console will ask the user to input the ID of the record they wish to delete and the record will then be deleted. 
- Inputting RETURN will take the user back to the main domain selection screen. 

### Order
- In the order entity inputting CREATE will ask the user to input an customer ID and will return confirmation of the new order being created. 
- Inputting READ will retrieve of all the orders and inform the user of the ids and the associated customer ID. 
- Inputting UPDATE the console will ask the user to input the Customer ID of the order they wish to update and the user can update the order's customer ID. The console will then confirm that the record has been updated. 
- Inputting DELETE the console will ask the user to input the ID of the irder they wish to delete and the relevant record will then be deleted. 


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
JDK - Java Development Kit
Mysql community server
```

### Installing

A step by step series of examples that tell you how to get a development env running

Clone the repository and set up IDE

```
Clone the repository via Git bash or within your relevant IDE. 
Set up the SDK for the project within your IDE 
For example within Intelij:
Go to File -> Project Structure -> Project -> Project SDK and select a relevant Java SDK. 
```

Set up MySQL database
```
Import the SQL schema into a MySQL database running locally on port 3306, or adjust in db.properties as required. 
The schema location is at src/main/resources/sql-schema.sql

```

Build the project
```
Build the project within your IDE. 
```

Run the runner
```
Run Runner.main() (src/main/java/com/qa/ims/Runner.java) within your IDE. 

```

## Running the tests

Test cases derived from user stories and manual verification. 

## Deployment

TBA

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

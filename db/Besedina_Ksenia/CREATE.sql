CREATE TABLE Customers(
login VARCHAR(45)  PRIMARY KEY NOT NULL,
password VARCHAR(45) NOT NULL,
e_mail VARCHAR(45) NOT NULL,
t_number VARCHAR(45) NOT NULL,
surname VARCHAR(45) NOT NULL,
name VARCHAR(45) NOT NULL,
patronymic VARCHAR(45),
address VARCHAR(45) NOT NULL,
date_of_b DATE VARCHAR(45) NOT NULL
);
CREATE TABLE Delivery(
id_orders INTEGER  PRIMARY KEY NOT NULL,
sum_weight FLOAT NOT NULL,
sum_volume FLOAT NOT NULL,
date_delivery DATE NOT NULL,
time_delivey TIME NOT NULL,
price_delivery DECIMAL(7,2) NOT NULL,
state VARCHAR(45) NOT NULL,
district VARCHAR(45) NOT NULL,
type_delivery VARCHAR(45) NOT NULL
);
CREATE TABLE Goods(
id_gds INTEGER PRIMARY KEY NOT NULL,
name_gts VARCHAR(45) NOT NULL,
specific TEXT,
price DECIMAL(7,2) NOT NULL,
weight FLOAT NOT NULL,
length FLOAT NOT NULL,
width FLOAT NOT NULL,
height FLOAT NOT NULL,
image MEDIUMBLOB,
category VARCHAR(45) NOT NULL,
subcategory VARCHAR(45) NOT NULL,
name_creator VARCHAR(45) NOT NULL,
FOREIGN KEY (name_creator) REFERENCES Procreator(name_creator)
);
CREATE TABLE Goods_Orders(
id_gts INTEGER NOT NULL,
id_orders  INTEGER NOT NULL,
FOREIGN KEY (id_gts) REFERENCES Goods(id_gts),
FOREIGN KEY (id_orders) REFERENCES Orders(id_orders)
);
CREATE TABLE Orders(
id_orders INTEGER  PRIMARY KEY NOT NULL,
login VARCHAR(45)  NOT NULL,
type_pay VARCHAR(45)  NOT NULL,
type_receipt VARCHAR(45)  NOT NULL,
sum_price FLOAT  NOT NULL,
date DATE  NOT NULL,
time TIME  NOT NULL,
state VARCHAR(45)  NOT NULL,
name_point VARCHAR(45),
FOREIGN KEY (name_point) REFERENCES Point(name_point),
FOREIGN KEY (login) REFERENCES Customers(login),
FOREIGN KEY (id_orders) REFERENCES Delivery(id_orders)
);
CREATE TABLE Point(
name_point VARCHAR(45) PRIMARY KEY NOT NULL,
addres VARCHAR(45) NOT NULL,
time_opening TIME NOT NULL,
time_closing TIME NOT NULL,
t_number VARCHAR(45) NOT NULL
);
CREATE TABLE Procreator(
name_creator VARCHAR(45) PRIMARY KEY NOT NULL,
t_number VARCHAR(20) NOT NULL,
fax VARCHAR(45) NOT NULL,
e_mail VARCHAR(200) NOT NULL,
price_list VARCHAR(45) NOT NULL
);
CREATE TABLE E_wallet(
id_wallet VARCHAR(30)  PRIMARY KEY NOT NULL,
login VARCHAR(45) NOT NULL,
FOREIGN KEY (login) REFERENCES Customers(login)
);
CREATE TABLE Credit_card(
id_card VARCHAR(30)  PRIMARY KEY NOT NULL,
login VARCHAR(45) NOT NULL,
pr_code VARCHAR(45) NOT NULL,
date_close DATE NOT NULL,
surname VARCHAR(45) NOT NULL,
name VARCHAR(45) NOT NULL,
patronymic  VARCHAR(45) NOT NULL,
FOREIGN KEY (login) REFERENCES Customers(login)
);
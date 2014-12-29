USE `tableapp`;



CREATE TABLE customers(
login VARCHAR(45) NOT NULL PRIMARY KEY,
password VARCHAR(45) NOT NULL,
e_mail VARCHAR(45),
t_number VARCHAR(45),
surname VARCHAR(45) NOT NULL,
name VARCHAR(45) NOT NULL,
patronymic VARCHAR(45) NOT NULL,
address VARCHAR(45) NOT NULL,
date_of_b DATE
);


CREATE TABLE delivery(
id_orders INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
sum_weight FLOAT UNSIGNED NOT NULL DEFAULT 0,
sum_volume FLOAT UNSIGNED NOT NULL DEFAULT 0,
date_delivery DATE NOT NULL,
price_delivery DECIMAL(7,2) UNSIGNED NOT NULL,
state VARCHAR(45) NOT NULL,
district VARCHAR(45) NOT NULL,
type_delivery VARCHAR(45) NOT NULL
);


CREATE TABLE credit_card(
id_card VARCHAR(30)  PRIMARY KEY NOT NULL,
login VARCHAR(45) NOT NULL,
pr_code VARCHAR(45) NOT NULL,
date_close DATE NOT NULL,
surname VARCHAR(45) NOT NULL,
name VARCHAR(45) NOT NULL,
patronymic  VARCHAR(45) NOT NULL,
FOREIGN KEY (login) REFERENCES customers(login)
);


CREATE TABLE procreator(
name_creator VARCHAR(45) PRIMARY KEY NOT NULL,
t_number VARCHAR(20) NOT NULL,
fax VARCHAR(45) NOT NULL,
e_mail VARCHAR(45) NOT NULL
);


CREATE TABLE goods (
  id_gds INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name_gds VARCHAR(45) NOT NULL,
  price DECIMAL(7,2) UNSIGNED NOT NULL,
  weight FLOAT UNSIGNED NOT NULL,
  length FLOAT UNSIGNED NOT NULL,
  width FLOAT UNSIGNED NOT NULL,
  height FLOAT UNSIGNED NOT NULL,
  category VARCHAR(45) NOT NULL,
  subcategory VARCHAR(45) NOT NULL,
  name_creator VARCHAR(45) NOT NULL,
  FOREIGN KEY (name_creator) REFERENCES procreator (name_creator)
);


CREATE TABLE point(
name_point VARCHAR(45) PRIMARY KEY NOT NULL,
addres VARCHAR(45) NOT NULL,
time_opening TIME NOT NULL,
time_closing TIME NOT NULL,
t_number VARCHAR(45) NOT NULL
);

CREATE TABLE orders(
id_orders INTEGER  AUTO_INCREMENT PRIMARY KEY NOT NULL,
login VARCHAR(45) NOT NULL,
type_pay VARCHAR(45) NOT NULL,
type_receipt VARCHAR(45) NOT NULL,
sum_price DECIMAL(7,2) UNSIGNED NOT NULL DEFAULT 0 ,
date DATE  NOT NULL,
state VARCHAR(15)  NOT NULL,
name_point VARCHAR(45),
FOREIGN KEY (name_point) REFERENCES point(name_point),
FOREIGN KEY (login) REFERENCES customers(login)
);

CREATE TABLE e_wallet(
id_wallet VARCHAR(30)  PRIMARY KEY NOT NULL,
login VARCHAR(45) NOT NULL,
FOREIGN KEY (login) REFERENCES customers(login)
);

CREATE TABLE goods_orders(
id_gds INTEGER,
id_orders INTEGER,
login VARCHAR(45) NOT NULL,
FOREIGN KEY (id_gds) REFERENCES goods(id_gds),
FOREIGN KEY (id_orders) REFERENCES orders(id_orders),
FOREIGN KEY (login) REFERENCES customers(login)
);

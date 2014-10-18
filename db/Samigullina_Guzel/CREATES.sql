CREATE TABLE Bakers(
id INTEGER not null primary key,
name VARCHAR(90) not null
);
CREATE TABLE Couriers(
id INTEGER not null primary key,
name VARCHAR(90) not null
);
CREATE TABLE Menu(
id INTEGER not null primary key,
name VARCHAR(90) not null,
price INTEGER ,
);
CREATE TABLE Customers(
id INTEGER not null primary key,
name VARCHAR(90) not null,
phoneNumber INTEGER,
address VARCHAR(80) not null
);
CREATE TABLE OrderStatus(
id INTEGER not null primary key,
status  VARCHAR(45) not null,
);
CREATE TABLE Orders(
id INTEGER not null primary key,
date DATETIME not null,
id_customers INTEGER not null REFERENCES Customers(id),
id_bakers INTEGER not null REFERENCES Bakers(id),
id_order_status INTEGER not null REFERENCES OrderStatus(id),
id_couriers INTEGER not null REFERENCES Couriers(id)
);
CREATE TABLE OrderedFood(
id INTEGER not null primary key,
fcount INTEGER not null,
id_orders INTEGER not null REFERENCES Orders(id),
id_menu INTEGER not null REFERENCES Menu(id),
);
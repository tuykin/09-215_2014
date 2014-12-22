create table clients(

id int not null identity,
name varchar(50) not null,
surname varchar(50) not null,
birthday date not null,
isStudent bit,
lastVisit date,
constraint pk_clients primary key(id)
);
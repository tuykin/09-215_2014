create table instructors(

id int not null identity,
name varchar(50) not null,
surname varchar(50) not null,
phoneNumber varchar(15),
constraint pk_instructors primary key(id)

);
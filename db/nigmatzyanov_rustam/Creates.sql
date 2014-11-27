create table STUDENTS (
id integer not null primary key,
sname varchar(50) not null,
name varchar(50) not null,
birthday date not null,
gender enum("m","f") not null,
faculty varchar(20) not null,
groupnum varchar(15) not null,
course integer default 1 not null check (course>0),
badgetype enum("bronze","silver","gold")
);


create table DISCIPLINES (
id integer not null primary key,
title varchar(30) not null,
bronze double not null check (bronze>0),
silver double not null check (silver>0),
gold double not null check (gold>0)
);

create table TESTS (
student_id integer not null,
discipline_id integer not null,
result double not null check (result>0),
constraint TESTS_STUDENTS foreign key (student_id) references Students(id) 
on delete cascade on update cascade,
constraint TESTS_DISCIPLINES foreign key (discipline_id) references Disciplines(id) 
on delete cascade on update cascade,
constraint unique_student_discipline unique (student_id, discipline_id)
);

create table ACCOUNTS (
student_id integer not null unique,
login varchar(20) not null unique,
password varchar(20) not null unique,
constraint ACCOUNTS_STUDENTS foreign key (student_id) references Students(id) 
on delete cascade on update cascade
);

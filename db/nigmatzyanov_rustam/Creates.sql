create table FACULTIES (
id integer unsigned not null,
name varchar(100) not null,
constraint FACULTIES_PK primary key (id)
);

create table STUDENTS (
id integer unsigned not null,
studentcard varchar(15) not null unique,
sname varchar(50) not null,
name varchar(30) not null,
patronymic varchar(30) not null,
birthday date not null,
gender enum("m","f") not null,
faculty_id integer unsigned not null,
groupnum varchar(15) not null,
course integer default 1 not null check (course>0),
badgetype enum("bronze","silver","gold"),
constraint STUDENTS_PK primary key (id),
constraint STUDENTS_FACULTIES foreign key (faculty_id) references Faculties(id) 
on delete cascade on update cascade
);

create table DISCIPLINES (
id integer unsigned not null,
title varchar(30) not null,
bronze double not null check (bronze>0),
silver double not null check (silver>0),
gold double not null check (gold>0),
constraint DISCIPLINES_PK primary key (id)
);

create table TESTS (
student_id integer unsigned not null,
discipline_id integer unsigned not null,
result double not null check (result>0),
constraint TESTS_STUDENTS foreign key (student_id) references Students(id) 
on delete cascade on update cascade,
constraint TESTS_DISCIPLINES foreign key (discipline_id) references Disciplines(id) 
on delete cascade on update cascade,
constraint unique_student_discipline unique (student_id, discipline_id)
);

create table ACCOUNTS (
student_id integer unsigned unique,
login varchar(20) not null unique,
password varchar(20) not null,
teacher boolean not null default 0,
constraint ACCOUNTS_STUDENTS foreign key (student_id) references Students(id) 
on delete cascade on update cascade
);

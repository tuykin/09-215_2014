create table STUDENTS (
id integer not null primary key,
fio varchar(70),
birthday date,
gender varchar(6),
faculty varchar(15),
groupnum integer,
course integer
);

create table DISCIPLINES (
id integer not null primary key,
name varchar(20),
bronze double,
silver double,
gold double
);

create table TESTS (
student_id integer references STUDENTS(id),
discipline_id integer references DISCIPLINES(id),
result double
);

create table BADGES (
student_id integer references STUDENTS(id),
badgetype varchar(6)
);

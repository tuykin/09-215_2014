Получить логины и пароли студентов и преподавателей
DELIMITER \\
CREATE PROCEDURE get_accounts()
BEGIN
select * from accounts;
END \\
DELIMITER ;

Получить студента по id
DELIMITER \\
CREATE PROCEDURE get_student_on_id(IN id_param integer)
BEGIN
select * from students
where id=id_param;
END \\
DELIMITER ;

Добавить студента КФУ, сдающего комплекс ГТО
DELIMITER \\
CREATE PROCEDURE insert_student(IN id integer, 
IN studentcard varchar(15), 
IN sname varchar(50), 
IN name varchar(30), 
IN patronymic varchar(30), 
IN birthday date,
IN gender varchar(1), 
IN faculty varchar(100), 
IN groupnum varchar(15), 
IN course integer)
BEGIN
insert into students values (id, studentcard, sname, name, patronymic, 
birthday, gender, faculty, groupnum, course, null);
END \\
DELIMITER ;

Получить информацию о студенте по № студенческого билета
DELIMITER \\
CREATE PROCEDURE get_student_on_studentcard(IN studentcard_param varchar(15))
BEGIN
select * from students
where studentcard=studentcard_param;
END \\
DELIMITER ;

Добавить результат сдачи комлпекса ГТО
DELIMITER \\
CREATE PROCEDURE insert_test(IN student_id integer, IN discipline_id integer, IN result double)
BEGIN
insert into tests values (student_id, discipline_id, result);
END \\
DELIMITER ;

Посмотреть список испытаний и соответствующие нормативы ДЛЯ МУЖЧИН
DELIMITER \\
CREATE PROCEDURE get_disciplines_for_men()
BEGIN
select title, bronze, silver, gold from disciplines
where id <= 5;
END \\
DELIMITER ;

Посмотреть список испытаний и соответствующие нормативы ДЛЯ ЖЕНЩИН
DELIMITER \\
CREATE PROCEDURE get_disciplines_for_women()
BEGIN
select title, bronze, silver, gold from disciplines
where id >= 6;
END \\
DELIMITER ;

Посмотреть информацию о студентах
DELIMITER \\
CREATE PROCEDURE get_students(
IN studentcard_p varchar(15), 
IN sname_p varchar(50), 
IN name_p varchar(30), 
IN patronymic_p varchar(30), 
IN birthday_p varchar(10),
IN gender_p varchar(1), 
IN faculty_p varchar(100), 
IN groupnum_p varchar(15), 
IN course_p integer,
IN badgetype_p varchar(6))
BEGIN
select * from students
where studentcard like CONCAT(studentcard_p, '%') AND
sname like CONCAT(sname_p, '%') AND
name like CONCAT(name_p, '%') AND
patronymic like CONCAT(patronymic_p, '%') AND
birthday like CONCAT(birthday_p, '%') AND
gender like CONCAT(gender_p, '%') AND
faculty like CONCAT(faculty_p, '%') AND
groupnum like CONCAT(groupnum_p, '%') AND
(course_p is null or course=course_p) AND
(badgetype_p='null' or badgetype like CONCAT(badgetype_p, '%'));
END \\ 
DELIMITER ;

Посмотреть результат сдачи комплекса ГТО отдельным студентом
DELIMITER \\
CREATE PROCEDURE get_results_on_studentid(IN student_id_param integer)
BEGIN
select title, result from tests t, disciplines d 
where t.discipline_id=d.id 
and t.student_id=student_id_param;
END \\
DELIMITER ;

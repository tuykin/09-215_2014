Обнуление поля "badgetype" у студента в таблице STUDENTS
DELIMITER \\
CREATE PROCEDURE students_badgetype_null(IN student_id_param integer)
BEGIN
update students set badgetype=null
where id=student_id_param;
END \\
DELIMITER ;

Назначение значка студенту мужского пола в таблице STUDENTS
1. Назначение бронзового значка
DELIMITER \\
CREATE PROCEDURE men_bronze_badgetype(IN student_id_param integer)
BEGIN
update students s set badgetype='bronze'
where s.id=student_id_param AND
s.gender='m' AND
(select count(*) from tests
 group by student_id
 having student_id=student_id_param) = 5 AND
(select result from tests
where discipline_id=1
group by student_id
having student_id=student_id_param) <= 15.1 AND
(select result from tests
where discipline_id=2
group by student_id
having student_id=student_id_param) <= 14 AND
(select result from tests
where discipline_id=3
group by student_id
having student_id=student_id_param) >= 215 AND
(select result from tests
where discipline_id=4
group by student_id
having student_id=student_id_param) >= 9 AND
(select result from tests
where discipline_id=5
group by student_id
having student_id=student_id_param) >= 6;
END \\
DELIMITER ;

2. Назначение серебряного значка
DELIMITER \\
CREATE PROCEDURE men_silver_badgetype(IN student_id_param integer)
BEGIN
update students s set badgetype='silver'
where s.id=student_id_param AND
s.gender='m' AND
(select count(*) from tests
 group by student_id
 having student_id=student_id_param) = 5 AND
(select result from tests
where discipline_id=1
group by student_id
having student_id=student_id_param) <= 14.8 AND
(select result from tests
where discipline_id=2
group by student_id
having student_id=student_id_param) <= 13.3 AND
(select result from tests
where discipline_id=3
group by student_id
having student_id=student_id_param) >= 230 AND
(select result from tests
where discipline_id=4
group by student_id
having student_id=student_id_param) >= 10 AND
(select result from tests
where discipline_id=5
group by student_id
having student_id=student_id_param) >= 7;
END \\
DELIMITER ;

3. Назначение золотого значка
DELIMITER \\
CREATE PROCEDURE men_gold_badgetype(IN student_id_param integer)
BEGIN
update students s set badgetype='gold'
where s.id=student_id_param AND
s.gender='m' AND
(select count(*) from tests
 group by student_id
 having student_id=student_id_param) = 5 AND
(select result from tests
where discipline_id=1
group by student_id
having student_id=student_id_param) <= 13.5 AND
(select result from tests
where discipline_id=2
group by student_id
having student_id=student_id_param) <= 12.3 AND
(select result from tests
where discipline_id=3
group by student_id
having student_id=student_id_param) >= 240 AND
(select result from tests
where discipline_id=4
group by student_id
having student_id=student_id_param) >= 13 AND
(select result from tests
where discipline_id=5
group by student_id
having student_id=student_id_param) >= 13;
END \\
DELIMITER ;

Назначение значка студенту женского пола в таблице STUDENTS
1. Назначение бронзового значка
DELIMITER \\
CREATE PROCEDURE women_bronze_badgetype(IN student_id_param integer)
BEGIN
update students s set badgetype='bronze'
where s.id=student_id_param AND
s.gender='f' AND
(select count(*) from tests
 group by student_id
 having student_id=student_id_param) = 5 AND
(select result from tests
where discipline_id=6
group by student_id
having student_id=student_id_param) <= 17.8 AND
(select result from tests
where discipline_id=7
group by student_id
having student_id=student_id_param) <= 11.35 AND
(select result from tests
where discipline_id=8
group by student_id
having student_id=student_id_param) >= 170 AND
(select result from tests
where discipline_id=9
group by student_id
having student_id=student_id_param) >= 10 AND
(select result from tests
where discipline_id=10
group by student_id
having student_id=student_id_param) >= 8;
END \\
DELIMITER ;

2. Назначение серебряного значка
DELIMITER \\
CREATE PROCEDURE women_silver_badgetype(IN student_id_param integer)
BEGIN
update students s set badgetype='silver'
where s.id=student_id_param AND
s.gender='f' AND
(select count(*) from tests
 group by student_id
 having student_id=student_id_param) = 5 AND
(select result from tests
where discipline_id=6
group by student_id
having student_id=student_id_param) <= 17.5 AND
(select result from tests
where discipline_id=7
group by student_id
having student_id=student_id_param) <= 11.15 AND
(select result from tests
where discipline_id=8
group by student_id
having student_id=student_id_param) >= 180 AND
(select result from tests
where discipline_id=9
group by student_id
having student_id=student_id_param) >= 12 AND
(select result from tests
where discipline_id=10
group by student_id
having student_id=student_id_param) >= 11;
END \\
DELIMITER ;

3. Назначение золотого значка
DELIMITER \\
CREATE PROCEDURE women_gold_badgetype(IN student_id_param integer)
BEGIN
update students s set badgetype='gold'
where s.id=student_id_param AND
s.gender='f' AND
(select count(*) from tests
 group by student_id
 having student_id=student_id_param) = 5 AND
(select result from tests
where discipline_id=6
group by student_id
having student_id=student_id_param) <= 16.5 AND
(select result from tests
where discipline_id=7
group by student_id
having student_id=student_id_param) <= 10.3 AND
(select result from tests
where discipline_id=8
group by student_id
having student_id=student_id_param) >= 195 AND
(select result from tests
where discipline_id=9
group by student_id
having student_id=student_id_param) >= 14 AND
(select result from tests
where discipline_id=10
group by student_id
having student_id=student_id_param) >= 16;
END \\
DELIMITER ;

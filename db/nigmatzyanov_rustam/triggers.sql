Триггеры для автоматического назначения значка студенту в таблице STUDENTS после 
добавления/изменения результата сдачи норматива в таблице TESTS

1. Триггер, который срабатывает после добавления записи в таблицу TESTS 
(вызываем процедуры "назначение значка" студенту)
DELIMITER \\
CREATE TRIGGER update_students_badgetype_on_insert
AFTER INSERT on tests
FOR EACH ROW BEGIN
call men_bronze_badgetype(new.student_id);
call men_silver_badgetype(new.student_id);
call men_gold_badgetype(new.student_id);
call women_bronze_badgetype(new.student_id);
call women_silver_badgetype(new.student_id);
call women_gold_badgetype(new.student_id);
END \\ 
DELIMITER ;

2. Триггер, который срабатывает после обновления записи в таблице TESTS
(вызываем процедуру "обнуление значка" и процедуры "назначение значка" студенту)
DELIMITER \\
CREATE TRIGGER update_students_badgetype_on_update
AFTER UPDATE on tests
FOR EACH ROW BEGIN
call students_badgetype_null(new.student_id);
call men_bronze_badgetype(new.student_id);
call men_silver_badgetype(new.student_id);
call men_gold_badgetype(new.student_id);
call women_bronze_badgetype(new.student_id);
call women_silver_badgetype(new.student_id);
call women_gold_badgetype(new.student_id);
END \\ 
DELIMITER ;

3. Триггер, который срабатывает после удаления записи из таблицы TESTS
(обнулить значок у студента в таблице STUDENTS)
DELIMITER \\
CREATE TRIGGER update_students_badgetype_on_delete
AFTER DELETE on tests
FOR EACH ROW BEGIN
call students_badgetype_null(old.student_id);
END \\ 
DELIMITER ;

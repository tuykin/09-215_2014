CREATE DATABASE university;

DROP TABLE IF EXISTS departments;
CREATE TABLE departments (
id INTEGER NOT NULL PRIMARY KEY,
name VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS groups;
CREATE TABLE groups (
id INTEGER NOT NULL PRIMARY KEY,
department_id INTEGER REFERENCES departments(id),
name VARCHAR(45) NOT NULL,
students_count INTEGER NOT NULL DEFAULT 0 CHECK(students_count >=0)
);

DROP TABLE IF EXISTS students;
CREATE TABLE students (
id INTEGER NOT NULL PRIMARY KEY,
surname VARCHAR(45) NOT NULL,
name VARCHAR(45) NOT NULL,
group_id INTEGER
);

DROP TRIGGER IF EXISTS update_students_count_on_update;
CREATE TRIGGER update_students_count_on_update
AFTER INSERT ON students
BEGIN
  UPDATE groups SET students_count = students_count + 1
  WHERE groups.id = NEW.group_id;
END;

DELIMITER \\
CREATE PROCEDURE test_proc()
BEGIN
SELECT *
FROM students;
END \\
DELIMITER ;

DELIMITER \\
CREATE PROCEDURE count_students_in_groups()
BEGIN
SELECT g.name, COUNT(*)
FROM students s INNER JOIN groups g ON g.id = s.group_id
GROUP BY g.id
END \\
DELIMITER ;

DELIMITER \\
CREATE PROCEDURE select_students_count_by_group_name(IN group_name VARCHAR(45))
BEGIN
SELECT g.name, COUNT(*)
FROM students s INNER JOIN groups g ON g.id = s.group_id
GROUP BY g.id
HAVING g.name LIKE CONCAT(group_name, '%');
END \\
DELIMITER ;

DELIMITER \\
CREATE PROCEDURE update_students_count_in_all_groups()
BEGIN
UPDATE groups g
SET g.students_count = (
    SELECT COUNT(*)
    FROM students s
    GROUP BY s.group_id
    HAVING s.group_id = g.id
    );
END \\
DELIMITER ;

DELIMITER \\
CREATE PROCEDURE update_students_count_in_group(IN group_id_param INTEGER)
BEGIN
UPDATE groups g
SET g.students_count = (
    SELECT COUNT(*)
    FROM students s
    GROUP BY s.group_id
    HAVING s.group_id = g.id
    )
WHERE g.id = group_id_param;
END \\
DELIMITER ;
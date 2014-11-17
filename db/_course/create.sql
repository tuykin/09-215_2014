PRAGMA foreign_keys=ON;

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


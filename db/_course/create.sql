PRAGMA foreign_keys=ON;

DROP TABLE departments;
CREATE TABLE departments (
id INTEGER NOT NULL PRIMARY KEY,
name VARCHAR NOT NULL
);

DROP TABLE groups;
CREATE TABLE groups (
id INTEGER NOT NULL PRIMARY KEY,
department_id INTEGER REFERENCES departments(id),
name VARCHAR NOT NULL,
students_count INTEGER NOT NULL DEFAULT 0,
);

DROP TABLE students;
CREATE TABLE students (
id INTEGER NOT NULL PRIMARY KEY,
surname VARCHAR NOT NULL,
name VARCHAR NOT NULL,
group_id INTEGER
);

DROP TRIGGER IF EXISTS update_students_count_on_update;
CREATE TRIGGER update_students_count_on_update
AFTER INSERT ON students
BEGIN
  UPDATE groups SET students_count = students_count + 1
  WHERE groups.id = NEW.group_id;
END;
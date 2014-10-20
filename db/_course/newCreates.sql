CREATE TABLE departments (
id INTEGER NOT NULL PRIMARY KEY,
name VARCHAR NOT NULL
);

CREATE TABLE groups (
id INTEGER NOT NULL PRIMARY KEY,
department_id INTEGER REFERENCES departments(id),
name VARCHAR NOT NULL,
count integer not null default 0 check(count>=0)
);

CREATE TABLE students (
id INTEGER NOT NULL PRIMARY KEY,
surname VARCHAR NOT NULL,
name VARCHAR NOT NULL,
group_id INTEGER references groups(id)
);

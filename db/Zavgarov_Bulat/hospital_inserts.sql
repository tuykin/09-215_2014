INSERT INTO `hospital`.`speciality`
(`name`)
VALUES
('Терапевт');

INSERT INTO `hospital`.`doctors`
(`first_name`,
`second_name`,
`speciality_id`)
VALUES
('Gregory','House',1);

INSERT INTO `hospital`.`patients`
(`first_name`,
`second_name`,
`polis_number`,
`birth_date`)
VALUES
('Завгаров','Булат','xxx-00-zz','1994-06-21');


INSERT INTO `hospital`.`medical_history`
(`patients_id`,
`doctors_id`,
`text`)
VALUES
(1,1,'Слабость в мозгах(со слов пациента)');

INSERT INTO `hospital`.`users`
(`username`,
`password`,
`doctors_id`)
VALUES
('doctor_house',
'doctor_house',
1);



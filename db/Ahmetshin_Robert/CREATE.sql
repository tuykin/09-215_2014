CREATE TABLE AgeGroups (
  `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))

CREATE TABLE Clients (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'unnamed',
  `surname` VARCHAR(45) NOT NULL DEFAULT 'unnamed',
  `birthday` DATE NULL,
  `isStudent` TINYINT(1) NOT NULL DEFAULT false,
  `lastVisit` DATE NULL,
  `phoneNumber` VARCHAR(12) NULL,
  PRIMARY KEY (`id`))

CREATE TABLE EndDates (
  `client_id` INT UNSIGNED NOT NULL,
  `section_id` INT UNSIGNED NOT NULL,
  `endDate` DATE NOT NULL,
  `typeOfSub_id` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`client_id`, `section_id`, `typeOfSub_id`),
  CONSTRAINT `client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `SportClub`.`Clients` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `section_id`
    FOREIGN KEY (`section_id`)
    REFERENCES `SportClub`.`Sections` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `typeOfSub_id`
    FOREIGN KEY (`typeOfSub_id`)
    REFERENCES `SportClub`.`TypesOfSub` (`id`))
CREATE Instructors (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(12) NULL,
  PRIMARY KEY (`id`))

CREATE TABLE InstructorsAndLessons (
  `instructor_id` INT UNSIGNED NOT NULL,
  `section_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`instructor_id`, `section_id`),
  CONSTRAINT `instructor_id`
    FOREIGN KEY (`instructor_id`)
    REFERENCES `SportClub`.`Instructors` (`id`)
  CONSTRAINT `section_id`
    FOREIGN KEY (`section_id`)
    REFERENCES `SportClub`.`Sections` (`id`))
CREATE TABLE NumbersOfLessons (
  `section_id` INT UNSIGNED NOT NULL,
  `client_id` INT UNSIGNED NOT NULL,
  `number` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`section_id`, `client_id`),
  CONSTRAINT `client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `SportClub`.`Clients` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `section_id`
    FOREIGN KEY (`section_id`)
    REFERENCES `SportClub`.`Sections` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)

CREATE TABLE Schedule(
  `section_id` INT UNSIGNED NOT NULL,
  `day` TINYINT UNSIGNED NULL,
  `time` TIME NULL,
  PRIMARY KEY (`section_id`),
  CONSTRAINT `section_id`
    FOREIGN KEY (`section_id`)
    REFERENCES `SportClub`.`Sections` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
CREATE TABLE Sections (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'unnamed',
  `ageGroup_id` TINYINT UNSIGNED NOT NULL DEFAULT 1,
  `currPeopCount` INT UNSIGNED NULL,
  `maxPeopCount` INT UNSIGNED NULL,
  `price` INT UNSIGNED NULL,
  `isSched` TINYINT(1) NULL,
  PRIMARY KEY (`id`, `ageGroup_id`),
  CONSTRAINT `ageGroup_id`
    FOREIGN KEY (`ageGroup_id`)
    REFERENCES `SportClub`.`AgeGroups` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)

CREATE TABLE TypesOfSub (
  `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))

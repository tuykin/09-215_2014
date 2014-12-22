CREATE TABLE IF NOT EXISTS `hospital`.`patients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `polis_number` VARCHAR(45) NOT NULL,
  `birth_date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hospital`.`speciality` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hospital`.`users` (
  `username` VARCHAR(150) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `doctors_id` INT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_users_doctors1_idx` (`doctors_id` ASC),
  UNIQUE INDEX `doctors_id_UNIQUE` (`doctors_id` ASC),
  CONSTRAINT `fk_users_doctors1`
    FOREIGN KEY (`doctors_id`)
    REFERENCES `hospital`.`doctors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hospital`.`doctors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `speciality_id` INT NOT NULL,
  PRIMARY KEY (`id`, `speciality_id`),
  INDEX `fk_doctors_speciality_idx` (`speciality_id` ASC),
  CONSTRAINT `fk_doctors_speciality`
    FOREIGN KEY (`speciality_id`)
    REFERENCES `hospital`.`speciality` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hospital`.`medical_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patients_id` INT NOT NULL,
  `doctors_id` INT NOT NULL,
  `text` LONGTEXT NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_medical_history_patients1_idx` (`patients_id` ASC),
  INDEX `fk_medical_history_doctors1_idx` (`doctors_id` ASC),
  CONSTRAINT `fk_medical_history_patients1`
    FOREIGN KEY (`patients_id`)
    REFERENCES `hospital`.`patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medical_history_doctors1`
    FOREIGN KEY (`doctors_id`)
    REFERENCES `hospital`.`doctors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

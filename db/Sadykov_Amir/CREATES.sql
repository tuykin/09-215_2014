CREATE TABLE brands (
  id INT NOT NULL AUTO_INCREMENT,
  brand VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE models (
  id INT NOT NULL AUTO_INCREMENT,
  brands_id INT NOT NULL,
  model VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_models_brands
    FOREIGN KEY (brands_id)
    REFERENCES brands (id)
    );
    CREATE TABLE vehicles (
  vin CHAR(17) NOT NULL,
  models_id INT NOT NULL,
  type VARCHAR(45) NOT NULL,
  category CHAR(1) NOT NULL,
  date DATE NOT NULL,
  engine_model VARCHAR(10) NOT NULL,
  engine_num VARCHAR(10) NOT NULL,
  body VARCHAR(25) NOT NULL,
  color VARCHAR(10) NOT NULL,
  engine_power VARCHAR(8) NOT NULL,
  engine_capacity VARCHAR(12) NOT NULL,
  passport VARCHAR(12) NOT NULL,
  max_weight VARCHAR(5) NOT NULL,
  weight VARCHAR(5) NOT NULL,
  models_has_brandscol VARCHAR(45) NOT NULL,
  PRIMARY KEY (vin),
  CONSTRAINT fk_vehicles_models
    FOREIGN KEY (models_id)
    REFERENCES models (id)
    );
    CREATE TABLE people (
  id INT NOT NULL AUTO_INCREMENT,
  surname VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  patronymic VARCHAR(45) NULL,
  birthday DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  TIN CHAR(12) NOT NULL,
  PRIMARY KEY (id)
  );


CREATE TABLE fines (
  id INT NOT NULL AUTO_INCREMENT,
  offence VARCHAR(100) NOT NULL,
  amount INT NOT NULL,
  PRIMARY KEY (id)
  );
  CREATE TABLE people_has_fines (
  protocol_number INT NOT NULL AUTO_INCREMENT,
  people_id INT NOT NULL,
  fines_id INT NOT NULL,
  date DATE NOT NULL,
  PRIMARY KEY (protocol_number),
  CONSTRAINT fk_people
    FOREIGN KEY (people_id)
    REFERENCES people (id),
  CONSTRAINT fk_fines
    FOREIGN KEY (fines_id)
    REFERENCES fines (id)
    );
CREATE TABLE driver_licenses (
  number INT NOT NULL AUTO_INCREMENT,
  people_id INT NOT NULL,
  date DATE NOT NULL,
  place VARCHAR(45) NOT NULL,
  category VARCHAR(45) NOT NULL,
  first_license DATE NULL,
  PRIMARY KEY (number),
  CONSTRAINT fk_people_license
    FOREIGN KEY (people_id)
    REFERENCES people (id)
    );
   CREATE TABLE registered_vehicles (
  number INT NOT NULL,
  series CHAR(2) NOT NULL,
  people_id INT NOT NULL,
  reg_mark CHAR(6) NOT NULL,
  vehicles_vin CHAR(17) NOT NULL,
  location VARCHAR(45) NOT NULL,
  date DATE NOT NULL,
  region TINYINT NOT NULL,
  PRIMARY KEY (number, series),
  CONSTRAINT fk_registered_vehicles_vin
    FOREIGN KEY (vehicles_vin)
    REFERENCES vehicles (vin),
  CONSTRAINT fk_registered_vehicles_people
    FOREIGN KEY (people_id)
    REFERENCES people (id)
    ); 
    CREATE TABLE stolen_vehicles (
  registered_vehicles_number INT NOT NULL,
  registered_vehicles_series CHAR(2) NOT NULL,
  date DATE NOT NULL,
  PRIMARY KEY (registered_vehicles_number, registered_vehicles_series),
  CONSTRAINT fk_stolen_vehicles_registered_vehicles1
    FOREIGN KEY (registered_vehicles_number , registered_vehicles_series)
    REFERENCES registered_vehicles (number , series)
  );

CREATE TABLE inspec (
  id INT NOT NULL AUTO_INCREMENT,
  date_of_next DATE NOT NULL,
  registered_vehicles_number INT NOT NULL,
  registered_vehicles_series CHAR(2) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_inspec_vehicle
    FOREIGN KEY (registered_vehicles_number , registered_vehicles_series)
    REFERENCES registered_vehicles (number , series)
    );
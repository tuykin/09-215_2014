-- -----------------------------------------------------
-- Table MODELS
-- ----------------------------------------------------- 
CREATE  TABLE MODELS ( MARK  VARCHAR(15) NOT NULL , MODEL  VARCHAR(10) NOT NULL , DVERI  INT NOT NULL , KUZOV  VARCHAR(15) NOT NULL , ID_MODEL  INT NOT NULL , 
 PRIMARY KEY (ID_MODEL) ) 
-- -----------------------------------------------------
-- Table KOMPL
-- ----------------------------------------------------- 
CREATE  TABLE KOMPL ( idKOMPL  INT NOT NULL , Y_NAME  VARCHAR(30) NOT NULL , Y_PRIMECHANIE  VARCHAR(100) NULL , MARK_ID  INT NOT NULL ,
 PRIMARY KEY (idKOMPL) ) 
-- -----------------------------------------------------
-- Table CUSTOMERS
-- ----------------------------------------------------- 
CREATE  TABLE CUSTOMERS ( CUST_ID INT NOT NULL , CUST_FNAME VARCHAR(20) NOT NULL , CUST_LNAME VARCHAR(20) NOT NULL , CUST_PASP INT NOT NULL , CUST_VIDAN VARCHAR(30) NOT NULL , CUST_DATA  DATE NOT NULL , CUST_NUMBER  INT NOT NULL ,
 PRIMARY KEY (CUST_ID) 
-- -----------------------------------------------------
-- Table MANAGERS
-- ----------------------------------------------------- 
CREATE  TABLE MANAGERS ( MANAG_ID INT NOT NULL , MANAG_FNAME  VARCHAR(30) NOT NULL , MANAG_LNAME  VARCHAR(25) NOT NULL , MANAG_PASP  INT NOT NULL , MANAG_VIDAN  VARCHAR(40) NOT NULL , MANAG_DATA  DATE NOT NULL , MANAG_SEX  CHAR(1) NOT NULL , 
PRIMARY KEY (MANAG_ID) )
-- -----------------------------------------------------
-- Table ORDERS
-- ----------------------------------------------------- 
CREATE  TABLE ORDERS ( AUTO_ORDER  INT NOT NULL , ORDER_CUST  INT NOT NULL , ORDER_MANAG INT NOT NULL , ORDER_OFORM  DATE NOT NULL , ORDER_SROK  INT NOT NULL , ORDER_KONEC  DATE NOT NULL ,
PRIMARY KEY (AUTO_ORDER) ,
  CONSTRAINT  fk_customers
 FOREIGN KEY (ORDER_CUST ) REFERENCES CUSTOMERS (CUST_ID )
  CONSTRAINT fk_manag
  FOREIGN KEY (ORDER_MANAG)  REFERENCES MANAGERS (MANAG_ID)
-- -----------------------------------------------------
-- Table COLORS
-- ----------------------------------------------------- 
CREATE  TABLE COLORS ( COLOR_ID  INT NOT NULL , COLOR_NAME  VARCHAR(45) NOT NULL , PRIMARY KEY (COLOR_ID) ) 
-- -----------------------------------------------------
-- Table AUTO
-- ----------------------------------------------------- 
CREATE  TABLE AUTO ( AUTO_ID  INT NOT NULL , AUTO_ORDER  INT NOT NULL , idKOMPL  INT NOT NULL , COLOR_ID  INT NOT NULL , ID_MODEL  INT NOT NULL , PRICE  INT NULL , PRIMARY KEY (AUTO_ID) , 
CONSTRAINT  fk_orders FOREIGN KEY (AUTO_ORDER ) REFERENCES ORDERS (AUTO_ORDER ) 
CONSTRAINT  fk_color  FOREIGN KEY (COLOR_ID) REFERENCES COLORS (COLOR_ID )
CONSTRAINT  fk_kompl FOREIGN KEY (idKOMPL ) REFERENCES KOMPL (idKOMPL ) 
CONSTRAINT  fk_models FOREIGN KEY (ID_MODEL) REFERENCES MODELS (ID_MODEL ) 

CREATE PROCEDURE registration
@number INT,
@series CHAR(2),
@reg_mark CHAR(6),
@location VARCHAR(45),
@date date,
@region tinyint,
@vin CHAR(17),
@people_id INT,
@result INT OUTPUT

AS
BEGIN
SET @result=1
if @vin IN(SELECT registrations.vehicles_vin
 FROM registrations WHERE registrations.vehicles_vin=@vin)
 BEGIN
 SET @result=0
 END
 if @people_id IN(SELECT registrations.people_id
 FROM registrations WHERE registrations.people_id=@people_id)
 BEGIN
 SET @result=0
 END
 if @result=1
 BEGIN
INSERT INTO registrations 
VALUES(@number,@series,@people_id,@reg_mark,@vin,@location,@date,@region)
END
END
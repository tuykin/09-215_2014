CREATE PROCEDURE is_registred_car
@vin CHAR(17),
@result INT OUTPUT
AS
BEGIN 
SET @result=0
IF (@vin IN(SELECT registrations.vehicles_vin 
FROM registrations
WHERE registrations.vehicles_vin=@vin))
BEGIN
SET @result=1
END
END
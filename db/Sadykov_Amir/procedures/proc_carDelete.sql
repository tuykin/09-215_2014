CREATE PROCEDURE car_delete
@vin CHAR(17)
AS
BEGIN 
UPDATE vehicles SET
is_deleted=1
WHERE vin=@vin
END

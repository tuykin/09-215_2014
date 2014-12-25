CREATE PROCEDURE insert_stolen
@vin CHAR(17)
AS
BEGIN 
INSERT INTO stolen_vehicles 
VALUES((SELECT registrations.number FROM registrations
WHERE registrations.vehicles_vin=@vin),(SELECT registrations.series FROM registrations
WHERE registrations.vehicles_vin=@vin),GETDATE(),0)

END
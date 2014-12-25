CREATE PROCEDURE findcar
@vin CHAR(17)
AS
BEGIN 
SELECT vin, brands.brand,models.model, type, category, date, engine_model, engine_num, body, color, engine_power, engine_capacity, passport, max_weight, weight, is_deleted
 FROM vehicles, models, brands
WHERE   is_deleted = 0
AND models_id=models.id
AND models.brands_id=brands.id
AND vin=@vin

END
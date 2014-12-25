CREATE PROCEDURE model_combobox
@brand VARCHAR(45)
AS
BEGIN 
SELECT models.model
FROM models,brands
WHERE models.brands_id=brands.id
AND brands.brand=@brand

END

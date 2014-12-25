CREATE PROCEDURE car_insert
@vin CHAR(17),
@brand VARCHAR(45),
@model VARCHAR(45),
@type VARCHAR(45),
@category CHAR(1),
@date date,
@engine_model VARCHAR(10),
@engine_num VARCHAR(10),
@body VARCHAR(25),
@color VARCHAR(10),
@engine_power VARCHAR(10),
@engine_capacity VARCHAR(12),
@passport VARCHAR(12),
@max_weight VARCHAR(5),
@weight VARCHAR(5),
@is_deleted BIT

AS
BEGIN 

INSERT INTO vehicles VALUES(@vin,(SELECT models.id FROM models,brands
             WHERE models.brands_id=brands.id
			 AND models.model=@model
			 AND brands.brand=@brand),@type,@category,@date,@engine_model,@engine_num,@body,@color,@engine_power,@engine_capacity,@passport,@max_weight,@weight,@is_deleted)

END

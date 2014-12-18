create view models_brands_view("марка","модель")
as Select  brand, model 
from models,brands
where models.brands_id=brands.id;
CREATE TRIGGER delete_orders AFTER DELETE on Orders
FOR EACH ROW
DELETE FROM  orderedFood
    WHERE orderedFood.id_orders = old.id;
	

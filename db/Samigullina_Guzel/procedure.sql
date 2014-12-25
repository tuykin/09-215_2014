delimiter \\
CREATE PROCEDURE info_order(IN current_id INTEGER, IN current_id_or INTEGER)
BEGIN
SELECT fcount, id_menu
FROM orders,orderedfood where orders.id=current_id_or AND current_id_or=orderedfood.id_orders AND orders.id_customers=current_id;
END\\

delimiter \\
CREATE PROCEDURE load_table()
BEGIN
SELECT * FROM orders;

END\\

delimiter \\
CREATE PROCEDURE sum(in id INTEGER)
BEGIN
SELECT sum(orderedFood.fcount*menu.price)
from menu,orderedFood 
where orderedFood.id_menu = menu.id and orderedFood.id_orders = id;
END\\

delimiter \\
CREATE PROCEDURE update_table(IN ti integer,IN tdate datetime,IN tcustomer_id integer ,
IN tcourier_id integer,IN tbaker_id integer,IN tstatus_id integer)
BEGIN
UPDATE orders SET date=tdate, id_customers =tcustomer_id,
                    id_bakers=tbaker_id, id_order_status=tstatus_id, id_couriers=tcourier_id
 WHERE id=i;
END\\



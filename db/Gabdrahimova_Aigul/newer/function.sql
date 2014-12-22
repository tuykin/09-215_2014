/*
Функционал:
1. Авторизация
-диспетчер
-клиент
Клиент
2. Выводит информацию о рейсах всех (ввиде расписание)
3. Вывод информацию о полетах  клиента.
4. Вывод информации о время отлета указанного рейса
5. Выводить все самолеты в указанном направлении 
6. Вывод информацию о вылетах клиента.
7. Вывод информации о время прилета указанного рейса
Диспетчер
7. Продажа билетов на рейс (добавляет новый заказ на рейс в базу) 
8. Редактирование расписания (удаление и добавление) 
9. Подсчет количество забронированных и оплаченных билетов на рейс
10. Регистрация пассажиров (смена статуса пассажира)
11. Информация о билетах по фамилии клиента 
12. Информация о билете(клиенте) по номер билета
13. Выводит информацию о билетах всех (ввиде большой сводной таблицы)
*/
use `port`;
CREATE TRIGGER delete_flies AFTER DELETE on Flies
FOR EACH ROW
DELETE FROM  Tickets
    WHERE Tickets.FliesId = old.id;

CREATE TRIGGER delete_orders AFTER DELETE on Orders
FOR EACH ROW
DELETE FROM  Tickets
    WHERE Tickets.OrdersId = old.id;

CREATE TRIGGER date_tickets BEFORE INSERT ON Tickets 
FOR EACH ROW 
SET NEW.DateFly = NOW();

DELIMITER \\
/*Выводит информацию о рейсах всех (ввиде расписание)*/
CREATE PROCEDURE info_all_flies()
BEGIN
SELECT p.PilotId, p.AmountPlace, f.NumberFly, f.FromWhere, f.ToWhere, f.Price, f.TimeInFly, f.Time
FROM Flies f LEFT JOIN Plane p ON f.PlaneId=p.Id
ORDER BY f.NumberFly;
END
\\
DELIMITER ;

DELIMITER \\
/*Выводит информацию о билетах всех (ввиде большой сводной таблицы)*/
CREATE PROCEDURE info_all_ticket()
BEGIN
SELECT f.NumberFly, f.FromWhere, f.ToWhere, f.Price, f.TimeInFly, 
f.Time, t.DateFly,t.Place, r.State, o.SurName, o.Name, o.MiddleName, o.SeriaPasport, o.NumberPasport, o.Birthday
FROM Flies f,Orders o,Tickets t, Registration r 
				WHERE (t.FliesId=f.id)&&(o.id = t.OrderId)&&(r.TicketId=t.Id)
                ORDER BY t.DateFly Desc;
END
\\
DELIMITER ;

DELIMITER \\
/*Вывод информацию о полетах клиента.*/
CREATE  PROCEDURE info_fly(IN order_name VARCHAR(45),IN order_surname VARCHAR(45))
BEGIN
SELECT f.NumberFly, f.FromWhere, f.ToWhere, f.Price, 
f.TimeInFly, f.Time
FROM Flies f
INNER JOIN 
(SELECT  t.FliesId 
FROM (SELECT id
   from Orders  WHERE 
   Orders.Name LIKE CONCAT(order_name , '%') &&
   Orders.SurName LIKE CONCAT(order_surname, '%')) AS q
   INNER JOIN Tickets t  ON q.id = t.OrderId 
   ORDER BY  t.DateFly DESC) AS w
   ON w.FliesId=f.Id 
;
END
\\ DELIMITER ;

DELIMITER \\
/*Вывод информацию о вылетах клиента.*/
CREATE  PROCEDURE info_flying (IN order_name VARCHAR(45),IN order_surname VARCHAR(45))
BEGIN
SELECT t.Date,t.Place
FROM Tickets f
INNER JOIN 
(SELECT  t.Id 
FROM (SELECT id
   from Orders  WHERE 
   Orders.Name LIKE CONCAT(order_name , '%') &&
   Orders.SurName LIKE CONCAT(order_surname, '%')) AS q
   INNER JOIN Tickets t  ON q.id = t.OrderId 
   ORDER BY  t.DateFly DESC) AS w
   ON f.Id=w.id
;
END
\\ DELIMITER ;

DELIMITER \\
/*Вывод информации о время отлета указанного рейса*/
CREATE PROCEDURE at_time(IN fly int)
BEGIN
SELECT  f.Time
FROM Flies f   
WHERE f.Id=fly;
END \\
DELIMITER ;

DELIMITER \\
/*Выводить все самолеты в указанном направлении */
CREATE PROCEDURE at_direction(IN to_fly VARCHAR(45))
BEGIN
SELECT  f.NumberFly, f.FromWhere, f.ToWhere, f.Price, f.TimeInFly, f.Time
FROM Flies f   
HAVING f.ToWhere LIKE CONCAT(to_fly, '%');
END \\
DELIMITER ;


DELIMITER \\
/*Информация о билетах по фамилии клиента .*/
CREATE  PROCEDURE info_fly(IN order_name VARCHAR(45),IN order_surname VARCHAR(45))
BEGIN
SELECT f.NumberFly, f.FromWhere, f.ToWhere, f.Price, 
f.TimeInFly, f.Time
FROM Flies f
INNER JOIN 
(SELECT  t.FliesId 
FROM (SELECT id
   from Orders  WHERE 
   Orders.Name LIKE CONCAT(order_name , '%') &&
   Orders.SurName LIKE CONCAT(order_surname, '%')) AS q
   INNER JOIN Tickets t  ON q.id = t.OrderId 
   ORDER BY  t.DateFly DESC) AS w
   ON w.FliesId=f.Id 
;
END
\\ DELIMITER ;

DELIMITER \\
/*Вывод информации о время отлета указанного рейса*/
CREATE PROCEDURE be_at_time (IN fly int)
BEGIN
SELECT  f.Time+f.TimeInFly
FROM Flies f   
WHERE f.Id=fly;
END \\
DELIMITER ;

DELIMITER \\
/*Количество проданных билетов*/
CREATE PROCEDURE amount_tick (IN fly int)
BEGIN
SELECT  count(*)
FROM Tickets t  
WHERE (t.Id=tick);
END \\
DELIMITER ;

DELIMITER \\
/*Информация о билете(клиенте) по номер билета*/
CREATE PROCEDURE info_ticket(IN tick int)
BEGIN
SELECT  f.NumberFly, f.FromWhere, f.ToWhere, f.Price, f.TimeInFly, 
f.Time, t.DateFly,t.Place, r.State, o.SurName, o.Name, o.MiddleName, o.SeriaPasport, o.NumberPasport, o.Birthday
FROM Flies f,Orders o,Tickets t, Registration r 
				WHERE (t.FliesId=f.id)&&(o.id = t.OrderId)&&(r.TicketId=t.Id)&&(t.Id=tick);
END \\
DELIMITER ;
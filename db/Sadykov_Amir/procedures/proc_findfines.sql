CREATE PROCEDURE findfines 
@reg INT,
@reg_mark CHAR(6),
@region tinyint
AS
BEGIN 
SELECT fines.protocol_number, fine_types.offence, fine_types.amount, fines.date
 FROM fines, fine_types,registrations
 WHERE registrations.number=@reg AND registrations.reg_mark=@reg_mark
 AND registrations.region=@region AND fines.people_id=registrations.people_id
 AND fine_types.id=fines.fines_id AND fines.is_paid=0
  
  ORDER BY fines.date;

END
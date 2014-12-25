CREATE PROCEDURE fine_Payment 
@protocol INT
AS
BEGIN 
SELECT fines.protocol_number, fine_types.offence, fine_types.amount, fines.date
 FROM fines,fine_types
 WHERE fines.protocol_number=@protocol AND
 fines.fines_id=fine_types.id
END

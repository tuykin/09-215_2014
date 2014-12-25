CREATE PROCEDURE fine_Paid 
@protocol INT
AS
BEGIN 
UPDATE fines SET
is_paid=1 
WHERE protocol_number=@protocol
END

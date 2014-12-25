CREATE PROCEDURE people_delete 
@id INT
AS
BEGIN 
UPDATE people SET
is_deleted=1 
WHERE id=@id
END

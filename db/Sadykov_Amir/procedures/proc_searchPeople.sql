CREATE PROCEDURE search_people
@surname VARCHAR(45)	
AS
BEGIN 
SELECT surname,name,patronymic,birthday,count_fines,amount_fines
 FROM people
where surname LIKE '%' + @surname + '%'
AND is_deleted=0
END


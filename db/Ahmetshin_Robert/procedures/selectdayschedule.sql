USE [sportclub]
GO
/****** Object:  StoredProcedure [dbo].[selectdayschedule]    Script Date: 22.12.2014 0:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
ALTER PROCEDURE [dbo].[selectdayschedule] 
	-- Add the parameters for the stored procedure here
	@section int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT  (SELECT
 CASE DATEDIFF(DAY,0, dayy-1)%7
  WHEN 0 THEN 'Понедельник'
  WHEN 1 THEN 'Вторник'
  WHEN 2 THEN 'Среда'
  WHEN 3 THEN 'Четверг'
  WHEN 4 THEN 'Пятница'
  WHEN 5 THEN 'Суббота'
  WHEN 6 THEN 'Воскресенье'
 END [День недели]), startTime, endTime
	from schedule, sections
	where sections.id = @section and sections.id = schedule.section_id
	order by dayy, startTime

END

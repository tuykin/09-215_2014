USE [sportclub]
GO
/****** Object:  StoredProcedure [dbo].[select_curr_day_sched]    Script Date: 29.11.2014 15:16:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
ALTER PROCEDURE [dbo].[select_curr_day_sched] 
	-- Add the parameters for the stored procedure here
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT sections.name, agegroups.name, schedule.startTime, schedule.endTime
	from sections, schedule, agegroups
	where (sections.id = schedule.section_id) and 
	((SELECT CONVERT (time, getdate())) between startTime and endTime) 
	and ((SELECT DATEDIFF(DAY,-1, GETDATE())%7)=schedule.dayy) and (sections.ageGroup_id = agegroups.id)
END

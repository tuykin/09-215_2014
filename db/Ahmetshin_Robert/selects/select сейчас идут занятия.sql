select sections.name, schedule.startTime, schedule.endTime
from sections, schedule
where (sections.id = schedule.section_id) and 
((SELECT CONVERT (time, getdate())) between startTime and endTime) 
and ((SELECT DATEDIFF(DAY,-1, GETDATE())%7)=schedule.day)
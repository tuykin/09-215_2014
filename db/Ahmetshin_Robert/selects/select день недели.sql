SELECT
 CASE DATEDIFF(DAY,0, GETDATE())%7
  WHEN 0 THEN 'Понедельник'
  WHEN 1 THEN 'Вторник'
  WHEN 2 THEN 'Среда'
  WHEN 3 THEN 'Четверг'
  WHEN 4 THEN 'Пятница'
  WHEN 5 THEN 'Суббота'
  WHEN 6 THEN 'Воскресенье'
 END [День недели]
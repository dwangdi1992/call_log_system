CallerLogDao.getSuperZoneList = SELECT id value, NAME text FROM super_zone
CallerLogDao.getZoneList = SELECT id AS value, name AS text FROM zone

CallerLogDao.getCallerLogList = SELECT  B.name supper_zone, c.name zone, DATE_FORMAT(DATE, '%d-%b-%y %T') dateText, unusual_question,QUERY,contact_no,STATUS,call_attend_by \
FROM caller_log A \
INNER JOIN \
super_zone B ON A.supper_zone = B.id INNER JOIN zone c ON A.zone = C.id WHERE call_attend_by=:userName

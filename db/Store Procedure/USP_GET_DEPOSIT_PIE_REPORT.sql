/*
Creaeted By : Dechen Wangdi
Created on  : 23-Jul-2020

Description : To get bank wise deposit information.

Example     : Call USP_GET_DEPOSIT_PIE_REPORT()
*/

DELIMITER $$

DROP PROCEDURE IF EXISTS `USP_GET_DEPOSIT_PIE_REPORT`$$

CREATE PROCEDURE `USP_GET_DEPOSIT_PIE_REPORT`()
    BEGIN
		SELECT A.finInstitution, (A.amount/A.total)*100 amount
		FROM temp_amt_tbl A;
    END$$

DELIMITER ;
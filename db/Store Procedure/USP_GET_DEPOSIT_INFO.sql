/*
Created by   : Dechen Wangdi
Created Date : 25-Jun-2020

Description  : To get deposit information if any by TPN/CID/License No.


Example      : CALL USP_GET_DEPOSIT_INFO ('234567')
*/



DELIMITER $$

DROP PROCEDURE IF EXISTS `USP_GET_DEPOSIT_INFO`$$

CREATE PROCEDURE `USP_GET_DEPOSIT_INFO`(searchKey VARCHAR(200))
    BEGIN

    END$$

DELIMITER ;
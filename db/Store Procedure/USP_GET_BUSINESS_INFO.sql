/*
Created by   : Dechen Wangdi
Created Date : 25-Jun-2020

Description  : To get business information if any by TPN/CID/License No.


Example      : CALL USP_GET_BUSINESS_INFO('234567')
*/


DELIMITER $$

DROP PROCEDURE IF EXISTS `USP_GET_BUSINESS_INFO`$$

CREATE PROCEDURE `USP_GET_BUSINESS_INFO`(searchKey VARCHAR(200))
    BEGIN

    END$$

DELIMITER ;
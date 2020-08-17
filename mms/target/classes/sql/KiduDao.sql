KiduDao.getKiduInfo = SELECT A.CID searchKey, A.NAME name, A.TOTAL_KIDU totalKiduAmt, A.OCCUPATION occupation, A.SECTOR sector, A.ENTERPRISE companyName FROM  tbl_kidu_data A WHERE A.CID =:searchKey
KiduDao.getKiduInfoList = SELECT A.CID searchKey, A.NAME name, A.OCCUPATION occupation, A.ENTERPRISE companyName,A.SECTOR sector, A.TOTAL_KIDU totalKiduAmt FROM tbl_kidu_data A ORDER BY A.NAME ASC

KiduDao.getKiduInfoListByCompany = SELECT A.CID searchKey, A.NAME name, A.OCCUPATION occupation, A.ENTERPRISE companyName,A.SECTOR sector, A.TOTAL_KIDU totalKiduAmt FROM tbl_kidu_data A WHERE A.ENTERPRISE LIKE :company ORDER BY A.NAME ASC

KiduDao.getTotalKiduDisbursed = SELECT A.* FROM temp_total_amt_tbl A




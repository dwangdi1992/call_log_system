/*
Need to run the script on information update of tbl_deposit_data table.
*/

INSERT INTO temp_amt_tbl 
SELECT A.FINANCIAL_INSTITUTION finInstitution, SUM(A.BALANCE) amount, NULL
FROM tbl_deposit_data A  GROUP BY A.FINANCIAL_INSTITUTION;
   
UPDATE temp_amt_tbl SET total =(SELECT SUM(A.BALANCE) FROM tbl_deposit_data A);  

SELECT A.* FROM  temp_amt_tbl A;

-- ==============
INSERT INTO temp_total_amt_tbl
SELECT 'Kidu' NAME,SUM(A.TOTAL_KIDU)/1000000 amount FROM tbl_kidu_data A 
UNION 
SELECT 'Deposit',SUM(A.BALANCE)/1000000  FROM tbl_deposit_data A 
UNION 
SELECT 'Loan', SUM(A.PRINCIPAL_OS_30_04_2020)/1000000  FROM tbl_loan_data A 
UNION 
SELECT 'Working Capital', SUM(A.SANCTION_AMT)/1000000 FROM tbl_working_capical_all_fi A

SELECT * FROM temp_total_amt_tbl;




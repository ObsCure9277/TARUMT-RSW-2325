/*
Sample from ORACLE Sql*Plus reference:
ACCEPT pswd CHAR PROMPT 'Password: ' HIDE
ACCEPT salary NUMBER FORMAT '999.99' DEFAULT '000.0' -
PROMPT 'Enter weekly salary: '
ACCEPT hired DATE FORMAT 'dd/mm/yyyy' DEFAULT '01/01/2003'-
PROMPT 'Enter date hired: '
ACCEPT lastname CHAR FORMAT 'A20' -
PROMPT 'Enter employee lastname: '
*/

-- script to insert a record into the customer table
/* the customer table structure as a freference
create table customer (
   cust_no	number(7)   not null,
   cust_name	varchar(25) not null,
   email	varchar(35),
   phone	varchar(14),
   birth_date   date,
   gender	char(1),
primary key(cust_no),
constraint chk_email check (REGEXP_LIKE(email,'^[a-zA-Z]\w+@(\S+)$')),
constraint chk_gender check (UPPER(gender) in ('M','F'))
);

*/

-- First, change Oracle's default date format to Malaysian date format
-- The new date format will be maintained until you terminate the session i.e. logout

ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY'; 

cl scr
PROMPT 'Data entry for CUSTOMER table'
PROMPT
PROMPT

ACCEPT v_custno     number FORMAT '9999999'    PROMPT 'Enter Customer No:    '
ACCEPT v_custname   char   FORMAT 'A25'        PROMPT 'Enter Customer Name:  '
ACCEPT v_email      char   FORMAT 'A35'        PROMPT 'Enter Customer email: '
ACCEPT v_phone      char   FORMAT 'A14'        PROMPT 'Enter Phone No.:      '
ACCEPT v_birth_date date   FORMAT 'dd/mm/yyyy' PROMPT 'Enter date of birth (dd/mm/yyyy)  : '
ACCEPT v_gender     char   FORMAT 'A1'         PROMPT 'Enter gender (M or F): '

--execute the INSERT statement
INSERT INTO customer VALUES
(&v_custno,'&v_custname','&v_email','&v_phone','&v_birth_date','&v_gender');
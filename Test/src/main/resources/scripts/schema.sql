--------------------------------------------------------
--  �w�إ��ɮ� - �P���G-����-07-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DEPT
--------------------------------------------------------

  CREATE TABLE DEPT 
   (	DEPTNO NUMBER , 
	DNAME VARCHAR2(255  ), 
	LOC VARCHAR2(255  )
   )  ;
--------------------------------------------------------
--  DDL for Table EMP
--------------------------------------------------------

  CREATE TABLE EMP 
   (	EMPNO NUMBER , 
	COMM FLOAT , 
	ENAME VARCHAR2(255 ), 
	HIREDATE DATE, 
	SAL FLOAT , 
	DEPTNO NUMBER , 
	JOBNO NUMBER , 
	JOB VARCHAR2 
   )  ;
--------------------------------------------------------
--  DDL for Table JOB
--------------------------------------------------------

  CREATE TABLE JOB 
   (	JOBNO NUMBER , 
	JOB_TITLE VARCHAR2 , 
	MAX_SALARY FLOAT , 
	MIN_SALARY FLOAT 
   )  ;
 
 
    
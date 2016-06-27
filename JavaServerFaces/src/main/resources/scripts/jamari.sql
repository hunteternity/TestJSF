--------------------------------------------------------
--  DDL for Table DEPT
--------------------------------------------------------

  CREATE TABLE "DEPT" 
   (	"DEPTNO" NUMBER(10,0), 
	"DNAME" VARCHAR2(255 ), 
	"LOC" VARCHAR2(255 )
   ) ;
--------------------------------------------------------
--  DDL for Table EMP
--------------------------------------------------------

  CREATE TABLE "EMP" 
   (	"EMPNO" NUMBER(10,0), 
	"COMM" FLOAT(126), 
	"ENAME" VARCHAR2(255 ), 
	"HIREDATE" DATE, 
	"SAL" FLOAT(126), 
	"DEPTNO" NUMBER(10,0), 
	"JOBNO" NUMBER(10,0), 
	"JOB" VARCHAR2(255 ),
	"PIC" BLOB
   ) ;
--------------------------------------------------------
--  DDL for Table JOB
--------------------------------------------------------

  CREATE TABLE "JOB" 
   (	"JOBNO" NUMBER(10,0), 
	"JOB_TITLE" VARCHAR2(255 ), 
	"MAX_SALARY" FLOAT(126), 
	"MIN_SALARY" FLOAT(126)
	);

Insert into DEPT values (1,'醫療部','江子翠');
Insert into DEPT values (2,'技術部','支援');
Insert into DEPT values (3,'財金部','板橋');

Insert into JOB values (1,'測試員',1000,100);
Insert into JOB values (4,'老師',5000,1000);
Insert into JOB values (2,'實習生',300,100);
Insert into JOB values (3,'助理',2000,500);

Insert into EMP values (1,null,'滾滾',null,null,1,2,null,null);
Insert into EMP values (2,null,'凱莉',null,null,2,2,null,null);
Insert into EMP values (3,null,'壹壹',null,null,2,2,null,null);
Insert into EMP values (4,null,'七七',null,null,2,2,null,null);
Insert into EMP values (5,null,'蒙奇',null,null,3,2,null,null);
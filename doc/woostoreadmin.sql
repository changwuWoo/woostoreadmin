/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2017/4/21 2:01:35                            */
/*==============================================================*/


ALTER TABLE TB_MENU
   DROP CONSTRAINT FK_TB_MENU_REFERENCE_TB_MENU;

ALTER TABLE TB_ACTIONLOG
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_ACTIONLOG CASCADE CONSTRAINTS;

ALTER TABLE TB_BASESTATUS
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_BASESTATUS CASCADE CONSTRAINTS;

ALTER TABLE TB_BUTTON
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_BUTTON CASCADE CONSTRAINTS;

ALTER TABLE TB_GRANT
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_GRANT CASCADE CONSTRAINTS;

ALTER TABLE TB_LOGINLOG
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_LOGINLOG CASCADE CONSTRAINTS;

ALTER TABLE TB_MASTER
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_MASTER CASCADE CONSTRAINTS;

ALTER TABLE TB_MASTERTYPE
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_MASTERTYPE CASCADE CONSTRAINTS;

ALTER TABLE TB_MENU
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_MENU CASCADE CONSTRAINTS;

ALTER TABLE TB_POWER
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_POWER CASCADE CONSTRAINTS;

ALTER TABLE TB_ROLE
   DROP PRIMARY KEY CASCADE;

DROP TABLE TB_ROLE CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: TB_ACTIONLOG                                          */
/*==============================================================*/
CREATE TABLE TB_ACTIONLOG
(
   FK_LOGINLOG_ID       VARCHAR2(32 CHAR)    NOT NULL,
   FK_USER_ID           VARCHAR2(32 CHAR)    NOT NULL,
   FOPVALUETABLE        VARCHAR2(80 CHAR)    NOT NULL,
   FOPTIME              TIMESTAMP,
   FMAINTAINTIME        DECIMAL(1,0)
);

ALTER TABLE TB_ACTIONLOG
   ADD CONSTRAINT PK_TB_ACTIONLOG PRIMARY KEY (PK_LOGINLOG_ID);

/*==============================================================*/
/* Table: TB_BASESTATUS                                         */
/*==============================================================*/
CREATE TABLE TB_BASESTATUS
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FKEY                 DECIMAL(1, 0)        NOT NULL,
   FVALUE               VARCHAR2(80 CHAR)    NOT NULL
);

ALTER TABLE TB_BASESTATUS
   ADD CONSTRAINT PK_TB_BASESTATUS PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_BUTTON                                             */
/*==============================================================*/
CREATE TABLE TB_BUTTON
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNAME                VARCHAR2(80 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL
);

ALTER TABLE TB_BUTTON
   ADD CONSTRAINT PK_TB_BUTTON PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_GRANT                                              */
/*==============================================================*/
CREATE TABLE TB_GRANT
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   PRIVILEGEMASTER      VARCHAR2(80 CHAR)    NOT NULL,
   PRIVILEGEMASTERVALUE VARCHAR2(32 CHAR)    NOT NULL,
   PRIVILEGEACCESS      VARCHAR2(80 CHAR)    NOT NULL,
   PRIVILEGEACCESSVALUE VARCHAR2(32 CHAR)    NOT NULL,
   PRIVILEGEOPERATION   DECIMAL(1,0)         NOT NULL,
   FKPOWERID            VARCHAR2(32 CHAR)    NOT NULL
);

ALTER TABLE TB_GRANT
   ADD CONSTRAINT PK_TB_GRANT PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_LOGINLOG                                           */
/*==============================================================*/
CREATE TABLE TB_LOGINLOG
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FIP                  VARCHAR2(32 CHAR)    NOT NULL,
   FLOGINTIME           TIMESTAMP            NOT NULL,
   FENDTIME             TIMESTAMP            NOT NULL,
   FMAINTAINTIME        NUMBER(8,4)
);

ALTER TABLE TB_LOGINLOG
   ADD CONSTRAINT PK_TB_LOGINLOG PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_MASTER                                             */
/*==============================================================*/
CREATE TABLE TB_MASTER
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FUSERNAME            VARCHAR2(80 CHAR)    NOT NULL,
   FPASSWD              VARCHAR2(80 CHAR)    NOT NULL,
   FEMAIL               VARCHAR(120),
   FSTATUS              DECIMAL(1,0)         DEFAULT 1 NOT NULL,
   FKROLEKEY            DECIMAL(1, 0)        NOT NULL,
   FKTYPEKEY            DECIMAL(1, 0)        NOT NULL
);

ALTER TABLE TB_MASTER
   ADD CONSTRAINT PK_TB_MASTER PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_MASTERTYPE                                         */
/*==============================================================*/
CREATE TABLE TB_MASTERTYPE
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FKEY                 DECIMAL(1, 0)        NOT NULL,
   FVALUE               VARCHAR2(18 CHAR)    NOT NULL
);

ALTER TABLE TB_MASTERTYPE
   ADD CONSTRAINT PK_TB_MASTERTYPE PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_MENU                                               */
/*==============================================================*/
CREATE TABLE TB_MENU
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FPARENT_ID           VARCHAR2(32 CHAR),
   FNAME                VARCHAR2(60 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   FSTATUS              DECIMAL(1,0)         NOT NULL
);

ALTER TABLE TB_MENU
   ADD CONSTRAINT PK_TB_MENU PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_POWER                                              */
/*==============================================================*/
CREATE TABLE TB_POWER
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   FVALUE               VARCHAR2(18 CHAR)    NOT NULL
);

ALTER TABLE TB_POWER
   ADD CONSTRAINT PK_TB_POWER PRIMARY KEY (PK_ID);

/*==============================================================*/
/* Table: TB_ROLE                                               */
/*==============================================================*/
CREATE TABLE TB_ROLE
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FKEY                 DECIMAL(1, 0)        NOT NULL,
   FVALUE               VARCHAR2(18 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(16 CHAR)    NOT NULL
);

ALTER TABLE TB_ROLE
   ADD CONSTRAINT PK_TB_ROLE PRIMARY KEY (PK_ID);

ALTER TABLE TB_MENU
   ADD CONSTRAINT FK_TB_MENU_REFERENCE_TB_MENU FOREIGN KEY (FPARENT_ID)
      REFERENCES TB_MENU (PK_ID);


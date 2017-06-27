/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2017/4/15 9:49:00                            */
/*==============================================================*/


ALTER TABLE TB_GROUP
   DROP CONSTRAINT FK_TB_GRO_REFERENCE_TB_GRO;

DROP TABLE TB_CARDINFO CASCADE CONSTRAINTS;

DROP TABLE TB_GRANT CASCADE CONSTRAINTS;

DROP TABLE TB_MASTER CASCADE CONSTRAINTS;

DROP TABLE TB_POWER CASCADE CONSTRAINTS;

DROP TABLE TB_ABLUM CASCADE CONSTRAINTS;

DROP TABLE TB_ASKSTATUS CASCADE CONSTRAINTS;

DROP TABLE TB_DEGREE CASCADE CONSTRAINTS;

DROP TABLE TB_EXPANCE CASCADE CONSTRAINTS;

DROP TABLE TB_GROUP CASCADE CONSTRAINTS;

DROP TABLE TB_IMAGE CASCADE CONSTRAINTS;

DROP TABLE TB_LOG CASCADE CONSTRAINTS;

DROP TABLE TB_PART CASCADE CONSTRAINTS;

DROP TABLE TB_PLATE CASCADE CONSTRAINTS;

DROP TABLE TB_PLATESTATUS CASCADE CONSTRAINTS;

DROP TABLE TB_RESULTSTATUS CASCADE CONSTRAINTS;

DROP TABLE TB_REWARD CASCADE CONSTRAINTS;

DROP TABLE TB_ROLE CASCADE CONSTRAINTS;

DROP TABLE TB_TYPE CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: TB_CARDINFO                                         */
/*==============================================================*/
CREATE TABLE TB_CARDINFO
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(12 CHAR),
   FBALANCE             DECIMAL(21,8),
   FPLATENUMBER         VARCHAR2(16 CHAR),
   FCARDTYPE            DECIMAL(1, 0),
   CONSTRAINT PK_TB_CARDINFO PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_GRANT                                            */
/*==============================================================*/
CREATE TABLE TB_GRANT
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   PRIVILEGEMASTER      VARCHAR2(80 CHAR)    NOT NULL,
   PRIVILEGEMASTERVALUE VARCHAR2(32 CHAR)    NOT NULL,
   PRIVILEGEACCESS      VARCHAR2(80 CHAR)    NOT NULL,
   PRIVILEGEACCESSVALUE VARCHAR2(32 CHAR)    NOT NULL,
   PRIVILEGEOPERATION   DECIMAL(1,0)         NOT NULL,
   CONSTRAINT PK_TB_GRANT PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_MASTER                                           */
/*==============================================================*/
CREATE TABLE TB_MASTER
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FUSERNAME            VARCHAR2(80 CHAR)    NOT NULL,
   FPASSWD              VARCHAR2(80 CHAR)    NOT NULL,
   FEMAIL               VARCHAR2(120 CHAR),
   FSTATUS              DECIMAL(1,0)         DEFAULT 1 NOT NULL,
   PK_GROUP_ID          VARCHAR2(32 CHAR),
   PK_ROLE_ID           VARCHAR2(32 CHAR),
   CONSTRAINT PK_TB_MASTER PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_POWER                                            */
/*==============================================================*/
CREATE TABLE TB_POWER
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   FNAME                VARCHAR2(18)        NOT NULL,
   CONSTRAINT PK_TB_POWER PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_ABLUM                                            */
/*==============================================================*/
CREATE TABLE TB_ABLUM
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNAME                VARCHAR2(80 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(32 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_ABLUM PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_ASKSTATUS                                        */
/*==============================================================*/
CREATE TABLE TB_ASKSTATUS
(
   FKEY                 DECIMAL(1, 0),
   FVALUE               VARCHAR2(80 CHAR)
);

/*==============================================================*/
/* Table: TB_DEGREE                                           */
/*==============================================================*/
CREATE TABLE TB_DEGREE
(
   FNAME                DECIMAL(1, 0)        NOT NULL,
   FVALUE               VARCHAR2(80 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_DEGREE PRIMARY KEY (FNAME, FVALUE)
);

/*==============================================================*/
/* Table: TB_EXPANCE                                          */
/*==============================================================*/
CREATE TABLE TB_EXPANCE
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   FSTARTTIME           TIMESTAMP,
   FENDTIME             TIMESTAMP,
   FAMOUNT              DECIMAL(21,8),
   CONSTRAINT PK_TB_EXPANCE PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_GROUP                                            */
/*==============================================================*/
CREATE TABLE TB_GROUP
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   PARENT_ID            VARCHAR2(32 CHAR),
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   FNAME                VARCHAR2(80 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_GROUP PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_IMAGE                                            */
/*==============================================================*/
CREATE TABLE TB_IMAGE
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNAME                VARCHAR2(18 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(12 CHAR)    NOT NULL,
   FISPUB               DECIMAL(1,0)         NOT NULL,
   FOWNUSERID           VARCHAR2(32 CHAR)    NOT NULL,
   FCREATEDATE          TIMESTAMP            NOT NULL,
   CONSTRAINT PK_TB_IMAGE PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_LOG                                              */
/*==============================================================*/
CREATE TABLE TB_LOG
(
   PK_LOGINLOG_ID       VARCHAR2(32 CHAR)    NOT NULL,
   PK_USER_ID           VARCHAR2(32 CHAR)    NOT NULL,
   FOPVALUETABLE        VARCHAR2(80 CHAR)    NOT NULL,
   FOPTIME              TIMESTAMP,
   FMAINTAINTIME        DECIMAL(1,0),
   CONSTRAINT PK_TB_LOG PRIMARY KEY (PK_LOGINLOG_ID)
);

/*==============================================================*/
/* Table: TB_PART                                             */
/*==============================================================*/
CREATE TABLE TB_PART
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   FNAME                VARCHAR2(80 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_PART PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_PLATE                                            */
/*==============================================================*/
CREATE TABLE TB_PLATE
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   E                    VARCHAR2(32 CHAR)    NOT NULL,
   FNAME                VARCHAR2(80 CHAR)    NOT NULL,
   FSTATUS              DECIMAL(1,0)         NOT NULL,
   CONSTRAINT PK_TB_PLATE PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_PLATESTATUS                                      */
/*==============================================================*/
CREATE TABLE TB_PLATESTATUS
(
   FKEY                 DECIMAL(1,0)         NOT NULL,
   FVALUE               VARCHAR2(18 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_PLATESTATUS PRIMARY KEY (FKEY, FVALUE)
);

/*==============================================================*/
/* Table: TB_RESULTSTATUS                                     */
/*==============================================================*/
CREATE TABLE TB_RESULTSTATUS
(
   FKEY                 DECIMAL(1, 0)        NOT NULL,
   FVALUE               VARCHAR2(80 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_RESULTSTATUS PRIMARY KEY (FKEY, FVALUE)
);

/*==============================================================*/
/* Table: TB_REWARD                                           */
/*==============================================================*/
CREATE TABLE TB_REWARD
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNAME                VARCHAR2(32 CHAR),
   FNUMBER              VARCHAR2(16 CHAR),
   FLIMMITTIME          TIMESTAMP,
   FDEGREEKEY           DECIMAL(1,0),
   FTYPEKEY             DECIMAL(1,0),
   FSTATUSKEY           DECIMAL(1,0),
   PUBUSERID            VARCHAR2(32 CHAR),
   PUBTIME              TIMESTAMP,
   FLLOWSUSER           VARCHAR2(32 CHAR),
   FDRAWTIME            TIMESTAMP,
   FFDONETIME           TIMESTAMP,
   CONSTRAINT PK_TB_REWARD PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_ROLE                                             */
/*==============================================================*/
CREATE TABLE TB_ROLE
(
   PK_ID                VARCHAR2(32 CHAR)    NOT NULL,
   FNAME                VARCHAR2(18)        NOT NULL,
   FNUMBER              VARCHAR2(18 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_ROLE PRIMARY KEY (PK_ID)
);

/*==============================================================*/
/* Table: TB_TYPE                                             */
/*==============================================================*/
CREATE TABLE TB_TYPE
(
   FKEY                 DECIMAL(1, 0)        NOT NULL,
   FVALUE               VARCHAR2(80 CHAR)    NOT NULL,
   CONSTRAINT PK_TB_TYPE PRIMARY KEY (FKEY, FVALUE)
);

ALTER TABLE TB_GROUP
   ADD CONSTRAINT FK_TB_GRO_REFERENCE_TB_GRO FOREIGN KEY (PARENT_ID)
      REFERENCES TB_GROUP (PK_ID);

create sequence seq_token
increment by 1
start with 1000
maxvalue 999999999;
create sequence seq_newsId
increment by 1
start with 1
maxvalue 999999999;

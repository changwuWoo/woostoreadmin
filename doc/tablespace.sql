create tablespace woostoreadmin_tablespace
datafile 'E:\app\oracle\oradata\dev\woostoreadmin_tablespace.dbf'
size 200M autoextend on  next 2M  maxsize 800M;
create tablespace woostoreadmin_tablespace
datafile 'D:\oracle\tablespace\woostoreadmin_tablespace.dbf'
size 1M autoextend on  next 2M  maxsize 50M;
create user woostoreadmin identified by woostoreadmin
       default tablespace woostoreadmin_tablespace
       TEMPORARY TABLESPACE temp;
grant dba to woostoreadmin;

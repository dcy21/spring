create database test;
create table USERS
(
  ID        int primary key auto_increment,
  NAME      VARCHAR(50),
  PASSWORD  VARCHAR(50),
  TELEPHONE VARCHAR(15),
  USERNAME  VARCHAR(50),
  ISADMIN   VARCHAR(5)
);
--地区表
drop TABLE HOUSE;
create table DISTRICT
(
  ID   int primary key,
  NAME VARCHAR(50)
);
--街道表
create table STREET
(
  ID        int primary key,
  NAME        VARCHAR(50),
  DISTRICT_ID int
);


--房屋类型表
create table housetype
(
  ID    int primary key auto_increment,
  NAME VARCHAR(20)
)
--房屋信息表
create table HOUSE
(
  ID          int primary key auto_increment,
  USER_ID     int,
  district_id int,
  TYPE_ID     int,
  TITLE       NVARCHAR(50),
  DESCRIPTION text,
  PRICE       double,
  PUBDATE     DATE,
  FLOORAGE    int,
  CONTACT     VARCHAR(100),
  STREET_ID   int
);

select * from house;
UPDATE HOUSE set TITLE="哈哈" where id=2
delete from house;

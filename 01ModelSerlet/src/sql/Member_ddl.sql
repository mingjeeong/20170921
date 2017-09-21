/* 부서 테이블 ddl*/


drop table dept cascade constraints purge;

create table member(
username varchar2(20) not null,
birth varchar2(20) not null,
userid varchar2(40) primary key,
userpw varchar2(40) not null , 
email varchar2(40) not null,
address varchar2(100) not null,
mobile varchar2(13) not null,
preference varchar2(40)  
);

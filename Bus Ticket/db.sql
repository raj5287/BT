create table route(routeid int not null primary key auto_increment,source varchar(20), dest varchar(20), distance int(5));
select * from route;
create table bus(busid int not null primary key auto_increment,type varchar(20),fare int,totalbooked int,routeid int not null);
select * from bus;
create table busschedule(scheduleid int not null primary key auto_increment,busid int not null,jdate date,totalbooked int);
drop table busschedule;
create table busschedule(scheduleid int not null primary key auto_increment,busid int not null,jdate date,totalbooked int);
select * from bus;
create table searchbuslist(busid int not null,)
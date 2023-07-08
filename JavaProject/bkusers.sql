drop table if exists bkusers;
create table  if not exists bkusers(
id int primary key auto_increment,
fname varchar(20) not null,
lname varchar(20) not null,
age tinyint unsigned not null,
address varchar(50) not null,
adhar_id varchar(13) not null unique,
phone_no varchar(10) not null,
email_id varchar(30) not null unique,
min_balance decimal(10,2) not null
);
alter table bkusers auto_increment=1001;
desc bkusers;

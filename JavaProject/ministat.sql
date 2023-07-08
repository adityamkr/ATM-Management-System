use atm;
drop table if exists transaction;
create table if not exists transaction(
acc_no int not null,
trans_type varchar(20) not null,
trans_towards int,
amount decimal(10,2) not null,
trans_date DATETIME NOT NULL default now()

);


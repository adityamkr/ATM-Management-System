use atm;
drop trigger if exists t1;
delimiter $$
create trigger t1 before update on bkusers for each row
begin
if(new.min_balance<2000) then
	signal SQLSTATE "12345" set message_text="min balance should be above 2000 Rs";
end if;
end $$

drop procedure if exists p1 $$
create procedure p1 (sender int,receiver int,amount decimal,out success int)
begin
declare issue boolean default false;
declare continue handler for SQLException
begin
show errors;
set issue=true;
end;
start transaction;
update bkusers set min_balance=min_balance+amount where id=receiver;
update bkusers set min_balance=min_balance-amount where id=sender;
if(not issue) then
 set success=1;
 commit;
else
	set success=0;
	rollback;
end if;
end $$
delimiter ;
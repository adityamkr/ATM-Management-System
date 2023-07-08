use atm;
drop procedure if exists p2;
delimiter $$
create procedure p2(a int,b double,
out amount double,out success int)
begin
declare issue boolean default false;
declare continue handler for SQLEXCEPTION
begin
show errors;
set issue=true;
end;
start transaction;
update bkusers set min_balance=min_balance-b where id=a;
if(not issue) then
select min_balance into amount from bkusers where id=a;
set success=1;
commit;
else
 set success=0;
 rollback;
end if;
end $$
delimiter ;
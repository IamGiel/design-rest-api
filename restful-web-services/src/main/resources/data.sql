insert into user values(10001, sysdate(), 'AB', 0);
insert into user values(10002, sysdate(), 'Jack', 0);
insert into user values(10003, sysdate(), 'Jill', 0);

insert into post values(11001, 'This is my first post',10001);
insert into post values(11002, 'This is my second post',10001);

insert into to_do values(11101,'Get milk', false, sysdate());

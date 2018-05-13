drop table ticket;
drop table problemcategory;
drop table serviceagent;
drop table servicegroup;
drop table customer;

create table customer(id integer primary key, username varchar2(20), password varchar2(20), email varchar2(30), contactno varchar2(10));
create table servicegroup(id integer primary key, name varchar(20));
create table serviceagent(id integer primary key, username varchar2(20), password varchar2(20), email varchar2(30), contactno varchar2(10), groupid integer, foreign key (groupid) references servicegroup(id));
create table problemcategory(id integer primary key, groupid integer, foreign key (groupid) references servicegroup(id), category varchar2(20));
create table ticket(id integer primary key, summary varchar2(250), details clob, creationdate timestamp, status varchar2(10), groupid integer, foreign key (groupid) references servicegroup(id), priority varchar2(10), assignee integer, foreign key (assignee) references serviceagent(id), requestor integer, foreign key (requestor) references customer(id), categoryid integer, foreign key (categoryid) references problemcategory(id));   
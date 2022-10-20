show databases;

use bankmanagementsystem;

create table signup(formno varchar(20),name varchar(20),father_name varchar(20),dob varchar(20),gender varchar(20),email varchar(30),marital_status varchar(20),address varchar(40),city varchar(25),pincode varchar(20),state varchar(25));

show tables;

select * from signup;

create table signuptwo(formno varchar(20),religion varchar(20),category varchar(20),income varchar(20),eductaion varchar(20),occupation varchar(20),pan varchar(20),aadhar varchar(20),senior_citizen varchar(20),existing_account varchar(20));

select * from signuptwo;

create table signupthree(formno varchar(20),account_Type varchar(40),card_number varchar(25),pin varchar(20),facility varchar(100));

 create table login(formno varchar(20),card_number varchar(25),pin varchar(20));
 select * from signupthree;
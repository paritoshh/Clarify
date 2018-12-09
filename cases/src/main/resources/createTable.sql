--create table CASE (id int not null, customer_number varchar(20), customer_name varchar(40));
--insert into CASE(001, "IK001", "IKEA");
create table CASE (case_id int not null, status_id int not null, customer_id int not null, created_time DATE, updated_time DATE, priority varchar(10), crated_by varchar(10), comment varchar(50));
create table CUSTOMER (customer_id int not null, customer_fname varchar(20), customer_mname varchar(40),customer_lname varchar(40), customer_primary_address varchar(50), customer_primary_mob_number varchar(12), customer_ssn varchar(8), customer_email varchar(40), customer_type varchar(40), customer_service_type varchar(40));
create table STATUS (id int not null, code varchar(15), description varchar(20));
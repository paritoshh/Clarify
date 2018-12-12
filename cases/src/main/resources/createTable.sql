--create table CASE (id int not null, customer_number varchar(20), customer_name varchar(40));
--insert into CASE(001, "IK001", "IKEA");
create table CASES (case_id int not null, status_id int not null, customer_id int not null, created_time DATE, updated_time DATE, priority varchar(10), created_by varchar(10), updated_by varchar(10), comments varchar(50));
create table CUSTOMER (customer_id int not null, customer_fname varchar(20), customer_mname varchar(40),customer_lname varchar(40), customer_primary_address varchar(50), customer_primary_mob_number varchar(12), ssn varchar(8), customer_email varchar(40), customer_type varchar(40), customer_service_type varchar(40));
create table STATUS (id int not null, code varchar(15), description varchar(20));
insert into CUSTOMER(10001, "IKEA", "Pvt", "Ltd.", "Copenhagen, Denmark", "+45 9178224", "IKEA1234", "customercase@ikea.com", "Housing", "Permanent");
insert into CUSTOMER(10002, "NETTO", "Pvt", "Ltd.", "Mumbai, India", "+91 9178224", "NETT4321", "customercase@netto.com", "Food", "Permanent");
insert into CUSTOMER(10003, "JYSK", "Pvt", "Ltd.", "Stockhoms, Sweden", "+123 9435354", "JYSK7878","customercase@jysk.com", "Furniture", "Temp");
insert into CUSTOMER(10004, "POWER", "Pvt", "Ltd.", "Paris, France", "+49 9178224", "POWR8990", "customercase@power.com", "Electronics", "Permanent");

insert into STATUS (100, "NEW", "NEW");
insert into STATUS (200, "ASSIGNED", "ASSIGNED");
insert into STATUS (300, "BLOCKED", "BLOCKED");
insert into STATUS (400, "EXPIRED", "EXPIRED");
insert into STATUS (500, "RESOLVED", "RESOLVED");
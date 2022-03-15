create database furama_management_system_database;
use furama_management_system_database;

create table `position`(
position_id int not null auto_increment,
position_name varchar(45),
primary key(position_id)
);

create table education_degree(
education_degree_id int not null auto_increment,
education_degree_name varchar(45),
primary key(education_degree_id)
);

create table division(
division_id int not null auto_increment,
division_name varchar(45),
primary key(division_id)
);

create table `role`(
role_id int not null auto_increment,
role_name varchar(255),
primary key(role_id)
);

create table `user`(
username varchar(255),
`password` varchar(255),
primary key(username)
);

create table user_role(
role_id int not null,
username varchar(255),
primary key(role_id, username),
foreign key(role_id) references `role`(role_id) on update cascade on delete cascade,
foreign key(username) references `user`(username) on update cascade on delete cascade
);

create table employee(
employee_id int not null auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int not null,
education_degree_id int not null,
division_id int not null,
username varchar(255),
primary key(employee_id),
foreign key(position_id) references `position`(position_id) on update cascade on delete cascade,
foreign key(education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
foreign key(division_id) references division(division_id) on update cascade on delete cascade,
foreign key(username) references `user`(username) on update cascade on delete cascade
);

create table customer_type(
customer_type_id int not null auto_increment,
customer_type_name varchar(45),
primary key(customer_type_id)
);

create table customer(
customer_id int not null auto_increment,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1),
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int not null,
primary key(customer_id),
foreign key(customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade
);

create table service_type(
service_type_id int not null auto_increment,
service_type_name varchar(45),
primary key(service_type_id)
);

create table rent_type(
rent_type_id int not null auto_increment,
rent_type_name varchar(45),
rent_type_cost double,
primary key(rent_type_id)
);

create table service(
service_id int not null auto_increment,
service_name varchar(45) not null,
service_area int,
service_cost double not null,
service_max_people int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
rent_type_id int not null,
service_type_id int not null,
primary key(service_id),
foreign key(rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade,
foreign key(service_type_id) references service_type(service_type_id) on update cascade on delete cascade
);

create table contract(
contract_id int not null auto_increment,
contract_start_date datetime not null,
contract_end_date datetime not null,
contract_deposit double not null,
contract_total_money double not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
primary key(contract_id),
foreign key(employee_id) references employee(employee_id) on update cascade on delete cascade,
foreign key(customer_id) references customer(customer_id) on update cascade on delete cascade,
foreign key(service_id) references service(service_id) on update cascade on delete cascade
);

create table attach_service(
attach_service_id int not null auto_increment,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit int not null,
attach_service_status varchar(45),
primary key(attach_service_id)
);

create table contract_detail(
contract_detail_id int not null auto_increment,
quantity int not null,
contract_id int not null,
attach_service_id int not null,
primary key(contract_detail_id),
foreign key(contract_id) references contract(contract_id) on update cascade on delete cascade,
foreign key(attach_service_id) references attach_service(attach_service_id) on update cascade on delete cascade
);


INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) 
VALUES ('1', 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', '5');





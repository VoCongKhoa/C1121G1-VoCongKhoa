create database furama_management_system_database;
use furama_management_system_database;
-- drop database furama_management_system_database;


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
customer_code varchar(45) not null,
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
service_code varchar(45) not null,
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


-- INSERT INTO table customer_type
INSERT INTO `furama_management_system_database`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('1', 'Diamond');
INSERT INTO `furama_management_system_database`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('2', 'Platinium');
INSERT INTO `furama_management_system_database`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('3', 'Gold');
INSERT INTO `furama_management_system_database`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('4', 'Silver');
INSERT INTO `furama_management_system_database`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('5', 'Member');

-- INSERT INTO table customer
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('1', 'KH-0001', 'Nguy???n Th??? H??o', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguy???n Ho??ng, ???? N???ng', '5');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('2', 'KH-0002', 'Ph???m Xu??n Di???u', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???', '3');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('3', 'KH-0003', 'Tr????ng ????nh Ngh???', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 ??ng ??ch Khi??m, Vinh', '1');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('4', 'KH-0004', 'D????ng V??n Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 L?? L???i, ???? N???ng', '1');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('5', 'KH-0005', 'Ho??ng Tr???n Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 L?? Th??i T???, Gia Lai', '4');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('6', 'KH-0006', 'T??n N??? M???c Ch??u', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Y??n Th???, ???? N???ng', '4');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('7', 'KH-0007', 'Nguy???n M??? Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 L?? L???i, H??? Ch?? Minh', '1');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('8', 'KH-0008', 'Nguy???n Th??? H??o', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguy???n V??n Linh, Kon Tum', '3');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('9', 'KH-0009', 'Tr???n ?????i Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 L?? Th?????ng Ki???t, Qu???ng Ng??i', '1');
INSERT INTO `furama_management_system_database`.`customer` (`customer_id`, `customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES ('10', 'KH-0010', 'Nguy???n T??m ?????c', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ng?? Quy???n, ???? N???ng', '2');

-- INSERT INTO table position
INSERT INTO `furama_management_system_database`.`position` (`position_id`, `position_name`) VALUES ('1', 'Qu???n L??');
INSERT INTO `furama_management_system_database`.`position` (`position_id`, `position_name`) VALUES ('2', 'Nh??n Vi??n');

-- INSERT INTO table education_degree
INSERT INTO `furama_management_system_database`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('1', 'Trung C???p');
INSERT INTO `furama_management_system_database`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('2', 'Cao ?????ng');
INSERT INTO `furama_management_system_database`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('3', '?????i H???c');
INSERT INTO `furama_management_system_database`.`education_degree` (`education_degree_id`, `education_degree_name`) VALUES ('4', 'Sau ?????i H???c');

-- INSERT INTO table division
INSERT INTO `furama_management_system_database`.`division` (`division_id`, `division_name`) VALUES ('1', 'Sale-Marketing');
INSERT INTO `furama_management_system_database`.`division` (`division_id`, `division_name`) VALUES ('2', 'H??nh ch??nh');
INSERT INTO `furama_management_system_database`.`division` (`division_id`, `division_name`) VALUES ('3', 'Ph???c v???');
INSERT INTO `furama_management_system_database`.`division` (`division_id`, `division_name`) VALUES ('4', 'Qu???n l??');

-- INSERT INTO table employee
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('1', 'Nguy???n V??n An', '1970-11-07', '456231786', '10000000', '0901234121', 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng', '1', '3', '1');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('2', 'L?? V??n B??nh', '1997-04-09', '654231234', '7000000', '0934212314', 'binhlv@gmail.com', '22 Y??n B??i, ???? N???ng', '1', '2', '2');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('3', 'H??? Th??? Y???n', '1995-12-12', '999231723', '14000000', '0412352315', 'thiyen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', '1', '3', '2');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('4', 'V?? C??ng To???n', '1980-04-04', '123231365', '17000000', '0374443232', 'toan0404@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', '1', '4', '4');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('5', 'Nguy???n B???nh Ph??t', '1999-12-09', '454363232', '6000000', '0902341231', 'phatphat@gmail.com', '43 Y??n B??i, ???? N???ng', '2', '1', '1');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('6', 'Kh??c Nguy???n An Nghi', '2000-11-08', '964542311', '7000000', '0978653213', 'annghi20@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', '2', '2', '3');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('7', 'Nguy???n H???u H??', '1993-01-01', '534323231', '8000000', '0941234553', 'nhh0101@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', '2', '3', '2');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('8', 'Nguy???n H?? ????ng', '1989-09-03', '234414123', '9000000', '0642123111', 'donghanguyen@gmail.com', '111 H??ng V????ng, H?? N???i', '2', '4', '4');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('9', 'T??ng Hoang', '1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 H??m Nghi, ???? N???ng', '2', '4', '4');
INSERT INTO `furama_management_system_database`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`) VALUES ('10', 'Nguy???n C??ng ?????o', '1994-01-08', '755434343', '8000000', '0988767111', 'nguyencongdao12@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', '2', '3', '2');

-- INSERT INTO table rent_type
INSERT INTO `furama_management_system_database`.`rent_type` (`rent_type_id`, `rent_type_name`, `rent_type_cost`) VALUES ('1', 'year', '10000000');
INSERT INTO `furama_management_system_database`.`rent_type` (`rent_type_id`, `rent_type_name`, `rent_type_cost`) VALUES ('2', 'month', '2000000');
INSERT INTO `furama_management_system_database`.`rent_type` (`rent_type_id`, `rent_type_name`, `rent_type_cost`) VALUES ('3', 'day', '1000000');
INSERT INTO `furama_management_system_database`.`rent_type` (`rent_type_id`, `rent_type_name`, `rent_type_cost`) VALUES ('4', 'hour', '500000');

-- INSERT INTO table service_type
INSERT INTO `furama_management_system_database`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('1', 'Villa');
INSERT INTO `furama_management_system_database`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('2', 'House');
INSERT INTO `furama_management_system_database`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('3', 'Room');

-- INSERT INTO table service
INSERT INTO `furama_management_system_database`.`service` (`service_id`, `service_code`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES ('1', 'DV-0001', 'Villa Beach Front', '25000', '10000000', '10', 'vip', 'C?? h??? b??i', '500', '4', '3', '1');
INSERT INTO `furama_management_system_database`.`service` (`service_id`, `service_code`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES ('2', 'DV-0002', 'House Princess 01', '14000', '5000000', '7', 'vip', 'C?? th??m b???p n?????ng', null, '3', '2', '2');
INSERT INTO `furama_management_system_database`.`service` (`service_id`, `service_code`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES ('3', 'DV-0003', 'Room Twin 01', '5000', '1000000', '2', 'normal', 'C?? tivi', null, null, '4', '3');
INSERT INTO `furama_management_system_database`.`service` (`service_id`, `service_code`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES ('4', 'DV-0004', 'Villa No Beach Front', '22000', '9000000', '8', 'normal', 'C?? h??? b??i', '300', '3', '3', '1');
INSERT INTO `furama_management_system_database`.`service` (`service_id`, `service_code`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES ('5', 'DV-0005', 'House Princess 02', '10000', '4000000', '5', 'normal', 'C?? th??m b???p n?????ng', null, '2', '3', '2');
INSERT INTO `furama_management_system_database`.`service` (`service_id`, `service_code`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `rent_type_id`, `service_type_id`) VALUES ('6', 'DV-0006', 'Room Twin 02', '3000', '900000', '2', 'normal', 'C?? tivi', null, null, '4', '3');

-- INSERT INTO table contract
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('1', '2020-12-08', '2020-12-08', '0', '1000000', '3', '1', '3');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('2', '2020-07-14', '2020-07-21', '200000', '2000000', '7', '3', '1');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('3', '2021-03-15', '2021-03-17', '50000', '1500000', '3', '4', '2');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('4', '2021-01-14', '2021-01-18', '100000', '1400000', '7', '5', '5');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('5', '2021-07-14', '2021-07-15', '0', '100000', '7', '2', '6');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('6', '2021-06-01', '2021-06-03', '0', '100000', '7', '7', '6');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('7', '2021-09-02', '2021-09-05', '100000', '1000000', '7', '4', '4');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('8', '2021-06-17', '2021-06-18', '150000', '1600000', '3', '4', '1');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('9', '2020-11-19', '2020-11-19', '0', '500000', '3', '4', '3');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('10', '2021-04-12', '2021-04-14', '0', '600000', '10', '3', '5');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('11', '2021-04-25', '2021-04-25', '0', '300000', '2', '2', '1');
INSERT INTO `furama_management_system_database`.`contract` (`contract_id`, `contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) VALUES ('12', '2021-05-25', '2021-05-27', '0', '100000', '7', '10', '1');




SELECT customer_type_id, customer_type_name FROM customer_type;

-- UPDATE customer SET customer_code = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ?, customer_type_id = ? WHERE customer_id = ?;

SELECT customer_id, customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id FROM customer WHERE customer_id = 1;

SELECT customer_id, customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer.customer_type_id, customer_type_name FROM customer INNER JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id ORDER BY customer_id;

-- DELETE FROM customer WHERE customer_id = ?;
SELECT customer_id, customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id FROM customer WHERE customer_name LIKE concat('%',"t",'%');

SELECT customer_id, customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id FROM customer ORDER BY customer_id;

SELECT customer_id, customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id FROM customer ORDER BY customer_birthday DESC;

-- Select all employee
SELECT employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, employee.position_id, employee.education_degree_id, employee.division_id, employee.username FROM employee 
INNER JOIN position ON employee.position_id = position.position_id
INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id
INNER JOIN division ON employee.division_id = division.division_id
LEFT JOIN user ON employee.username = user.username;

SELECT position_id, position_name FROM position;
SELECT education_degree_id, education_degree_name FROM education_degree;
SELECT education_degree_id, education_degree_name FROM education_degree;

INSERT INTO employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);

SELECT employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id FROM employee WHERE employee_id = 1;

UPDATE employee SET employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ? WHERE employee_id = ?;

-- DELETE FROM employee WHERE employee_id = ?;

-- Search Employee
SELECT employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address,employee.position_id, employee.education_degree_id, employee.division_id, employee.username 
FROM employee INNER JOIN position ON employee.position_id = position.position_id 
INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id
INNER JOIN division ON employee.division_id = division.division_id
LEFT JOIN user ON employee.username = user.username
WHERE employee_name LIKE CONCAT("%","k","%")
ORDER BY employee_id;

-- Sort employee by id
SELECT employee_id, employee_name,employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address,employee.position_id, employee.education_degree_id, employee.division_id, employee.username
FROM employee INNER JOIN position ON employee.position_id = position.position_id 
INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id
INNER JOIN division ON employee.division_id = division.division_id
LEFT JOIN user ON employee.username = user.username
ORDER BY employee_id;

-- Sort employee by name
SELECT employee_id, employee_name,employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address,employee.position_id, employee.education_degree_id, employee.division_id, employee.username
FROM employee INNER JOIN position ON employee.position_id = position.position_id 
INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id
INNER JOIN division ON employee.division_id = division.division_id
LEFT JOIN user ON employee.username = user.username
ORDER BY employee_name;

-- Sort employee by birthday
SELECT employee_id, employee_name,employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address,employee.position_id, employee.education_degree_id, employee.division_id, employee.username
FROM employee INNER JOIN position ON employee.position_id = position.position_id 
INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id
INNER JOIN division ON employee.division_id = division.division_id
LEFT JOIN user ON employee.username = user.username
ORDER BY employee_birthday DESC;

-- Sort employee by salary
SELECT employee_id, employee_name,employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address,employee.position_id, employee.education_degree_id, employee.division_id, employee.username
FROM employee INNER JOIN position ON employee.position_id = position.position_id 
INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id
INNER JOIN division ON employee.division_id = division.division_id
LEFT JOIN user ON employee.username = user.username
ORDER BY employee_salary;

-- select all service
SELECT service_id, service_code, service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, service.rent_type_id, service.service_type_id FROM service
INNER JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id
INNER JOIN service_type ON service.service_type_id = service_type.service_type_id
ORDER BY service_id;

-- select all rent_type
SELECT rent_type_id, rent_type_name, rent_type_cost FROM rent_type;

-- select all service_type
SELECT service_type_id, service_type_name FROM service_type;

-- INSERT INTO table customer
INSERT INTO customer(customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, " +
                    "customer_address, customer_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);



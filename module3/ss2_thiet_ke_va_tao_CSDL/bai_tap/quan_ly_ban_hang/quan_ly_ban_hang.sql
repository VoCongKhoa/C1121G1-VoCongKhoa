create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table product(
p_id varchar(50) not null primary key,
p_name varchar(255),
p_price double
);

create table customer(
c_id int not null primary key auto_increment,
c_name varchar(255),
c_age int
);

create table `order`(
o_id int not null primary key auto_increment,
c_id int not null,
o_date datetime,
o_total_price double,
foreign key (c_id) references customer(c_id)
);

create table order_detail(
o_id int not null,
p_id varchar(50) not null,
od_quantity int,
primary key (o_id,p_id),
foreign key (o_id) references `order`(o_id),
foreign key (p_id) references product(p_id)
);
create database products_demo;
use products_demo;

create table products (
  id int not null auto_increment,
  product_code varchar(45) not null,
  product_name varchar(45) not null,
  product_price double not null,
  product_amount int not null,
  product_description varchar(255) null,
  product_status bit(1) not null,
  primary key (id));
  
  

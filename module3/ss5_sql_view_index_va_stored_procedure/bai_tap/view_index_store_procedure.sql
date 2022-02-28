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
  
insert into products (id, product_code, product_name, product_price, product_amount, product_description, product_status) 
values (1, 'MG', 'máy giặt', 10, 1, 'loại vừa', 1),
(2, 'MS', 'máy sấy', 3, 2, 'nhỏ', 1),
(3, 'TV', 'tivi', 15, 1, '42 inch', 1),
(4, 'TL', 'tủ lạnh', 20, 1, null, 1),
(5, 'DP', 'đèn pin', 1, 2, null, 0),
(6, 'B', 'bàn', 3, 4, 'lớn', 1),
(7, 'G', 'ghế', 4, 15, 'to', 1),
(8, 'BD', 'bếp điện', 16, 1, 'bị hư', 0),
(9, 'BT', 'bếp từ', 20, 1, 'đang sửa', 1),
(10, 'XM', 'xe máy', 50, 4, 'bình thường', 1),
(11, 'OT', 'ô tô', 1000, 1, 'đang hư', 0),
(12, 'V', 'vở', 1, 10, null, 1),
(13, 'S', 'sách', 1, 10, null, 1),
(14, 'TN', 'tai nghe', 2, 1, null, 1),
(15, 'MT', 'máy tính', 15, 2, 'đang hư', 1);

-- Bước 3:
explain select * from products where product_code = 'OT';
alter table products add unique index idx_product_code(product_code);
explain select * from products where product_code = 'OT';

explain select * from products where product_name = 'bếp điện' and product_price = 1;
alter table products add index idx_product_name_product_price( product_name, product_price);  
explain select * from products where product_name = 'bếp điện' and product_price = 1;

alter table products drop index idx_product_code;
alter table products drop index idx_product_name_product_price;

-- Bước 4:
create view products_view as
select product_code, product_name, product_price, product_status
from products;

select * from products_view;
set sql_safe_updates = 0;
update products
set product_status = 1
where product_code = 'DP';
set sql_safe_updates = 1;

set sql_safe_updates = 0;
delete from products
where product_code = 'BD';
set sql_safe_updates = 1;

-- Bước 5:
delimiter //
create procedure get_all_product()
begin
    select* from products;
end
//delimiter ;
call get_all_product;

delimiter //
create procedure add_new_product(
id int,
product_code varchar(45),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(255),
product_status bit(1)
)
begin
insert into products (id, product_code, product_name, product_price, product_amount, product_description, product_status) 
values (id, product_code, product_name, product_price, product_amount, product_description, product_status);
end
//delimiter ;
call add_new_product(16,'DP2','đèn pin 2',1,2,null,0);
call get_all_product;

delimiter //
create procedure edit_product_status_by_id(
id int
)
begin
	update products
    set product_status = 1
    where products.id = id;
end
//delimiter ;
call edit_product_status_by_id(16);

delimiter //
create procedure delete_product_by_id(
id int
)
begin
	delete from products
    where products.id = id;
end
//delimiter ;
call delete_product_by_id(16);

-- drop database products_demo;

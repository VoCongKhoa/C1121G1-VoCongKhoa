
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

use quan_ly_ban_hang;

-- Phải drop khoá ngoại trước, rồi mới đổi KDL, sau đó mới cài đặt lại foreign key
-- `order_detail_ibfk_2` là foreign key name
alter table `quan_ly_ban_hang`.`order_detail` 
drop foreign key `order_detail_ibfk_2`;
alter table order_detail
modify column p_id int not null;
alter table product
modify column p_id int not null auto_increment;
alter table order_detail
add foreign key (p_id) references product(p_id);


-- [Bài tập] Thao tác với CSDL Quản lý bán hàng
-- Thêm dữ liệu cho các bảng
insert into customer(c_name, c_age)
values ('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);
select c_id, c_name, c_age from customer;

insert into `order`(c_id, o_date)
values (1,'2006-3-21'),
(2,'2006-3-23'),
(1,'2006-3-16');
select o_id, c_id, o_date, o_total_price from `order`;

insert into product(p_name, p_price)
values ('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',1);
select p_id, p_name, p_price from product;

insert into order_detail(o_id, p_id, od_quantity)
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
select o_id, p_id, od_quantity from order_detail;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id, o_date, o_total_price from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.c_name, product.p_name
from product
inner join `order_detail` on product.p_id = `order_detail`.p_id
inner join `order` on order_detail.o_id = `order`.o_id
inner join customer on `order`.c_id = customer.c_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.c_id, customer.c_name, customer.c_age
from customer
left join `order`on customer.c_id =  `order`.c_id
where `order`.o_id is null;

-- Dùng EXISTS để Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select *
from customer
where not exists(
select * from `order`where customer.c_id = `order`.c_id);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.o_id, `order`.o_date, (order_detail.od_quantity * product.p_price) as total_bill
from `order`
inner join order_detail on `order`.o_id = order_detail.o_id
inner join product on order_detail.p_id = product.p_id;

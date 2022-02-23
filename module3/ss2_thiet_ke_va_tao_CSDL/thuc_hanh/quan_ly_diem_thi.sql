create database quan_ly_diem_thi;
use quan_ly_diem_thi;
create table hoc_sinh(
ma_hoc_sinh int not null auto_increment,
ten_hoc_sinh varchar(255) not null,
ngay_sinh date,
lop varchar(20),
gt varchar(20),
primary key(ma_hoc_sinh)
);

create table mon_hoc(
ma_mon_hoc int not null auto_increment,
ten_mon_hoc varchar(50) not null,
ma_giao_vien varchar(50) not null,
primary key(ma_mon_hoc)
);
alter table hoc_sinh modify column ma_hoc_sinh varchar(50) not null;
alter table mon_hoc modify column ma_mon_hoc varchar(50) not null;
create table bang_diem(
ma_hoc_sinh varchar(50) not null,
ma_mon_hoc varchar(50) not null,
diem_thi int,
ngay_kiem_tra date,
primary key(ma_hoc_sinh,ma_mon_hoc),
foreign key (ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh),
foreign key (ma_mon_hoc) references mon_hoc(ma_mon_hoc)
);

create table giao_vien(
ma_giao_vien varchar(50) not null,
ten_giao_vien varchar(255),
so_dien_thoai varchar(50),
ma_mon_hoc varchar(50),
primary key(ma_giao_vien),
foreign key (ma_mon_hoc) references mon_hoc(ma_mon_hoc)
);
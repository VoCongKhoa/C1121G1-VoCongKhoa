create database quan_ly_nhap_xuat;
use quan_ly_nhap_xuat;
create table nha_cung_cap(
ma_nha_cung_cap varchar(50) not null primary key,
ten_nha_cung_cap varchar(255),
dia_chi varchar(255),
so_dien_thoai varchar(50)
);

create table don_dat_hang(
so_don_hang int not null primary key auto_increment,
ngay_dat_hang datetime,
ma_nha_cung_cap varchar(50) not null,
foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table vat_tu(
ma_vat_tu varchar(50) not null primary key,
ten_vat_tu varchar(255)
);

create table chi_tiet_don_dat_hang(
ma_vat_tu varchar(50) not null,
so_don_hang int not null,
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_don_hang) references don_dat_hang(so_don_hang),
primary key(ma_vat_tu,so_don_hang)
);

create table phieu_xuat(
so_phieu_xuat int not null primary key auto_increment,
ngay_xuat datetime
);

create table chi_tiet_phieu_xuat(
don_gia_xuat double,
so_luong_xuat int,
so_phieu_xuat int not null,
ma_vat_tu varchar(50) not null,
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
primary key(ma_vat_tu,so_phieu_xuat)
);

create table phieu_nhap(
so_phieu_nhap int not null primary key auto_increment,
ngay_nhap datetime
);

create table chi_tiet_phieu_nhap(
don_gia_nhap double,
so_luong_nhap int,
so_phieu_nhap int not null,
ma_vat_tu varchar(50) not null,
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
primary key(ma_vat_tu,so_phieu_nhap)
);

-- drop database quan_ly_nhap_xuat;
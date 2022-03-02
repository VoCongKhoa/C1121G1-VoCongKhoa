create database quan_ly_khu_nghi_duong_Furama;
use quan_ly_khu_nghi_duong_Furama;
create table vi_tri(
ma_vi_tri int not null auto_increment,
ten_vi_tri varchar(45),
primary key(ma_vi_tri)
);

create table trinh_do(
ma_trinh_do int not null auto_increment,
ten_trinh_do varchar(45),
primary key(ma_trinh_do)
);

create table bo_phan(
ma_bo_phan int not null auto_increment,
ten_bo_phan varchar(45),
primary key(ma_bo_phan)
);

create table nhan_vien(
ma_nhan_vien int not null auto_increment,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong double not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int not null,
ma_trinh_do int not null,
ma_bo_phan int not null,
primary key(ma_nhan_vien),
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri) on update cascade on delete cascade,
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do) on update cascade on delete cascade,
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan) on update cascade on delete cascade
);

-- Đổi tên cột ho_ten_nhan_vien
-- alter table nhan_vien
-- rename column ho_ten_nhan_vien to ho_ten;

create table loai_khach(
ma_loai_khach int not null auto_increment,
ten_loai_khach varchar(45),
primary key(ma_loai_khach)
);

create table khach_hang(
ma_khach_hang int not null auto_increment,
ho_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh bit(1) not null,
so_cmnd varchar(45) not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_loai_khach int not null,
primary key(ma_khach_hang),
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach) on update cascade on delete cascade
);

create table kieu_thue(
ma_kieu_thue int not null auto_increment,
ten_kieu_thue varchar(45),
primary key(ma_kieu_thue)
);

create table loai_dich_vu(
ma_loai_dich_vu int not null auto_increment,
ten_loai_dich_vu varchar(45),
primary key(ma_loai_dich_vu)
);

create table dich_vu(
ma_dich_vu int not null auto_increment,
ten_dich_vu varchar(45) not null,
dien_tich double,
chi_phi_thue double not null,
so_nguoi_toi_da int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
ma_kieu_thue int not null,
ma_loai_dich_vu int not null,
primary key(ma_dich_vu),
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue) on update cascade on delete cascade,
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu) on update cascade on delete cascade
);

create table hop_dong(
ma_hop_dong int not null auto_increment,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int not null,
ma_khach_hang int not null,
ma_dich_vu int not null,
primary key(ma_hop_dong),
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien) on update cascade on delete cascade,
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang) on update cascade on delete cascade,
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu) on update cascade on delete cascade
);

create table dich_vu_di_kem(
ma_dich_vu_di_kem int not null auto_increment,
ten_dich_vu_di_kem varchar(45) not null,
gia_tien double,
don_vi varchar(10) not null,
trang_thai varchar(45),
primary key(ma_dich_vu_di_kem)
);

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int not null,
so_luong int not null,
ma_hop_dong int not null,
ma_dich_vu_di_kem int not null,
primary key(ma_hop_dong_chi_tiet),
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong) on update cascade on delete cascade,
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem) on update cascade on delete cascade
);

insert into vi_tri(ma_vi_tri, ten_vi_tri)
values (1,'Quản Lý'),
(2,'Nhân Viên');
-- select ma_vi_tri, ten_vi_tri from vi_tri;

insert into trinh_do(ma_trinh_do, ten_trinh_do)
values (1,'Trung Cấp'),
(2,'Cao Đẳng'),
(3,'Đại Học'),
(4,'Sau Đại Học');
-- select ma_trinh_do, ten_trinh_do from trinh_do;

insert into bo_phan (ma_bo_phan, ten_bo_phan) 
values (1, 'Sale-Marketing'),
(2, 'Hành chính'),
(3, 'Phục vụ'),
(4, 'Quản lý');
-- select * from bo_phan;

insert into nhan_vien(ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan) 
values (1, 'Nguyễn Văn An', '1970-11-07', '456231786', '10000000', '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
(2, 'Lê Văn Bình', '1997-04-09', '654231234', '7000000', '0934212314', 'binhlv@gmail.com', '22 Yên Bái, đà Nẵng', '1', '2', '2'),
(3, 'Hồ Thị Yến', '1995-12-12', '999231723', '14000000', '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
(4, 'Võ Công Toản', '1980-04-04', '123231365', '17000000', '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
(5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', '6000000', '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
(6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', '7000000', '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
(7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', '8000000', '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
(8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', '9000000', '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
(9, 'Tòng Hoang', '1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
(10, 'Nguyễn Công Đạo', '1994-01-08', '755434343', '8000000', '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
-- select * from nhan_vien;

insert into loai_khach(ma_loai_khach, ten_loai_khach)
values (1, 'Diamond'),
(2, 'Platinium'),
(3, 'Gold'),
(4, 'Silver'),
(5, 'Member');
-- select ma_loai_khach, ten_loai_khach from loai_khach;

insert into khach_hang(ma_khach_hang, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach) 
values (1, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
(2, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
(3, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
(4, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
(5, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
(6, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
(7, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
(8, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
(9, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
(10, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);
-- select * from khach_hang;

insert into kieu_thue(ma_kieu_thue, ten_kieu_thue)
values (1,'year'),
(2,'month'),
(3,'day'),
(4,'hour');
-- select * from kieu_thue;

insert into loai_dich_vu(ma_loai_dich_vu, ten_loai_dich_vu)
values (1,'Villa'),
(2,'House'),
(3,'Room');
-- select * from loai_dich_vu;

insert into dich_vu (ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu) 
values (1, 'Villa Beach Front', 25000, 10000000, 10, 'vip', 'Có hồ bơi', 500, 4, 3, 1),
(2, 'House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, 3, 2, 2),
(3, 'Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', null, null, 4, 3),
(4, 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, 3, 1),
(5, 'House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null, 2, 3, 2),
(6, 'Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, 4, 3);
-- select * from dich_vu;

insert into dich_vu_di_kem(ma_dich_vu_di_kem, ten_dich_vu_di_kem, gia_tien, don_vi, trang_thai) 
values (1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
(2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
(3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
(4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
-- select * from dich_vu_di_kem;

insert into hop_dong(ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
values (1, '2020-12-08', '2020-12-08', 0, 3, 1, 3),
(2, '2020-07-14', '2020-07-21', '200000', 7, 3, 1),
(3, '2021-03-15', '2021-03-17', '50000', 3, 4, 2),
(4, '2021-01-14', '2021-01-18', '100000', 7, 5, 5),
(5, '2021-07-14', '2021-07-15', 0, 7, 2, 6),
(6, '2021-06-01', '2021-06-03', 0, 7, 7, 6),
(7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4),
(8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1),
(9, '2020-11-19', '2020-11-19', 0, 3, 4, 3),
(10, '2021-04-12', '2021-04-14', 0, 10, 3, 5),
(11, '2021-04-25', '2021-04-25', 0, 2, 2, 1),
(12, '2021-05-25', '2021-05-27', 0, 7, 10, 1);
-- select * from hop_dong;

insert into hop_dong_chi_tiet(ma_hop_dong_chi_tiet, so_luong, ma_hop_dong, ma_dich_vu_di_kem) 
values (1, 5, 2, 4),
(2, 8, 2, 5),
(3, 15, 2, 6),
(4, 1, 3, 1),
(5, 11, 3, 2),
(6, 1, 1, 3),
(7, 2, 1, 2),
(8, 2, 12, 2);
-- select * from hop_dong_chi_tiet;

-- Câu 2:
select ma_nhan_vien, ho_ten,(char_length(ho_ten)) as chieu_dai_ho_ten , ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan 
from nhan_vien 
where ((ho_ten like 'h%') or (ho_ten like 't%') or (ho_ten like 'k%')) and (char_length(ho_ten)) <=15;

-- Câu 3:
select ma_khach_hang, ho_ten, ngay_sinh, (round(datediff(curdate(),ngay_sinh)/365,0)) as do_tuoi, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach 
from khach_hang 
where (round(datediff(curdate(),ngay_sinh)/365,0) between 18 and 50) and (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');

-- Câu 4:
select loai_khach.ma_loai_khach, loai_khach.ten_loai_khach, khach_hang.ho_ten, count(ho_ten) as so_lan_dat_phong  
from loai_khach
inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where loai_khach.ten_loai_khach = 'Diamond'
group by ho_ten
order by so_lan_dat_phong desc;

-- Câu 5:
create temporary table bang_tam_tinh_tong_tien_dvdk
select hop_dong.ma_khach_hang, hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.ma_dich_vu,
(sum(ifnull(hop_dong_chi_tiet.so_luong,0) * ifnull(dich_vu_di_kem.gia_tien,0)) + ifnull(dich_vu.chi_phi_thue,0)) as tong_tien
from dich_vu 
inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong
order by hop_dong.ma_hop_dong;

select khach_hang.ma_khach_hang, loai_khach.ten_loai_khach, khach_hang.ho_ten, bang_tam_tinh_tong_tien_dvdk.ma_hop_dong, dich_vu.ten_dich_vu, 
bang_tam_tinh_tong_tien_dvdk.ngay_lam_hop_dong, bang_tam_tinh_tong_tien_dvdk.ngay_ket_thuc,
sum(ifnull(bang_tam_tinh_tong_tien_dvdk.tong_tien,0)) as tong_chi_phi
from dich_vu
inner join bang_tam_tinh_tong_tien_dvdk on bang_tam_tinh_tong_tien_dvdk.ma_dich_vu = dich_vu.ma_dich_vu
right join khach_hang on khach_hang.ma_khach_hang = bang_tam_tinh_tong_tien_dvdk.ma_khach_hang
right join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
group by khach_hang.ma_khach_hang
order by khach_hang.ma_khach_hang;

-- Câu 6:
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from loai_dich_vu
inner join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where hop_dong.ngay_lam_hop_dong not between '2021-1-1 00:00:00' and '2021-3-31 23:59:59'
group by dich_vu.ma_dich_vu;

-- Câu 7:
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich,dich_vu.so_nguoi_toi_da , dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from loai_dich_vu
inner join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where (hop_dong.ngay_lam_hop_dong between '2020-1-1 00:00:00' and '2020-12-31 23:59:59')
and (hop_dong.ngay_lam_hop_dong not between '2021-1-1 00:00:00' and '2021-12-31 23:59:59')
group by dich_vu.ma_dich_vu;

-- Câu 8:
-- Cách 1:
select * from khach_hang
group by ho_ten;
-- Cách 2:
select distinct ho_ten from khach_hang;
-- Cách 3:
select *, count(*) as so_lan_trung_lap from khach_hang
group by ho_ten
having so_lan_trung_lap >=1;

-- Câu 9:
select month(hop_dong.ngay_lam_hop_dong) as thang_lam_hop_dong, count(hop_dong.ma_hop_dong) as so_luong_hop_dong
from hop_dong
inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
group by thang_lam_hop_dong
order by thang_lam_hop_dong;

-- Câu 10:
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, 
dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem, hop_dong_chi_tiet.ma_dich_vu_di_kem
from hop_dong
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong_chi_tiet.ma_dich_vu_di_kem;

-- Câu 11:
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from loai_khach
inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
inner join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where loai_khach.ten_loai_khach = 'Diamond' and (khach_hang.dia_chi like '%Vinh%' or khach_hang.dia_chi like '%Quảng Ngãi%');

-- Câu 12:
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu, 
sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc
from khach_hang
inner join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
inner join nhan_vien on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where ((hop_dong.ngay_lam_hop_dong between '2020-10-1 00:00:00' and '2020-12-31 23:59:59') 
or (hop_dong.ngay_ket_thuc between '2020-10-1 00:00:00' and '2020-12-31 23:59:59'))
and ((hop_dong.ngay_lam_hop_dong not between '2021-1-1 00:00:00' and '2021-6-30 23:59:59')
or (hop_dong.ngay_ket_thuc between '2020-10-1 00:00:00' and '2020-12-31 23:59:59'))
group by hop_dong.ma_hop_dong;

-- Câu 13:
select ma_dich_vu_di_kem, 
(
select ten_dich_vu_di_kem 
from dich_vu_di_kem
where dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
) as ten_dich_vu_di_kem,
sum(so_luong) as tong_so_luong
from hop_dong_chi_tiet 
group by ma_dich_vu_di_kem
having tong_so_luong = (
	select max(so_luong) as max_so_luong
	from (
		select dich_vu_di_kem.ma_dich_vu_di_kem ,dich_vu_di_kem.ten_dich_vu_di_kem ,sum(hop_dong_chi_tiet.so_luong) as so_luong
		from dich_vu_di_kem inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
		group by hop_dong_chi_tiet.ma_dich_vu_di_kem
	) as bang_so_luong_dich_vu_di_kem
);

-- select *
-- from (select dich_vu_di_kem.ma_dich_vu_di_kem ,dich_vu_di_kem.ten_dich_vu_di_kem ,sum(hop_dong_chi_tiet.so_luong) as so_luong
-- from dich_vu_di_kem inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
-- group by hop_dong_chi_tiet.ma_dich_vu_di_kem) as bang_tam_so_luong_dich_vu_di_kem
-- where bang_tam_so_luong_dich_vu_di_kem.so_luong = (
-- select max(bang_tam_so_luong_dich_vu_di_kem.so_luong) as max_so_luong 
-- from bang_tam_so_luong_dich_vu_di_kem
-- );

-- select max(tong_so_luong)
-- from (
-- select hop_dong_chi_tiet.ma_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as tong_so_luong
-- from hop_dong_chi_tiet 
-- group by hop_dong_chi_tiet.ma_dich_vu_di_kem
-- ) as a
-- group by hop_dong_chi_tiet.ma_dich_vu_di_kem;

-- select * from hop_dong_chi_tiet where hop_dong_chi_tiet.so_luong >= all(
-- select dich_vu_di_kem.ten_dich_vu_di_kem ,sum(hop_dong_chi_tiet.so_luong) as so_luong
-- from dich_vu_di_kem
-- inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
-- group by hop_dong_chi_tiet.ma_dich_vu_di_kem
-- order by so_luong);

-- Câu 14:
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, 
count(hop_dong_chi_tiet.ma_hop_dong_chi_tiet) as so_lan_su_dung
from dich_vu_di_kem
inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung = 1
order by hop_dong.ma_hop_dong;

-- Câu 15:
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi,
count(hop_dong.ma_hop_dong) as so_luong_hop_dong
from hop_dong
inner join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
inner join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
inner join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
where year(hop_dong.ngay_lam_hop_dong) between 2020 and 2021
group by nhan_vien.ma_nhan_vien
having so_luong_hop_dong <= 3;

-- Câu 16:
-- Lấy ra được thông tin nhân viên, nhưng không xoá như đề yêu cầu
-- Cách 1: drop khoá ngoại trước, sau đó alter lại khoá ngoại là ON DELETE CASCADE và ON UPDATE CASCADE
-- sau đó delete
-- ALTER TABLE `quan_ly_khu_nghi_duong_furama`.`hop_dong` 
-- DROP FOREIGN KEY `hop_dong_ibfk_1`;
-- ALTER TABLE `quan_ly_khu_nghi_duong_furama`.`hop_dong` 
-- ADD CONSTRAINT `hop_dong_ibfk_1`
--   FOREIGN KEY (`ma_nhan_vien`)
--   REFERENCES `quan_ly_khu_nghi_duong_furama`.`nhan_vien` (`ma_nhan_vien`)
--   ON DELETE CASCADE
--   ON UPDATE CASCADE;
select * from nhan_vien;
set sql_safe_updates = 0;
delete from nhan_vien
where ma_nhan_vien not in(
select hop_dong.ma_nhan_vien 
from hop_dong 
where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021
);
set sql_safe_updates = 1;

-- Cách 2: là khi khai báo bảng, khai báo trực tiếp cho toán bộ khoá ngoại:
-- foreign key(ma_vi_tri) references vi_tri(ma_vi_tri) on update cascade on delete cascade
-- sau đó có thể delete như

-- Câu 17:
create temporary table bang_tam_update 
select khach_hang.ma_khach_hang
from dich_vu_di_kem 
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
inner join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
where year(hop_dong.ngay_lam_hop_dong) = 2021 and dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia_tien > 10000000
order by khach_hang.ma_khach_hang;

set sql_safe_updates = 0;
update khach_hang
set khach_hang.ma_loai_khach = 1
where khach_hang.ma_khach_hang = (select * from bang_tam_update);
set sql_safe_updates = 1;

-- Làm sao lấy ra được 1 trường trong kết quả trả về của câu subquery???
-- Trường hợp bên dưới, tong_tien không thể thay thế cho (dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia_tien)
-- trong mệnh đề WHERE???
-- select khach_hang.ma_khach_hang 
-- from khach_hang
-- where ma_khach_hang in (
-- select khach_hang.ma_khach_hang, loai_khach.ten_loai_khach, khach_hang.ho_ten, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, 
-- hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, (dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia_tien) as tong_tien
-- from dich_vu_di_kem 
-- inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
-- inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
-- inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
-- inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
-- inner join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
-- where year(hop_dong.ngay_lam_hop_dong) = 2021 and dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia_tien > 10000000
-- order by khach_hang.ma_khach_hang);


-- Câu 18:
-- ALTER TABLE `quan_ly_khu_nghi_duong_furama`.`hop_dong` 
-- DROP FOREIGN KEY `hop_dong_ibfk_2`;
-- ALTER TABLE `quan_ly_khu_nghi_duong_furama`.`hop_dong` 
-- ADD CONSTRAINT `hop_dong_ibfk_2`
--   FOREIGN KEY (`ma_khach_hang`)
--   REFERENCES `quan_ly_khu_nghi_duong_furama`.`khach_hang` (`ma_khach_hang`)
--   ON DELETE CASCADE
--   ON UPDATE CASCADE;
select khach_hang.ma_khach_hang, khach_hang.ho_ten from khach_hang;
select * from hop_dong;
set sql_safe_updates =0;
delete from khach_hang
where khach_hang.ma_khach_hang in (
select hop_dong.ma_khach_hang 
from hop_dong 
where year(hop_dong.ngay_lam_hop_dong) < 2021
);
set sql_safe_updates =1;

-- Câu 19:
set sql_safe_updates =0;
update dich_vu_di_kem
set dich_vu_di_kem.gia_tien = dich_vu_di_kem.gia_tien*2
where dich_vu_di_kem.ma_dich_vu_di_kem in (
select hop_dong_chi_tiet.ma_dich_vu_di_kem 
from hop_dong_chi_tiet 
where hop_dong_chi_tiet.so_luong > 10
);
set sql_safe_updates =1;

-- Câu 20:
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.ngay_sinh, nhan_vien.so_dien_thoai, nhan_vien.email, nhan_vien.dia_chi,
'nhan_vien' as 'role'
from nhan_vien
union all 
select khach_hang.ma_khach_hang, khach_hang.ho_ten, khach_hang.ngay_sinh, khach_hang.so_dien_thoai, khach_hang.email, khach_hang.dia_chi,
'khach_hang' as 'role'
from khach_hang;

-- Câu 21:
insert into nhan_vien(ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
values (11, 'Nguyễn Văn Võ','1992-01-01','534345231',8000000,'0941278553','nvv0101@gmail.com','Hải Châu, Đà Nẵng',2,3,2);
insert into hop_dong (ma_hop_dong, ngay_lam_hop_dong,ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
values (13, '2019-12-12', '2019-12-15', 0, 11, 2, 6);
create view v_nhan_vien as
select nhan_vien.* from nhan_vien 
where nhan_vien.dia_chi like concat('%','Hải Châu','%') 
and nhan_vien.ma_nhan_vien = (
select hop_dong.ma_nhan_vien 
from hop_dong 
where datediff(hop_dong.ngay_lam_hop_dong,STR_TO_DATE('12/12/2019', '%d/%m/%Y')) = 0
);
select * from v_nhan_vien;

-- Câu 22:
update v_nhan_vien
set dia_chi = 'Liên Chiểu, Đà Nẵng';

-- Câu 23:
delimiter //
create procedure sp_xoa_khach_hang(
ma_khach_hang_xoa int
)
begin
set sql_safe_updates = 0;
delete from khach_hang
where khach_hang.ma_khach_hang = ma_khach_hang_xoa;
set sql_safe_updates = 1;
end
//delimiter ;

-- Câu 24:
delimiter //
create procedure sp_them_moi_hop_dong(
ma_hop_dong int,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int, 
ma_dich_vu int
)
begin
	if (ma_hop_dong <= 0 or ma_nhan_vien <= 0 or ma_khach_hang <= 0 or ma_dich_vu <= 0) then
		signal sqlstate '45000' set message_text = 'Mã phải nhập số lớn hơn 0';
        elseif tien_dat_coc < 0 then
			signal sqlstate '45000' set message_text = 'Tiền đặt cọc phải là số dương';
		elseif ma_hop_dong in (select hop_dong.ma_hop_dong from hop_dong) then
			signal sqlstate '45000' set message_text = 'Mã hợp đồng bị trùng';
        elseif (ngay_lam_hop_dong is null) then
			signal sqlstate '45000' set message_text = 'Ngày làm hợp đồng không được null';
        elseif (ngay_ket_thuc is null) then
			signal sqlstate '45000' set message_text = 'Ngày kết thúc hợp đồng không được null';
        elseif (tien_dat_coc is null) then
			signal sqlstate '45000' set message_text = 'Tiền đặt cọc không được null';
        elseif (ma_nhan_vien is null) then
			signal sqlstate '45000' set message_text = 'Mã nhân viên không được null';
        elseif (ma_khach_hang is null) then
			signal sqlstate '45000' set message_text = 'Mã khách hàng không được null';
        elseif (ma_dich_vu is null) then
			signal sqlstate '45000' set message_text = 'Mã dịch vụ không được null';
        elseif ma_nhan_vien not in (select nhan_vien.ma_nhan_vien from nhan_vien) then
			signal sqlstate '45000' set message_text = 'Mã nhân viên không tồn tại';
        elseif ma_khach_hang not in (select khach_hang.ma_khach_hang from khach_hang) then
			signal sqlstate '45000' set message_text = 'Mã khách hàng không tồn tại';
        elseif ma_dich_vu not in (select dich_vu.ma_dich_vu from dich_vu) then
			signal sqlstate '45000' set message_text = 'Mã dịch vụ không tồn tại';
        else
			insert into hop_dong(hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
            hop_dong.tien_dat_coc, hop_dong.ma_nhan_vien, hop_dong.ma_khach_hang, hop_dong.ma_dich_vu) 
            values (ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu);
	 end if;
end
//delimiter ;

-- drop procedure sp_them_moi_hop_dong;
call sp_them_moi_hop_dong(14,'2021-12-12','2021-12-12',12,11,10,6); -- Lỗi ma_hop_dong bị trùng
call sp_them_moi_hop_dong(14,'2021-12-12','2021-12-12',12,11,10,6); -- Lỗi ma_hop_dong bị trùng
call sp_them_moi_hop_dong(16,null,'2021-12-12',12,11,10,6); -- Lỗi ngay_lam_hop_dong bị null
call sp_them_moi_hop_dong(17,'2021-12-12',null,12,11,10,6); -- Lỗi ngay_ket_thuc bị null
call sp_them_moi_hop_dong(18,'2021-12-12','2021-12-12',null,11,10,6); -- Lỗi tien_dat_coc bị null
call sp_them_moi_hop_dong(19,'2021-12-12','2021-12-12',12,null,10,6); -- Lỗi ma_nhan_vien bị null
call sp_them_moi_hop_dong(20,'2021-12-12','2021-12-12',12,11,null,6); -- Lỗi ma_khach_hang bị null
call sp_them_moi_hop_dong(21,'2021-12-12','2021-12-12',12,11,10,null); -- Lỗi ma_dich_vu bị null
call sp_them_moi_hop_dong(22,'2021-12-12','2021-12-12',12,12,10,6); -- Lỗi ma_nhan_vien không tồn tại
call sp_them_moi_hop_dong(23,'2021-12-12','2021-12-12',12,11,11,6); -- Lỗi ma_khach_hang không tồn tại
call sp_them_moi_hop_dong(21,'2021-12-12','2021-12-12',12,11,10,7); -- Lỗi ma_dich_vu không tồn tại
call sp_them_moi_hop_dong(-22,'2021-12-12','2021-12-12',12,11,10,6); -- Lỗi mã phải nhập số lớn hơn 0
call sp_them_moi_hop_dong(23,'2021-12-12','2021-12-12',-12,11,10,6); -- Lỗi tiền đặt cọc phải là số dương

-- Câu 25: 
-- create temporary table so_luong_hop_dong as
-- select count(hop_dong.ma_hop_dong) as so_luong_hop_dong from hop_dong;
set @so_luong_hop_dong = (select count(hop_dong.ma_hop_dong) from hop_dong);
select @so_luong_hop_dong;

delimiter //
create trigger tr_xoa_hop_dong after delete on hop_dong for each row
begin
-- update so_luong_hop_dong
set @so_luong_hop_dong = (select count(hop_dong.ma_hop_dong) from hop_dong);
end
//delimiter ;

set sql_safe_updates = 0;
delete from hop_dong
where hop_dong.ma_hop_dong = 14;
set sql_safe_updates = 1;
select @so_luong_hop_dong;

-- Câu 26:
delimiter //
create trigger tr_cap_nhat_hop_dong after update on hop_dong for each row
begin
	if datediff(new.ngay_ket_thuc,new.ngay_lam_hop_dong) < 2 then
		signal sqlstate '45000' set message_text = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
      end if;  
end
//delimiter ;

update hop_dong
set hop_dong.ngay_ket_thuc = '2021-12-14'
where hop_dong.ma_hop_dong = 14;

use quan_ly_khu_nghi_duong_Furama;
-- drop database quan_ly_khu_nghi_duong_Furama;


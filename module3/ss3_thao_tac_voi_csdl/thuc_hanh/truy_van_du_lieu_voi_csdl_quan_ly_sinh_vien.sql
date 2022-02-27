use quan_ly_sinh_vien;
-- [Thực hành] Truy vấn dữ liệu với CSDL Quản lý sinh viên
use QuanLySinhVien;
select * from student;
select * from student where `status` = true;
select * from `subject` where credit < 10;
select * from student inner join class on student.class_ID = class.class_ID where class_name = 'A1';
select subject_name, mark from mark inner join `subject` on mark.subject_ID = `subject`.subject_ID where subject_name = 'CF';
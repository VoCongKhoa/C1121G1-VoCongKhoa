use quan_ly_sinh_vien;

-- [Bài tập] Truy vấn dữ liệu với CSDL Quản lý sinh viên
use QuanLySinhVien;
select student_ID, student_name, address, phone, `status`, class_ID from student;
select class_ID, class_name, start_date, `status` from class;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select student_ID, student_name, address, phone, `status`, class_ID from student where student_name like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select class_ID, class_name, start_date, `status` from class where month(start_date) = 12 and `status` = true;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select subject_ID, subject_name, credit, `status` from `subject` where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set sql_safe_updates = 0;
update student set class_ID = 2 where student_name = 'Hung';
set sql_safe_updates = 1;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select student_name, subject_name, mark 
from mark 
inner join student on mark.student_ID = student.student_ID
inner join `subject` on mark.subject_ID = `subject`.subject_ID
order by mark desc, student.student_name asc ;
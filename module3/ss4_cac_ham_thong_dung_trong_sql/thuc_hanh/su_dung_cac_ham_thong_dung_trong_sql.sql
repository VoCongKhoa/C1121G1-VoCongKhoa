use quan_ly_sinh_vien;

-- Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select address, count(student_ID) as so_luong_hoc_sinh
from student
group by address;

--  Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
select student.student_ID, student.student_name, avg(mark.mark)
from student
inner join mark on student.student_ID = mark.student_ID
group by student.student_ID, student.student_name;

-- Hiển thị những bạn học viên có điểm trung bình các môn học lớn hơn 15
select student.student_ID, student.student_name, avg(mark.mark) as mark_avg
from student
inner join mark on student.student_ID = mark.student_ID
group by student.student_ID, student.student_name
having mark_avg > 15;

--  Hiển thị thông tin các học viên có điểm trung bình lớn nhất
select student.student_ID, student.student_name, avg(mark.mark) as mark_avg
from student
inner join mark on student.student_ID = mark.student_ID
group by student.student_ID, student.student_name
having mark_avg >= all (select avg(mark.mark) from mark group by mark.student_ID);

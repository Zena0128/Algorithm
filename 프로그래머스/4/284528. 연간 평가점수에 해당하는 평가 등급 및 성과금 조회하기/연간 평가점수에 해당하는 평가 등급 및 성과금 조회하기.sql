-- 코드를 작성해주세요
select e.emp_no, e.emp_name,
case
when g.score >= 96 then 'S'
when g.score >= 90 then 'A'
when g.score >= 80 then 'B'
else 'C'
end as grade,
case
when g.score >= 96 then e.sal*0.2
when g.score >= 90 then e.sal*0.15
when g.score >= 80 then e.sal*0.1
else e.sal*0
end as bonus
from (select emp_no, avg(score) as score from hr_grade group by emp_no) as g, hr_employees as e
where g.emp_no = e.emp_no
order by e.emp_no;

# select emp_no, avg(score) as score from hr_grade group by emp_no;
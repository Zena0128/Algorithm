-- 코드를 입력하세요
SELECT name, datetime from animal_ins as i where not exists (select 1 from animal_outs as o where i.animal_id = o.animal_id) order by datetime limit 3;
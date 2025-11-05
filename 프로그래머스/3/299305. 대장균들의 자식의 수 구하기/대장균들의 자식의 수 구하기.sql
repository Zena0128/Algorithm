# select id, count(*) as child_count from ecoli_data group by id;
select t1.id, case when t2.child_count is null then 0 else t2.child_count end as child_count from ecoli_data as t1 left outer join (select parent_id, count(*) as child_count from ecoli_data group by parent_id) as t2 on t1.id = t2.parent_id order by id; 

# select parent_id, count(*) as child_count from ecoli_data group by parent_id;
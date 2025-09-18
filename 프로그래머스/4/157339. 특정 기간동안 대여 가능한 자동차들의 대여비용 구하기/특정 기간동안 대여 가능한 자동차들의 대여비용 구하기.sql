-- 코드를 입력하세요
SELECT c.car_id, c.car_type, floor(c.daily_fee * (100-d.discount_rate) * 0.01) * 30 as fee
from CAR_RENTAL_COMPANY_CAR as c join (select car_type, discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where duration_type = '30일 이상') as d
on c.car_type = d.car_type
where floor(c.daily_fee * (100-d.discount_rate) * 0.01) * 30 >= 500000 and floor(c.daily_fee * (100-d.discount_rate) * 0.01) * 30 < 2000000
and c.car_id not in (select distinct car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date <= '2022-11-30' AND end_date >= '2022-11-01')
order by fee desc, c.car_type, c.car_id desc;

# select car_type, discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where duration_type like '30%';

# select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where end_date < '2022-11-01'group by car_id;
# select distinct car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date between '2022-11-01' and '2022-11-30' or end_date between '2022-11-01' and '2022-11-30';
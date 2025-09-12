SELECT c.car_id,
       CASE 
           WHEN EXISTS (
               SELECT 1
               FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
               WHERE h.car_id = c.car_id
                 AND h.start_date <= '2022-10-16'
                 AND '2022-10-16' <= h.end_date
           )
           THEN '대여중'
           ELSE '대여 가능'
       END AS availability
FROM (SELECT DISTINCT car_id
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) c
ORDER BY c.car_id DESC;
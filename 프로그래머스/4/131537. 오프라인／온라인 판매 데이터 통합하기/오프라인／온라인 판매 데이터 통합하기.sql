-- 코드를 입력하세요
SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date, product_id, user_id, sales_amount from online_sale where sales_date between '2022-03-01' and '2022-03-31' 
union all
select DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date, product_id, null+0 as user_id, sales_amount from offline_sale where sales_date between '2022-03-01' and '2022-03-31'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;


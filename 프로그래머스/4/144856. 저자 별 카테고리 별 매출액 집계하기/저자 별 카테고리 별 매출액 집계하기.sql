-- 코드를 입력하세요
# SELECT book_id, sum(sales) as sales from book_sales where sales_date between '2022-01-01' and '2022-01-31' group by book_id;

select a.author_id, a.author_name, b.category, sum(b.price * bs.sales) as total_sales
from book as b, author as a, (SELECT book_id, sum(sales) as sales from book_sales where sales_date between '2022-01-01' and '2022-01-31' group by book_id) as bs
where b.author_id = a.author_id and b.book_id = bs.book_id
group by a.author_id, a.author_name, b.category
order by a.author_id, b.category desc;
select b.category CATEGORY, sum(bs.sales) TOTAL_SALES
from book b 
inner join (select * from book_sales
      where sales_date between '2022-01-01' and '2022-01-31') bs 
      on b.book_id = bs.book_id
group by b.category
order by b.category asc;
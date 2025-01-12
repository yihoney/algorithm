    SELECT a.author_id
         , a.author_name
         , b.category
         , SUM(bs.sales * b.price) total_sales
      FROM book_sales bs
INNER JOIN book b
        ON b.book_id = bs.book_id
INNER JOIN author a
        ON a.author_id = b.author_id
     WHERE bs.sales_date LIKE '2022-01%'
  GROUP BY b.author_id, b.category
  ORDER BY a.author_id
         , b.category DESC
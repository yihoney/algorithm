  SELECT LEFT(product_code, 2) category
       , COUNT(product_id) products
    FROM product
GROUP BY category
ORDER BY category
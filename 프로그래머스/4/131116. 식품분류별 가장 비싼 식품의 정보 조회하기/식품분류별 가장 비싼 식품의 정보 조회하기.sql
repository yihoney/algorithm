SELECT fp1.category
         , fp1.price AS max_price
         , fp1.product_name
      FROM food_product fp1
INNER JOIN (
                  SELECT category
                       , MAX(price) AS price
                    FROM food_product
                   WHERE category IN ('과자', '국', '김치', '식용유')
                GROUP BY category
           ) fp2
        ON fp1.category = fp2.category 
       AND fp1.price = fp2.price
  ORDER BY max_price DESC;
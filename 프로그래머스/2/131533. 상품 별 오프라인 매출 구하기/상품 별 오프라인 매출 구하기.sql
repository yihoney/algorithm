    SELECT p.product_code AS PRODUCT_CODE
         , SUM(p.price * os.sales_amount) AS SALES
      FROM product p
INNER JOIN offline_sale os 
        ON p.product_id = os.product_id
  GROUP BY p.product_code
  ORDER BY SALES DESC, p.product_code;
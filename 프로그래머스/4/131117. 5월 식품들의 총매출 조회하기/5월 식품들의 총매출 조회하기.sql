   SELECT fp.product_id AS PRODUCT_ID
        , fp.product_name AS PRODUCT_NAME
        , SUM(fp.price * fo.amount) AS TOTAL_SALES
     FROM food_order fo
LEFT JOIN food_product fp ON fo.product_id = fp.product_id
    WHERE fo.produce_date LIKE '2022-05%'
 GROUP BY fo.product_id
 ORDER BY TOTAL_SALES DESC, fo.product_id;
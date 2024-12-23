  SELECT warehouse_id WAREHOUSE_ID
       , warehouse_name WAREHOUSE_NAME
       , address ADDRESS
       , IFNULL(freezer_yn, 'N') FREEZER_YN
    FROM food_warehouse fw
   WHERE address LIKE '경기%'
ORDER BY warehouse_id;
    SELECT YEAR(os.sales_date) AS YEAR
         , MONTH(os.sales_date) AS MONTH
         , COUNT(DISTINCT os.user_id) AS PURCHASED_USERS
         , ROUND(COUNT(DISTINCT os.user_id) / (
                                                SELECT COUNT(user_id)
                                                  FROM user_info 
                                                 WHERE YEAR(joined) = 2021
                                              ), 1) AS PUCHASED_RATIO
      FROM online_sale os
INNER JOIN user_info ui 
        ON os.user_id = ui.user_id
     WHERE YEAR(ui.joined) = 2021
  GROUP BY year, month
  ORDER BY year, month;
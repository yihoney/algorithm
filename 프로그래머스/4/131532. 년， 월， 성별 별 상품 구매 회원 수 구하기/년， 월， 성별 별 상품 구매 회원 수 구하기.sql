SELECT YEAR(os.sales_date) YEAR
         , MONTH(os.sales_date) MONTH
         , ui.gender GENDER
         , COUNT(DISTINCT ui.user_id) USERS
      FROM online_sale os
INNER JOIN user_info ui
        ON os.user_id = ui.user_id
  GROUP BY year, month, gender
    HAVING ui.gender IS NOT NULL
  ORDER BY year, month, gender;
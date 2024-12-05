SELECT ri.food_type AS FOOD_TYPE
       , ri.rest_id AS REST_ID
       , ri.rest_name AS REST_NAME
       , ri.favorites AS FAVORITES
    FROM rest_info AS ri
   WHERE (ri.food_type, ri.favorites) IN (
                                            SELECT food_type
                                                 , MAX(favorites)
                                              FROM rest_info
                                          GROUP BY food_type
                                         )
ORDER BY ri.food_type desc;
    SELECT ii.ingredient_type AS INGREDIENT_TYPE
         , SUM(fh.total_order) AS TOTAL_ORDER
      FROM first_half AS fh
INNER JOIN icecream_info AS ii
        ON fh.flavor = ii.flavor
  GROUP BY ii.ingredient_type
  ORDER BY TOTAL_ORDER;
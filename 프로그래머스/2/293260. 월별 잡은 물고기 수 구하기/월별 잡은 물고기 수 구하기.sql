  SELECT COUNT(fi.id) AS FISH_COUNT
       , MONTH(fi.time) AS MONTH
    FROM fish_info fi
GROUP BY MONTH
ORDER BY MONTH;
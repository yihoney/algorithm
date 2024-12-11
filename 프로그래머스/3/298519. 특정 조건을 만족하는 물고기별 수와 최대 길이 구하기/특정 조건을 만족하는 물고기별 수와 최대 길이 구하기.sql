  SELECT COUNT(fi.id) AS FISH_COUNT
       , MAX(fi.length) AS MAX_LENGTH
       , fi.fish_type AS FISH_TYPE
    FROM fish_info fi
GROUP BY fi.fish_type
  HAVING AVG(IFNULL(fi.length, 10)) >= 33
ORDER BY fi.fish_type;
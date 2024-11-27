  SELECT fi.id AS ID
       , fi.length AS LENGTH
    FROM fish_info fi
ORDER BY fi.length DESC
       , fi.id
   LIMIT 10;
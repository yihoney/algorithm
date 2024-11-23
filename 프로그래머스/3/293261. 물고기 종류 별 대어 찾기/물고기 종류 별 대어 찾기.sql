SELECT fi.id AS ID
     , fni.fish_name AS FISH_NAME
     , fi.length AS LENGTH
FROM fish_info fi
INNER JOIN ( SELECT fi.fish_type
                   , MAX(fi.length) AS length
                FROM fish_info fi
            GROUP BY fi.fish_type) t 
        ON fi.fish_type = t.fish_type AND fi.length = t.length
INNER JOIN fish_name_info fni
        ON fi.fish_type = fni.fish_type
  ORDER BY fi.id;


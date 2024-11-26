    SELECT ped.id AS ID
         , IFNULL(ced.child_count, 0) AS CHILD_COUNT
      FROM ecoli_data AS ped
 LEFT JOIN (
              SELECT parent_id
                   , COUNT(id) AS child_count
                FROM ecoli_data ed
            GROUP BY parent_id
           ) AS ced
        ON ped.id = ced.parent_id
  ORDER BY ped.id;
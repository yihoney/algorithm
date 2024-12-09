SELECT id AS ID 
     , CASE WHEN size_rank = 1 THEN 'CRITICAL'
            WHEN size_rank = 2 THEN 'HIGH'
            WHEN size_rank = 3 THEN 'MEDIUM'
            ELSE 'LOW' 
       END AS COLONY_NAME
  FROM (
            SELECT id
                 , NTILE(4) OVER (ORDER BY size_of_colony DESC) size_rank 
              FROM ecoli_data
       ) r
ORDER BY id;
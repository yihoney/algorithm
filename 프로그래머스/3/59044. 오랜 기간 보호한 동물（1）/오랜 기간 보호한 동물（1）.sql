  SELECT ai.name AS NAME
       , ai.datetime AS DATETIME
    FROM animal_ins ai
   WHERE ai.animal_id NOT IN (
                                SELECT animal_id
                                  FROM animal_outs
                             )
ORDER BY ai.datetime
   LIMIT 3;
  SELECT ed.id AS ID
       , CASE WHEN ed.size_of_colony <= 100 THEN 'LOW'
              WHEN ed.size_of_colony > 100 AND ed.size_of_colony <= 1000 THEN 'MEDIUM'
              ELSE 'HIGH' END AS SIZE
    FROM ecoli_data ed
ORDER BY ed.id;
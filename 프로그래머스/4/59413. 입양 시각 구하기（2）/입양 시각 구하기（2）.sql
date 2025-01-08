WITH RECURSIVE time AS (
                          SELECT 0 AS hour
                          UNION ALL
                          SELECT hour + 1
                            FROM time
                           WHERE hour < 23
),
animal AS (
            SELECT HOUR(ao.datetime) AS hour
                 , COUNT(ao.animal_id) AS cnt
              FROM animal_outs ao
          GROUP BY hour
)
    SELECT time.hour AS HOUR
         , IFNULL(animal.cnt, 0) AS COUNT
      FROM time
 LEFT JOIN animal
        ON animal.hour = time.hour
  ORDER BY time.hour asc;
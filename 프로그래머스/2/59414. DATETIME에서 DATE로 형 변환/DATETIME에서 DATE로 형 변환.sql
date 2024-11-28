  SELECT ai.animal_id AS ANIMAL_ID
       , ai.name AS NAME
       , DATE_FORMAT(ai.datetime, '%Y-%m-%d') AS 날짜
    FROM animal_ins AS ai
ORDER BY ai.animal_id;
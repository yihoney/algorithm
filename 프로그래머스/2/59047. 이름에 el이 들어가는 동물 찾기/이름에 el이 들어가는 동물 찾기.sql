   SELECT ai.animal_id AS ANIMAL_ID
        , ai.name AS NAME
     FROM animal_ins ai
    WHERE INSTR(LOWER(ai.name), 'el') != 0
      AND ai.animal_type = 'Dog'
 ORDER BY ai.name;
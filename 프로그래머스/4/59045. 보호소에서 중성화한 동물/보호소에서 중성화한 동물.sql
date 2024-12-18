SELECT ai.animal_id AS ANIMAL_ID
        , ai.animal_type AS ANIMAL_TYPE
        , ai.name AS NAME
     FROM animal_ins ai
LEFT JOIN animal_outs ao
       ON ai.animal_id = ao.animal_id
    WHERE INSTR(ai.sex_upon_intake, 'Intact') <> 0
      AND (INSTR(ao.sex_upon_outcome, 'Spayed') <> 0
           OR INSTR(ao.sex_upon_outcome, 'Neutered') <> 0)
 ORDER BY ai.animal_id;
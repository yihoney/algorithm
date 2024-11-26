  SELECT ai.animal_id ANIMAL_ID
       , ai.name NAME
       , ai.sex_upon_intake SEX_UPON_INTAKE
    FROM animal_ins ai
   WHERE ai.name IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ai.animal_id;
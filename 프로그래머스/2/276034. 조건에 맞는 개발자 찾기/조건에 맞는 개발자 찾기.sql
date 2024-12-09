  SELECT d.id AS ID
       , d.email AS EMAIL
       , d.first_name AS FIRST_NAME
       , d.last_name AS LAST_NAME
    FROM developers d
   WHERE d.skill_code & (
                           SELECT SUM(s.code)
                             FROM skillcodes s
                            WHERE s.name IN ('C#', 'Python')
                        )
ORDER BY d.id;
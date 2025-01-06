    SELECT CASE 
           WHEN GROUP_CONCAT(s.category) LIKE '%Front End%' AND GROUP_CONCAT(s.name) LIKE '%Python%' THEN 'A'
           WHEN GROUP_CONCAT(s.name) LIKE '%C#%' THEN 'B'
           WHEN GROUP_CONCAT(s.category) LIKE '%Front End%' THEN 'C' 
           END AS GRADE
         , d.id AS ID
         , d.email AS EMAIL
      FROM developers d
INNER JOIN skillcodes s
        ON d.skill_code & s.code = s.code
  GROUP BY d.id, d.email
    HAVING grade IS NOT NULL
  ORDER BY GRADE
         , ID
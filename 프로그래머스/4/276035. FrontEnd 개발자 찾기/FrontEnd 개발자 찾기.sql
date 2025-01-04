SELECT DISTINCT d.id ID
              , d.email EMAIL
              , d.first_name FIRST_NAME
              , d.last_name LAST_NAME
           FROM developers d
     INNER JOIN skillcodes s
             ON d.skill_code & s.code = s.code
          WHERE s.category = 'Front End'
       ORDER BY d.id;
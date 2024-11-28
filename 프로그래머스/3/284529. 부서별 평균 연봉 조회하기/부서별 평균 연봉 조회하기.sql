    SELECT hd.dept_id AS DEPT_ID
         , hd.dept_name_en AS DEPT_NAME_EN
         , ROUND(AVG(he.sal), 0) AS AVG_SAL
      FROM hr_department hd
RIGHT JOIN hr_employees he
        ON hd.dept_id = he.dept_id
  GROUP BY he.dept_id
  ORDER BY avg_sal DESC;
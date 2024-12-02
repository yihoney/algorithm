SELECT crcc.car_type AS CAR_TYPE
     , COUNT(crcc.car_type) AS CARS
  FROM car_rental_company_car crcc
 WHERE INSTR(crcc.options, '통풍시트')
    OR INSTR(crcc.options, '열선시트')
    OR INSTR(crcc.options, '가죽시트')
 GROUP BY crcc.car_type
 ORDER BY crcc.car_type;
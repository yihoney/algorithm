   SELECT *
     FROM car_rental_company_car crcc
    WHERE INSTR(crcc.options, '네비게이션') <> 0
 ORDER BY crcc.car_id DESC;
    SELECT crcc.car_id AS CAR_ID
      FROM car_rental_company_rental_history AS crcrh
INNER JOIN car_rental_company_car AS crcc
        ON crcrh.car_id = crcc.car_id
     WHERE crcc.car_type = '세단'
  GROUP BY crcc.car_id
    HAVING MAX(CASE WHEN MONTH(crcrh.start_date) >= 10 
                    THEN 1 
                    ELSE 0 END) = 1
  ORDER BY crcc.car_id DESC;
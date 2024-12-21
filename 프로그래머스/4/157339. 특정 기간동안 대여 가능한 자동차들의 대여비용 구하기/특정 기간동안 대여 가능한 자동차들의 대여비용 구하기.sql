    SELECT crcc.car_id AS CAR_ID
         , crcc.car_type AS CAR_TYPE
         , TRUNCATE(crcc.daily_fee * 30 * (100 - crcdp.discount_rate) * 0.01, -1) AS FEE
      FROM car_rental_company_car crcc
 LEFT JOIN car_rental_company_discount_plan crcdp
        ON crcc.car_type = crcdp.car_type
       AND crcdp.duration_type = '30일 이상'
     WHERE crcc.car_type IN ('세단', 'SUV')
       AND crcc.daily_fee * 30 * (100 - crcdp.discount_rate) * 0.01 >= 500000 
       AND crcc.daily_fee * 30 * (100 - crcdp.discount_rate) * 0.01 < 2000000
       AND crcc.car_id NOT IN (
                                    SELECT crcrh.car_id
                                      FROM car_rental_company_rental_history crcrh
                                     WHERE crcrh.end_date > '2022-11-01' 
                                       AND crcrh.start_date <= '2022-11-30'
                              )
  ORDER BY FEE DESC
         , crcc.car_type
         , crcc.car_id DESC;
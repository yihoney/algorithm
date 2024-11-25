SELECT MONTH(crcrh.start_date) AS MONTH
       , crcrh.car_id CAR_ID
       , count(*) AS RECORDS
   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
   WHERE CAR_ID IN ( 
                     SELECT crcrh.car_id
                       FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
                      WHERE crcrh.start_date BETWEEN '2022-08-01' AND '2022-10-31'
                   GROUP BY crcrh.car_id
                     HAVING COUNT(*) >= 5 
                    )
     AND crcrh.start_date BETWEEN '2022-08-01' AND '2022-10-31'                
GROUP BY MONTH, CAR_ID
  HAVING RECORDS <> 0
ORDER BY MONTH, CAR_ID DESC;
  SELECT a.mcdp_cd AS 진료과코드
       , COUNT(a.mcdp_cd) AS 5월예약건수
    FROM appointment AS a
   WHERE DATE_FORMAT(a.apnt_ymd, '%Y-%m') = '2022-05'
GROUP BY a.mcdp_cd
ORDER BY 5월예약건수, a.mcdp_cd;
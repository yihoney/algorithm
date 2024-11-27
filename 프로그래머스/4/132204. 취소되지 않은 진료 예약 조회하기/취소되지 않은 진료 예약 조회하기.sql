    SELECT a.apnt_no AS APNT_NO
         , p.pt_name AS PT_NAME
         , a.pt_no AS PT_NO
         , a.mcdp_cd AS MCDP_CD
         , d.dr_name AS DR_NAME
         , a.apnt_ymd AS APNT_YMD
     FROM appointment a
LEFT JOIN doctor d 
       ON a.mddr_id = d.dr_id
LEFT JOIN patient p 
       ON a.pt_no = p.pt_no
    WHERE a.apnt_cncl_yn = 'N' 
      AND DATE_FORMAT(a.apnt_ymd, '%Y%m%d') = '20220413' 
      AND a.mcdp_cd = 'CS'
 ORDER BY apnt_ymd;
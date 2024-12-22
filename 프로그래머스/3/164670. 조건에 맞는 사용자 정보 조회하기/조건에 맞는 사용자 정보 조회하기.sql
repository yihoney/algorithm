SELECT ugu.user_id USER_ID
         , ugu.nickname NICKNAME
         , CONCAT(ugu.city, ' ', ugu.street_address1, ' ', ugu.street_address2) 전체주소
         , INSERT(INSERT(ugu.tlno, 4, 0, '-'), 9, 0, '-') 전화번호
      FROM used_goods_board ugb
INNER JOIN used_goods_user ugu
        ON ugb.writer_id = ugu.user_id 
  GROUP BY ugb.writer_id
    HAVING COUNT(ugb.writer_id) >= 3
  ORDER BY ugu.user_id DESC
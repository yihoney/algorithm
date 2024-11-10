SELECT ugb.board_id
     , ugb.writer_id
     , ugb.title
     , ugb.price
     , CASE 
            WHEN ugb.status = 'SALE' THEN '판매중'
            WHEN ugb.status = 'RESERVED' THEN '예약중'
            WHEN ugb.status = 'DONE' THEN '거래완료'
       END AS status
FROM used_goods_board ugb
WHERE DATE_FORMAT(ugb.created_date, '%Y-%m-%d') = '2022-10-05'
ORDER BY ugb.board_id DESC;
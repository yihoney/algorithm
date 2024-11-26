SELECT mp.member_name AS MEMBER_NAME
     , rr.review_text AS REVIEW_TEXT
     , DATE_FORMAT(rr.review_date, '%Y-%m-%d') AS REVIEW_DATE
 FROM member_profile mp
RIGHT JOIN rest_review rr
        ON mp.member_id = rr.member_id
     WHERE rr.member_id IN (
                                SELECT member_id
                                  FROM rest_review 
                                GROUP BY member_id
                                HAVING COUNT(*) = (
                                                        SELECT COUNT(rest_id) AS count
                                                          FROM rest_review
                                                      GROUP BY member_id
                                                      ORDER BY count DESC
                                                         LIMIT 1
                                                  )
                           )
  ORDER BY rr.review_date, rr.review_text;
  
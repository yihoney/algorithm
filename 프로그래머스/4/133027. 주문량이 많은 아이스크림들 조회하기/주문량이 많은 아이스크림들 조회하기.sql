    SELECT j.flavor AS FLAVOR
      FROM first_half AS fh
RIGHT JOIN july j ON fh.shipment_id = j.shipment_id
  GROUP BY flavor
  ORDER BY SUM(fh.total_order) + SUM(j.total_order) DESC
     LIMIT 3;
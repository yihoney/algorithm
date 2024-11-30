    SELECT ii.item_id AS ITEM_ID
         , ii.item_name AS ITEM_NAME
      FROM item_info AS ii
RIGHT JOIN item_tree AS it
        ON it.item_id = ii.item_id
     WHERE it.parent_item_id IS NULL
  ORDER BY ii.item_id;
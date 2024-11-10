SELECT ii.item_id
     , ii.item_name
     , ii.rarity
FROM item_info ii
LEFT OUTER JOIN item_tree it 
ON ii.item_id = it.parent_item_id
WHERE it.item_id IS NULL
ORDER BY ii.item_id DESC;
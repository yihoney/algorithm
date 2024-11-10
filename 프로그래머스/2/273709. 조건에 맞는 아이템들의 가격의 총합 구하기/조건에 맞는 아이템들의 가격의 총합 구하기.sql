SELECT SUM(ii.price) AS TOTAL_PRICE
FROM item_info ii
WHERE ii.rarity = 'LEGEND'
GROUP BY ii.rarity;
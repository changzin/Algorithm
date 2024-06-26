# -- 코드를 작성해주세요
# SELECT ITEM_ID, ITEM_NAME, RARITY
# FROM ITEM_INFO
# WHERE NOT ITEM_ID = ANY(SELECT PARENT_ITEM_ID AS ITEM_ID FROM ITEM_TREE)
# ORDER BY ITEM_ID


SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID NOT IN(SELECT ITEM_ID
    FROM ITEM_INFO
    WHERE ITEM_ID IN (SELECT PARENT_ITEM_ID FROM ITEM_TREE))
ORDER BY ITEM_ID DESC
;
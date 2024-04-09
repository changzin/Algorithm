-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, TO_CHAR(OUT_DATE, 'YYYY-MM-DD'), 
    CASE
    WHEN TO_CHAR(OUT_DATE, 'MM-DD') <= '05-01' THEN '출고완료'
    WHEN OUT_DATE IS NULL THEN '출고미정' 
    ELSE '출고대기'
    END AS 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID ASC;
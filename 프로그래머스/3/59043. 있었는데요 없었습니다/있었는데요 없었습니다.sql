-- 코드를 입력하세요
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS a, ANIMAL_OUTS b
WHERE A.ANIMAL_ID=B.ANIMAL_ID
    AND A.DATETIME > B.DATETIME
ORDER BY A.DATETIME ASC;
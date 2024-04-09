-- 코드를 입력하세요
SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS A
WHERE NAME IS NOT NULL
    AND (SELECT COUNT(A.NAME) FROM ANIMAL_INS WHERE A.NAME=NAME GROUP BY NAME) >= 2
GROUP BY NAME
ORDER BY NAME;